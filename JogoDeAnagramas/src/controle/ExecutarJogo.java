package controle;

import interfaces.EstrategiaGameSet;

import java.util.List;

import visao.JanelaJogo;
import modelo.FabricaEstrategia;
import modelo.GerenciadorDeJogos;
import modelo.Palavra;
import modelo.FabricaEstrategia.TiposEstrategia;

public class ExecutarJogo {

	public static void main(String[] args) {
				
		
		FabricaEstrategia fabrica = new FabricaEstrategia();
		EstrategiaGameSet est = fabrica.retornaEstrategia(TiposEstrategia.Jogo5);
		List<String> jog = est.pegaJogo();
		
		GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
		gerenciador.criaListaDePalavras(est);
		int NumPalavras = gerenciador.getNumPalavras();
		List <Palavra> palavras = gerenciador.getPalavras();
		
		JanelaJogo janela = new JanelaJogo(NumPalavras, palavras);
		janela.criaJanelaBotoesEstrategia();
	}

}
