package estrategias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.EstrategiaGameSet;

public class Jogo1 implements EstrategiaGameSet {

	private List<String> jogoNum1;
	
	public Jogo1() {
		this.jogoNum1 = new ArrayList<String>(Arrays.asList("salvei", "vielas", "levais", "silva", "ilesa", "avise", "seiva", "selva", "vila", "vela",
			     "sela", "veia", "leva", "vise", "vale", "via", "lei", "sal", "ave", "vil"));
	}
	
	public List pegaJogo() {		
		return jogoNum1;
	}
}
	
