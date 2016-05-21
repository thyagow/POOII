package modelo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;



public class GerenciadorDeAnagramas {

	private List<String> jogoNum1;
	private List<String> jogoNum2;
	private List<String> jogoNum3;
	private List<String> jogoNum4;
	private List<String> jogoNum5;
	private List<String> jogoNum6;
	private List<String> jogoNum7;
	private List<String> jogoNum8;
	private List<String> jogoNum9;	
	
	
	private List<List> jogos;
		
	
	public GerenciadorDeAnagramas() {
	
		 this.jogoNum1 = new ArrayList<String>(Arrays.asList("salvei", "vielas", "levais", "silva", "ilesa", "avise", "seiva", "selva", "vila", "vela",
		 												     "sela", "veia", "leva", "vise", "vale", "via", "lei", "sal", "ave", "vil"));
			 
		 this.jogoNum2 = new ArrayList<String>(Arrays.asList("gradua", "guarda", "gruda", "aguar", "argua", "ardua", "aguda", "draga", "agar",
		 												     "arda", "grau", "ruga", "dura", "aura", "agua", "rua", "gr�", "dar", "ara"));
			 
		 this.jogoNum3 = new ArrayList<String>(Arrays.asList("lamber", "lembra", "leram", "melar", "abrem", "ralem", "arem", "arme", 
												             "real", "lema", "mera", "rema", "bela", "mare", "al�m", "mel", "bem", "mal", "ler", "lar"));
			 
		 this.jogoNum4 = new ArrayList<String>(Arrays.asList("enjoar", "enojar", "ranjo", "arejo", "reajo", "rena", "anjo",
		 												     "nora", "orna", "jean", "ore", "roe", "aro", "ano", "n�o", "era", "roa"));
			 
		 this.jogoNum5 = new ArrayList<String>(Arrays.asList("cerram", "cremar", "erram", "remar", "cerra", "crer", "cera", "acre", "rema",
		  												     "caem", "me�a", "cear", "mera", "cem", "era", "ame", "ema", "m�e", "mar"));
			 
		 this.jogoNum6 = new ArrayList<String>(Arrays.asList("drogas", "gordas", "gr�os", "rasgo", "dosar", "sogra", "rodas", "gados", "rogas", "soar",
		 												     "rosa", "doar", "soda", "dosa", "gado", "raso", "dor", "dar", "ora", "g�s"));
			 
		 this.jogoNum7 = new ArrayList<String>(Arrays.asList("flagro", "folgar", "largo", "farol", "flora", "garfo", "grafo", "flor", "oral", "ralo",
		 												     "rola", "afro", "galo", "fora", "faro", "lago", "gol", "ol�", "lar", "aro"));
			 
		 this.jogoNum8 = new ArrayList<String>(Arrays.asList("honras", "sonhar", "noras", "ornas", "rosna", "horas", "rosa", "sano",
		 												     "roas", "anos", "asno", "raso", "s�o", "n�o", "aos", "ora"));
			 
		 this.jogoNum9 = new ArrayList<String>(Arrays.asList("aperto", "aporte", "perto", "prato", "preto", "torpe", "trepo", "optar", "parto", "rapto",
		 												     "trapo", "poeta", "reato", "�pera", "p�reo", "porta", "parte", "reto", "ator", "rato"));		 
				 
		 this.jogos = new ArrayList<List>(Arrays.asList(jogoNum1, jogoNum2, jogoNum3, jogoNum4, jogoNum5, jogoNum6, 
				 										jogoNum7, jogoNum8, jogoNum9));
	}	
	int i;
	public List comecaNovoJogo() {			
			
		if(i > 9)
			i = 0;
		
		if(i == 0){
			i++;
			return jogos.get(0);			
		}
		else
			return jogos.get(i);
		
	}
}
