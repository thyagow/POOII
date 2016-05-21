package visao;

import java.util.List;

import modelo.GerenciadorDeJogos;
import modelo.Palavra;

public class ExecutarJogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
		gerenciador.criaListaDePalavras();
		int NumPalavras = gerenciador.getNumPalavras();
		List <Palavra> palavras = gerenciador.getPalavras();
		new JanelaJogo(NumPalavras, palavras);
	}

}
