package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo4 implements EstrategiaGameSet {
	private List<String> jogoNum4;
	
	public Jogo4() {
		 this.jogoNum4 = new ArrayList<String>(Arrays.asList("atires", "estira", "estria", "atire", "seria", "reais", "iates",
				     "seita", "sair", "teia", "tira", "arte", "trai", "reta", "tear", "ares", "ter", "ser", "sei", "rei"));
	}
	
	public List pegaJogo() {		
		return jogoNum4;
	}
}
