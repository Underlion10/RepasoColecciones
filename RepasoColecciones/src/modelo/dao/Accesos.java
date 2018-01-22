package modelo.dao;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Persona;
import modelo.Vehiculo;

public class Accesos {
	private ArrayList<ArrayList<Persona>> personas1;
	private ArrayList <HashMap<String, Vehiculo>> vehiculos1;
	private HashMap <Integer, HashMap <String, String>> objetos1;
	
	private HashMap <Integer, ArrayList <ArrayList<Persona>>> persona3;
	
	private ArrayList <HashMap< String, ArrayList <HashMap <Integer, Vehiculo>>>> vehiculos3;
	
	public HashMap<String, Integer> ventasDepto (String rutaFicheroDepto)
	{
		return null;
		
	}
	
	
	public void inicializar(){
		// personas1
		
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		Persona p4 = new Persona();
		
		ArrayList<Persona> al1 = new ArrayList<Persona>();
		al1.add(p1);
		al1.add(p2);
		personas1.add(al1);
	
		
		ArrayList<Persona> al2 = new ArrayList<Persona>();
		al2.add(p3);
		al2.add(p4);
		personas1.add(al2);
		
		// vehiculos1
		
		vehiculos1 = new ArrayList <HashMap<String, Vehiculo>>();
		
		Vehiculo v1 = new Vehiculo();
		Vehiculo v2 = new Vehiculo();
		Vehiculo v3 = new Vehiculo();
		Vehiculo v4 = new Vehiculo();
		
		 HashMap<String, Vehiculo> hMap1 = new HashMap<String,Vehiculo>();
		hMap1.put(v1.getMatricula(), v1);
		hMap1.put(v2.getMatricula(), v2);
		
		HashMap<String, Vehiculo> hMap2 = new HashMap<String,Vehiculo>();
		hMap2.put(v3.getMatricula(), v3);
		hMap2.put(v4.getMatricula(), v4);
		
		vehiculos1.add(hMap1);
		vehiculos1.add(hMap2);
		
		//objetos1
		
		objetos1 = new HashMap <Integer, HashMap <String, String>>();
		
		HashMap<String, String> hMap3 = new HashMap <String, String>();
		hMap3.put("nif1", "Juan");
		hMap3.put("nif2", "Pedro");
		
		HashMap<String, String> hMap4 = new HashMap <String, String>();
		hMap4.put("nif3", "Manuel");
		hMap4.put("nif4", "Carmen");
		
		objetos1.put(123, hMap3);
		
		objetos1.put(456, hMap4);
	}
}
