package principal;

import java.util.HashMap;

import dominio.Chromosome;
import dominio.FitnessFunction;
import dominio.ReadData;
import dominio.Wsdl;

public class ImportCsv {
	
	public static void  main(String[] arg){
			HashMap<String, Integer> ponderaciones = new HashMap<>();
			ReadData datos = new ReadData();
			
			datos.ReadDataCsv();	
			
            ponderaciones.put(Wsdl.AVAILABILITY, 3);
            ponderaciones.put(Wsdl.LATENCY, 5);
            ponderaciones.put(Wsdl.COMPLIANCE, 4);
            
             System.out.println(FitnessFunction.FunctionGoalWeighted8(datos.generateCromosoma(), ponderaciones));
           

//             System.out.println("Lista de Wsdl totales: ");
//             ArrayList<Wsdl> allWsdl = datos.getAllWsdlInterface(); 
//             System.out.println(allWsdl.size());
//             for (int i = 0; i < allWsdl.size(); i++) {
//            	 System.out.println(allWsdl.get(i).getService_name());
//            	 System.out.println(allWsdl.get(i).getInterfaz());
//             }
//             
     			
             System.out.println("Cromosoma generado: ");
             Chromosome c = datos.generateCromosoma();
             for (int i = 0; i < c.length(); i++) {
            	 System.out.println(c.getGen(i).getService_name());
			}
             
//             System.out.println("Cromosoma generado con map: ");
//             Chromosome c2 = datos.generateCromosoma();
//             for (int i = 0; i < c2.length(); i++) {
//            	 System.out.println(c2.getGenMap("iniciarSesion").getService_name());
//			}

	}
	
}
