package estrategias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.EstrategiaGameSet;

	public class Jogo9 implements EstrategiaGameSet {

		private List<String> jogoNum9;
		
		public Jogo9() {
			this.jogoNum9 = new ArrayList<String>(Arrays.asList("aperto", "aporte", "perto", "prato", "preto", "torpe", "trepo", "optar", "parto", "rapto",
				     "trapo", "poeta", "reato", "ópera", "páreo", "porta", "parte", "reto", "ator", "rato"));
		}
		
		public List pegaJogo() {		
			return jogoNum9;
		}
	}

