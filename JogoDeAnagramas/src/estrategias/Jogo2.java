package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo2 implements EstrategiaGameSet {
	private List<String> jogoNum2;
	
	
	public Jogo2() {
		this.jogoNum2 = new ArrayList<String>(Arrays.asList("alarme", "ramela", "melara", "leram", "melar", "ralem", "aguda", "draga", "agar",
			     "ralam", "arame", "areal", "mela", "amar", "lama", "mala", "alma", "arma", "lema", "real"));
	}
	
	public List pegaJogo() {		
		return jogoNum2;
	}
}
