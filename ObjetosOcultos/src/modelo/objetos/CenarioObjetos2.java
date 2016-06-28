package modelo.objetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import interfaces.EstrategiaGameSet;

public class CenarioObjetos2 implements EstrategiaGameSet {
	
	private List<String> stringDeObjetos;
	private List<String> stringDeObjetosChave;
	Random rd = new Random();
	
	public CenarioObjetos2() {
		this.stringDeObjetos = new ArrayList<>(Arrays.asList("abacaxi", "arraia", "chapeu de palha", "lata de refrigerante", "libelula", "mala", "marisco", "patinho com snorkel", "uvas verdes", "violao"));
		this.stringDeObjetosChave = new ArrayList<>();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List pegaObjetos() {		
		String aux = "";
		for (int i = 0; i < stringDeObjetos.size() / 2; i++) {
			do{
				aux = stringDeObjetos.get(rd.nextInt(10));			
			}while(verificaIgualdade(aux));
			stringDeObjetosChave.add(aux);
		}
		return stringDeObjetosChave;
	}	
	public boolean verificaIgualdade(String aux) {
		for(String aux2 : stringDeObjetosChave){
			if(aux.equals(aux2))
				return true;				
		}
		return false;
	}
}
