package testes;

import static org.junit.Assert.*;
import interfaces.EstrategiaGameSet;
import modelo.FabricaEstrategia;
import modelo.GerenciadorDeJogos;
import modelo.FabricaEstrategia.TiposEstrategia;
import modelo.Palavra;
import modelo.PalavraCom6Letras;

import org.junit.Test;

public class testAnagramas {

	@Test
	public void testOrdenacao() {
		GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
		FabricaEstrategia fabrica = new FabricaEstrategia();
		EstrategiaGameSet est = fabrica.retornaEstrategia(TiposEstrategia.Jogo1);
		gerenciador.criaListaDePalavras(est);
		Palavra palavra = new PalavraCom6Letras("hsuaia","ahsuao");
		gerenciador.soParaTestesComOArray(palavra);
		//gerenciador.imprimeLista();
	}
	
	@Test
	public void ordenaArray() {
		GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
		FabricaEstrategia fabrica = new FabricaEstrategia();
		EstrategiaGameSet est = fabrica.retornaEstrategia(TiposEstrategia.Jogo1);
		gerenciador.criaListaDePalavras(est);
		gerenciador.OrdenaPalavras();
		gerenciador.imprimeLista();
	}
}
