package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo5 implements EstrategiaGameSet {
	private List<String> jogoNum5;
	
	public Jogo5() {
		this.jogoNum5 = new ArrayList<String>(Arrays.asList("cerram", "cremar", "creram", "erram", "remar", "cerra", "crer", "cera", "acre", "rema",
				     "caem", "meça", "cear", "mera", "cem", "era", "ame", "ema", "mãe", "mar"));
	}
	
	public List pegaJogo() {		
		return jogoNum5;
	}
}
