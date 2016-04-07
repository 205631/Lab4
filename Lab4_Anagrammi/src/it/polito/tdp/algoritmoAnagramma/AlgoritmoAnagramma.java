package it.polito.tdp.algoritmoAnagramma;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoAnagramma {

	public List<String> parola;//ogni posizione della lista ha un carattere della parola completa
	public int lunghezzaParola;//lunghezza della parola completa e di conseguenza della lista
	
	Integer ris=0;
	
	//COSTRUTTORE CHE MI CREA UNA LISTA DI STRINGHE CHE CONTINE OGNI CARATTERE DELLA PAROLA PASSATA
	//COME PARAMENTRO
	
	public AlgoritmoAnagramma(String parola) {
		super();
		this.lunghezzaParola = parola.length();
		this.parola=new ArrayList<String>();
		
		int j=1;
		for(int i=0;i<lunghezzaParola;i++){
			this.parola.add(parola.substring(i,j));
			j++;
		}
	}
	
	//METODO CHE RICHIAMA UN ALTRO METODO PER LA RISOLUZIONE DI TUTTI I POSSIBILI ANAGRAMMI
	public List<String> permuta(){
		
		List<List<String>> result= new ArrayList<List<String>>();
		
		this.permuta_ric(0,lunghezzaParola,parola,new ArrayList<String>(),result);
		

		List<String>rr=new ArrayList<String>();
		for(int i=0;i<result.size();i++){
			String risu="";
			for(String s:result.get(i)){
				risu+=s;
			}
			rr.add(risu);
		}
		
		return rr;
	}
	
	//RICORSIONE UTILIZZATA PER LA SOLUZIONE ANAGRAMMA
	private void permuta_ric(int step,int lunghezza,List<String> partenza,
								List<String> risultato,List<List<String>> result){
		
		if(step==lunghezza){
			//siamo alla fine della parola
			List<String> e=new ArrayList<String>(risultato);
			result.add(e);
			ris++;
		}else{
			for(int i=0;i<lunghezza;i++){
				if(risultato.contains(partenza.get(i))==false){
					//aggiungo
					risultato.add(partenza.get(i));
					//provo
					permuta_ric(step+1,lunghezza,partenza,risultato,result);
					//tolgo
					risultato.remove(partenza.get(i));
				}
			}
		}
	}
	
	//RITORNA IL NUMERO DI SOLUZIONI TROVATE
	public int get(){
		return ris;
	}
	
	//TEST
	
	public static void main(String[] args) { 
		AlgoritmoAnagramma a=new AlgoritmoAnagramma("ciao");
		
		List<String> r;
		r=a.permuta();
		System.out.println(r);
		System.out.println(a.get());
	}

	
	
	
}
