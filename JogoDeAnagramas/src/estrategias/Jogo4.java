package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo4 implements EstrategiaGameSet {
	private List<String> jogoNum4;
	
	public Jogo4() {
		 this.jogoNum4 = new ArrayList<String>(Arrays.asList("enjoar", "enojar", "ranjo", "arejo", "reajo", "rena", "anjo",
				     "nora", "orna", "jean", "ore", "roe", "aro", "ano", "não", "era", "roa"));
	}
	
	public List pegaJogo() {		
		return jogoNum4;
	}
}
