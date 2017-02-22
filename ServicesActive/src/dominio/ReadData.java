package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.csvreader.CsvReader;


public class ReadData {
	ArrayList<Wsdl>  service = new ArrayList<>();
	Chromosome crom = new Chromosome();
//	ArrayList<String> posInterface = new ArrayList<>();
	LinkedHashMap<String, ArrayList<Wsdl>> serviceInterface = new LinkedHashMap<>(0, (float)0.75, false);
//	HashMap<String, ArrayList<Wsdl>> mapWsdlInterface = new HashMap<>();
	
	public void ReadDataCsv (){
		try{
			CsvReader wsdl_import = new CsvReader ("sources/services.csv");
			 
	            while (wsdl_import.readRecord()) {
	            	if (wsdl_import.get(0).startsWith("##")){
	            		continue;
	            	}
	                Double response_time = Double.valueOf(wsdl_import.get(0));
	                Double availability = Double.valueOf(wsdl_import.get(1));
	                Double throughput = Double.valueOf(wsdl_import.get(2));
	                Double successability = Double.valueOf(wsdl_import.get(3));
	                Double reliability = Double.valueOf(wsdl_import.get(4));             	
	            	Double compliance = Double.valueOf(wsdl_import.get(5));
	            	Double best_practice = Double.valueOf(wsdl_import.get(6));
	            	Double latency = Double.valueOf(wsdl_import.get(7));
	            	String documentation = wsdl_import.get(8);
	            	String service_name = wsdl_import.get(9);
	            	String wsdl_address = wsdl_import.get(10);
	            	String interfaz = wsdl_import.get(11);
	            	Wsdl w = new Wsdl(response_time, availability, throughput, successability, reliability,
	            			compliance, best_practice, latency, documentation, service_name, wsdl_address, interfaz );
	            	service.add(w);
//	            	cargaInterfaz(interfaz);
	            	listWsdl(interfaz, w);
	            }
	            	            	           
	             wsdl_import.close();
			
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void cargaInterfaz(String interfaz){
//		if (!posInterface.contains(interfaz)){
//			posInterface.add(interfaz);
//		}
//	}
	
//	public int getPosInterfaz(String interfaz){
//		return posInterface.indexOf(interfaz);	
//	}
	
//	public ArrayList<String> getPosInterfaz(){
//		return this.posInterface;
//	}
	
	public void listWsdl(String interfaz, Wsdl w ){
		if (serviceInterface.containsKey(interfaz)){
			//System.out.println("Existia la interfaz: " + interfaz);
            	ArrayList<Wsdl> interfazWdsls = serviceInterface.get(interfaz);
            	interfazWdsls.add(w);
		}
		else{
			ArrayList<Wsdl> interfazWdsls = new ArrayList<>();
			//System.out.println("NO existia la interfaz: " + interfaz + " por eso la creo.");
            	interfazWdsls.add(w);
            	serviceInterface.put(interfaz, interfazWdsls);
		}
	}
	
//	public void listWsdl2(String interfaz, Wsdl w ){
//		if (mapWsdlInterface.containsKey(interfaz)){
//			//System.out.println("Existia la interfaz: " + interfaz);
//            	ArrayList<Wsdl> interfazWdsls = mapWsdlInterface.get(interfaz);
//            	interfazWdsls.add(w);
//		}
//		else{
//			ArrayList<Wsdl> interfazWdsls = new ArrayList<>();
//			//System.out.println("NO existia la interfaz: " + interfaz + " por eso la creo.");
//            	interfazWdsls.add(w);
//            	mapWsdlInterface.put(interfaz, interfazWdsls);
//		}
//	}
	
	public LinkedHashMap<String, ArrayList<Wsdl>> getWsdlInterface (){
		return this.serviceInterface;
	}
	
	public Chromosome getCromosoma(){
		return this.crom;
	}
	
	public ArrayList<Wsdl> getAllWsdlInterface(){
		return this.service;
	}
	
	public Chromosome generateCromosoma (){
		Chromosome ch = new Chromosome();
		ArrayList<Wsdl> wsdls;
		Iterator it = serviceInterface.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, ArrayList<Wsdl>> m = (Map.Entry<String, ArrayList<Wsdl>>)it.next();
			wsdls =m.getValue();
			int valor = (int) (Math.random()*wsdls.size());
			Wsdl w = wsdls.get(valor);
			ch.addGen(w);
		}
		return ch;		
	}
	
//	public Chromosome generateCromosoma (){
//		Chromosome ch = new Chromosome();
//		ArrayList<Wsdl> wsdls;
//		Iterator it = mapWsdlInterface.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry<String, ArrayList<Wsdl>> m = (Map.Entry<String, ArrayList<Wsdl>>)it.next();
//			wsdls =m.getValue();
//			int valor = (int) (Math.random()*wsdls.size());
//			Wsdl w = wsdls.get(valor);
//			ch.addGenMap(m.getKey(), w);
//		}
//		return ch;		
//	}
	
}
