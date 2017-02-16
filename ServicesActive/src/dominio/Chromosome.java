package dominio;

import java.util.ArrayList;

public class Chromosome {
	private ArrayList<Wsdl> chromosomeList;
	
	public Chromosome (){
		chromosomeList = new ArrayList<Wsdl>();
		
	}
	
	public void addGen(Wsdl w){
		chromosomeList.add(w);
	}
	
	public boolean equals(Object o){
		return this.equals(o);
	}
	
	public int length(){
		return chromosomeList.size();
	}
	
	public Wsdl getGen(int i){
		return chromosomeList.get(i);
	}
	
	public ArrayList<Wsdl> getServices(){
		return this.chromosomeList;
	}

}
