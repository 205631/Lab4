package it.polito.tdp.algoritmoQuadratoMagico;

public class AlgoritmoQuadratoMagico {

	public int conta;
	public Scacchiera sc;
	
	//METODO CHE RICHIAMA IL METODO RICORSIVO PER LA RICERCA DELLE SOLUZIONI
	public int contaSoluzioni(int n) {
		
		this.conta = 0;
		
		sc= new Scacchiera(n);
		
		int fatto=0; //numero di caselle gia riempite
		
		cercaSol(sc,fatto);
		
		return conta;
	}
	
	//METODO RICORSIVO PER LA RICERCA DELLE SOLUZIONI
	public void cercaSol(Scacchiera sc,int fatto){
		if(fatto==sc.size()){
			
			if(sc.test()==true){
			
			//siamo alla fine quindi soluzione trovata
			this.conta++;
			System.out.println("\nTrovata " + conta);
			
			for (Posizione p : sc.getPosizioni())
				System.out.format("%d %d -> %d\n", p.getRiga(), p.getColonna(), sc.getValue(p));
			}
		}else{
			Posizione p=sc.getPosizioni().get(fatto);
			
			for(int i=1;i<=(sc.getN()*sc.getN());i++){
				
				if(this.valido(sc,p,i)==true){
					
					sc.setValue(p, i);
					this.cercaSol(sc, fatto+1);
					sc.delete(p);
				}
			}
		}
	}
	
	public boolean valido(Scacchiera sc,Posizione p,Integer i){
		
		for(Posizione temp:sc.getPosizioni()){
			if(temp.equals(p)==true)
				break;
			else{
				Integer l=sc.getValue(temp);
				if(l!=null && l==i)
					return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args){
		AlgoritmoQuadratoMagico a=new AlgoritmoQuadratoMagico();
		a.contaSoluzioni(4);
	}
	
	
}
