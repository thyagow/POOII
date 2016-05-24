package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo2 implements EstrategiaGameSet {
	private List<String> jogoNum2;
	
	
	public Jogo2() {
		this.jogoNum2 = new ArrayList<String>(Arrays.asList("gradua", "guarda", "gruda", "aguar", "argua", "ardua", "aguda", "draga", "agar",
			     "arda", "grau", "ruga", "dura", "aura", "agua", "rua", "grã", "dar", "ara"));
	}
	
	public List pegaJogo() {		
		return jogoNum2;
	}
}
