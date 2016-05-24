package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo3 implements EstrategiaGameSet {
	private List<String> jogoNum3;
	
	public Jogo3() {
		 this.jogoNum3 = new ArrayList<String>(Arrays.asList("lamber", "lembra", "leram", "melar", "abrem", "ralem", "arem", "arme", 
	             "real", "lema", "mera", "rema", "bela", "mare", "além", "mel", "bem", "mal", "ler", "lar"));
	}
	
	public List pegaJogo() {		
		return jogoNum3;
	}
}
