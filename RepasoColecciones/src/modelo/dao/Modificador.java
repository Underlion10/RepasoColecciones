package modelo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import modelo.Vendedor;
import modelo.Venta;

public class Modificador {
	
	public Map<String, String> mapaOrdenado() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Lionel", "Hijo");
		map.put("Ana", "Madre");
		map.put("Paula", "Hija");
		map.put("Fran", "Padre");
		map.put("Bac", "G");
		return map;
	}
	
	public ArrayList<String> ordenarArrayList() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Lionel");
		strings.add("Ana");
		strings.add("Paula");
		strings.add("Fran");
		Collections.sort(strings);
		return strings;
	}
	
	public HashMap<Float, String> ordenarMapa(HashMap<Float, String> obtenerVentaFichero){
		Set<Float> claves = obtenerVentaFichero.keySet();
		TreeSet<Float> claves2 = new TreeSet<Float>(claves);
		HashMap<Float, String> obtenerOrdenado = new HashMap<Float, String>();
		for(Float clave : claves2)
			obtenerOrdenado.put(clave, obtenerVentaFichero.get(clave));
		return obtenerOrdenado;
	}
	
	public HashMap<Float, String> obtenerVentaPrecio(){
		HashMap<Venta, Vendedor> ventaV = obtenerDatosFicheros();
		HashMap<Float, String> ventaPrecio = new HashMap<Float, String>();
		Set<Venta> claves = ventaV.keySet();
		for(Venta clave : claves)
			ventaPrecio.put(clave.getImporte(), ventaV.get(clave).getCodigoVendedor());
		return ventaPrecio;
	}
	
	public HashMap<String, Float> mapaVentasTotales(HashMap<String, ArrayList<Float>> lista ){
		HashMap<String, Float> listaDev = new HashMap<String, Float>();
		Set<String> claves = lista.keySet();
		for(String clave: claves) {
			ArrayList<Float> nums = lista.get(clave);
			float numTot = 0;
			for(Float num: nums)
				numTot+= num;
			listaDev.put(clave, numTot);
		}
		return listaDev;
	}
	
	public HashMap<String, ArrayList<Float>> resumirListaVendedor(){
	HashMap<String, ArrayList<Float>> mapaVentasVendedores = new HashMap<String, ArrayList<Float>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("ficheros/ventasDeptoAlmacen.txt"));
			while((br.ready())) {
				String[] datos = br.readLine().split("%");
				if(mapaVentasVendedores.containsKey(datos[1])) {
					mapaVentasVendedores.get(datos[1]).add(Float.parseFloat(datos[2]));
				} else {
					mapaVentasVendedores.put(datos[1], new ArrayList<Float>());
					mapaVentasVendedores.get(datos[1]).add(Float.parseFloat(datos[2]));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return mapaVentasVendedores;

	}
	
	public HashMap<Venta, Vendedor> obtenerDatosFicheros() {
	HashMap<Venta,Vendedor> mapaVentasVendedores = new HashMap<Venta, Vendedor>();
	ArrayList<Venta> ventas = new ArrayList<Venta>();
	ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		
	try {
		BufferedReader br = new BufferedReader(new FileReader("ficheros/ventasDeptoAlmacen.txt"));
		String linea;
		while((linea = br.readLine()) != null) {
			String[] datos = linea.split("%");
			String fechaVenta = datos[0];
			LocalDate fechaVentadef = LocalDate.of(Integer.parseInt(fechaVenta.substring(4, 8)), 
					Integer.parseInt(fechaVenta.substring(2, 4)), Integer.parseInt(fechaVenta.substring(0, 2)));
			String codigoVendedor = datos[1];
			Float importe = Float.parseFloat(datos[2]);
			Vendedor vendedor = new Vendedor(codigoVendedor, importe);
			if(mapaVentasVendedores.containsValue(vendedor)) {
				vendedor.setImporteTotal(vendedor.getImporteTotal() + importe);
				continue;
			} else {
				Venta venta = new Venta(vendedor, fechaVentadef, importe);
				ventas.add(new Venta(vendedor, fechaVentadef, importe));
				mapaVentasVendedores.put(venta, vendedor);
			}
		}
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	
	return mapaVentasVendedores;
	
	}

}
