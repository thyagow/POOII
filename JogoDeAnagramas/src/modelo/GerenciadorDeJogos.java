package modelo;


import interfaces.EstrategiaGameSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import visao.JanelaJogo;
import excecoes.ExcecaoPalavraErrada;

public class GerenciadorDeJogos {

	private GerenciadorDeAnagramas gerenciaAnagramas;
	private List<Palavra> palavras;	
	private Palavra palavra;
	private String letras;	
	private JanelaJogo janela;

	public GerenciadorDeJogos() {
		gerenciaAnagramas = new GerenciadorDeAnagramas();		
		palavras = new ArrayList<Palavra>();		
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
			
	public GerenciadorDeAnagramas getGerenciaAnagramas() {
		return gerenciaAnagramas;
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
	

