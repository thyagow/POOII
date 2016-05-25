package controle;



import visao.JanelaJogo;

import modelo.GerenciadorDeJogos;


public class ExecutarJogo {

	public static void main(String[] args) {
		GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();		
		JanelaJogo janela = new JanelaJogo();		
		janela.criaJanelaBotoesEstrategia();		
		
		
		//janela.criaJanelaJogo(palavras);
				
	}
}
