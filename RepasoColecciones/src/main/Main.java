package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.Vendedor;
import modelo.Venta;
import modelo.dao.Modificador;

public class Main {
	
	public static void main(String[] args) {
		Modificador mod = new Modificador();
		HashMap<String,ArrayList<Float>> listaVentas = mod.resumirListaVendedor();
		HashMap<String, Float> listaTotalVentas = mod.mapaVentasTotales(listaVentas);
		HashMap<Float, String> impCod = mod.ordenarMapa(mod.obtenerVentaPrecio());
		ArrayList<String> cadenas = mod.ordenarArrayList();
		Map<String, String> map = mod.mapaOrdenado();
		System.out.println("fin");
		
	}

}
