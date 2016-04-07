package it.polito.tdp.algoritmoQuadratoMagico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scacchiera {

	private int N;
	
	private Map<Posizione,Integer> caselle;
	private List<Posizione> posizioni;
	
	//DEFINISCO UNA SCACCHIERA DI LATO n E DEFINISCO LE POSIZIONI POSSIBILI
	public Scacchiera(int n){
		N=n;
		caselle=new HashMap<Posizione,Integer>();
		posizioni=new ArrayList<Posizione>();
		
		for(int riga=1;riga<=N;riga++){
			for(int col=1;col<=N;col++){
				posizioni.add(new Posizione(riga,col));
			}
		}
	}

	//RESTITUISCE IL VALORE PRESENTE NELLA SCACCHIERA IN POSIZIONE p
	public int getValue(Posizione p){
		return caselle.get(p);
	}
	
	//METODO PER DEFINIRE IL VALORE DI UNA DETERMINATA CASELLA SE VUOTA
	public void setValue(Posizione p,Integer i){
		if(caselle.get(p)==null){
			caselle.put(p, i);
		}else
			throw new RuntimeException("casella gia' riempita");
	}
	
	//ELIMINA IL VALORE DELLA CASELLA p SE PIENA
	public void delete(Posizione p){
		if(caselle.get(p)!=null){
			caselle.put(p,null);
		}else
			throw new RuntimeException("casella vuota");
	}
	
	//CONFERMA LA VALIDITA' DI UNA POSIZIONE ALL'INTERNO DELLA SCACCHIERA
	public boolean valid(Posizione p){
		return posizioni.contains(p);
	}
	
	//DIMENSIONE DELLA MIA SCACCHIERA
	public int size(){
		return posizioni.size();
	}
	
	
	public List<Posizione> getPosizioni(){
		return posizioni;
	}
	
	public boolean test(){
		
		//controllo che le righe, le colonne e le diagonali rispettino i vincoli
		//RIGA
		int test=0;
			
			for(int j=1;j<=N;j++){
				int i=1;
				test+=this.getValue(new Posizione(i,j));
			}
			
			int riga=0;
			for(int i=2;i<=N;i++){
				riga=0;
				for(int j=1;j<=N;j++){
					
					riga+=this.getValue(new Posizione(i,j));
					if(riga>test)
						return false;
				}
				if(riga!= test)
					return false;
			}
		
		//COLONNA
			int test1=0;
			
			for(int j=1;j<=N;j++){
				int i=1;
				test1+=this.getValue(new Posizione(j,i));
			}
			
			int colonna=0;
			for(int i=2;i<=N;i++){
				colonna=0;
				for(int j=1;j<=N;j++){
					
					colonna+=this.getValue(new Posizione(j,i));
					if(colonna>test1)
						return false;
				}
				if(colonna!= test1)
					return false;
			}
		//DIAGONALE
			int test2=0;
			int diagonale=0;
		int j=1;
		
		for(int i=1;i<=N;i++){
			test2+=this.getValue(new Posizione(i,j));
			j++;
		}
		
		j=N;
		
		for(int i=1;i<=N;i++){
			diagonale+=this.getValue(new Posizione(i,j));
			if(diagonale>test2)
				return false;
			j--;
		}
		if(diagonale!=test2)
			return false;
		
		if(test==test1 && test1==test2)
			return true;
		else
			return false;
	}

	public int getN() {
		return N;
	}
	
	
}
