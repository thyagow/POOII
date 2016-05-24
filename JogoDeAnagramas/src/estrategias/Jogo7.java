package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo7 implements EstrategiaGameSet {
	private List<String> jogoNum7;
	
	public Jogo7() {
		this.jogoNum7 = new ArrayList<String>(Arrays.asList("flagro", "folgar", "largo", "farol", "flora", "garfo", "grafo", "flor", "oral", "ralo",
			     "rola", "afro", "galo", "fora", "faro", "lago", "gol", "olá", "lar", "aro"));
	}
	
	public List pegaJogo() {		
		return jogoNum7;
	}
}
