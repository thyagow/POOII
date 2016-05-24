package estrategias;

import interfaces.EstrategiaGameSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo6 implements EstrategiaGameSet {
	private List<String> jogoNum6;
	
	public Jogo6() {
		this.jogoNum6 = new ArrayList<String>(Arrays.asList("drogas", "gordas", "grãos", "rasgo", "dosar", "sogra", "rodas", "gados", "rogas", "soar",
			     "rosa", "doar", "soda", "dosa", "gado", "raso", "dor", "dar", "ora", "gás"));
	}
	
	public List pegaJogo() {		
		return jogoNum6;
	}
}
