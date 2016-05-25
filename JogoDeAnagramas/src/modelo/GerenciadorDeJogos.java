package modelo;


import interfaces.EstrategiaGameSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import visao.JanelaJogo;

public class GerenciadorDeJogos {
	
	private List<Palavra> palavras;	
	private Palavra palavra;
	private String letras;	
	private JanelaJogo janela;

	public GerenciadorDeJogos() {		
		palavras = new ArrayList<Palavra>();		
	}
	
	public void soParaTestesComOArray(Palavra palavra) {
		//String salveiAux = palavras.get(0).getPalavra();
		//palavras.remove(0);
		Palavra levaisAux = palavras.get(2);
		palavras.remove(2);
		palavras.add(palavra);		
	}
	
	public void OrdenaPalavras() {		
		Palavra palavra = null;
		Palavra palavra2 = null;
		Palavra palavra3 = null;		
		for (int i = (palavras.size() - 1); i >= 0; i--) {
			palavra = palavras.get(i);
			palavras.remove(i);
			palavras.add(palavra);			
		}		
	}
	
	public void criaListaDePalavras(EstrategiaGameSet estrategia) {
		
		List<String> palavras = estrategia.pegaJogo();
		letras = palavras.get(0);
		
		for (int i = 0; i < palavras.size(); i++) {
			String palavraGet = palavras.get(i);			
			String palavraGetNorm = this.normalizaPalavra(palavraGet);
			
			if(palavraGet.length() == 3) {
				palavra = new PalavraCom3Letras(palavraGetNorm, palavraGet);
				this.palavras.add(palavra);
			}
			if(palavraGet.length() == 4) {
				palavra = new PalavraCom4Letras(palavraGetNorm, palavraGet);
				this.palavras.add(palavra);
			}
			if(palavraGet.length() == 5) {
				palavra = new PalavraCom5Letras(palavraGetNorm, palavraGet);
				this.palavras.add(palavra);
			}
			if(palavraGet.length() == 6) {
				palavra = new PalavraCom6Letras(palavraGetNorm, palavraGet);
				this.palavras.add(palavra);
			}
		}
	}
	
	private String normalizaPalavra(String palavra) {
		return Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public void imprimeLista() {
		System.out.println("Palavras:\n");		
		
		for (int i = 0; i < palavras.size(); i++) {			
			
			System.out.println("- " + palavras.get(i).toString() + ".");
		}		
	}	

	public int getNumPalavras() {
		return palavras.size();
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public String getLetras() {
		return letras;
	}

	public List<Palavra> getPalavras() {
		return palavras;
	}	
}
	

