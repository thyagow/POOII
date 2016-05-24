package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo8 implements EstrategiaGameSet {
	private List<String> jogoNum8;
	
	public Jogo8() {
		 this.jogoNum8 = new ArrayList<String>(Arrays.asList("honras", "sonhar", "noras", "ornas", "rosna", "horas", "rosa", "sano",
				     "roas", "anos", "asno", "raso", "são", "não", "aos", "ora"));
	}
	
	public List pegaJogo() {		
		return jogoNum8;
	}
}
