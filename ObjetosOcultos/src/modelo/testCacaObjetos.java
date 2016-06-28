package modelo;

import static org.junit.Assert.*;
import interfaces.EstrategiaGameSet;
import modelo.Estado;
import modelo.FabricaDeEstrategia;
import modelo.FabricaDeEstrategia.tipoEstrategia;
import modelo.GerenciadorDoJogo;
import modelo.Objeto;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoEstado;
import excecoes.ExcecaoPerdido;
import excecoes.excecoesMovimento.ExcecaoLocalAtual;
import excecoes.excecoesMovimento.ExcecaoMovimento;

public class testCacaObjetos {

	GerenciadorDoJogo gerenciador;
	EstrategiaGameSet estrategia;
	
	@Before
	public void setup() {
		gerenciador = GerenciadorDoJogo.getGerenciadorObjetos();
		FabricaDeEstrategia fabrica = new FabricaDeEstrategia();
		estrategia = fabrica.retornaEstrategia(tipoEstrategia.cenario3);		
	}
	
	@Test
	public void testEstados() throws ExcecaoEstado {
		Estado estado = new Estado();		
		Objeto objeto = new modelo.ObjetoExtra("bola", estado);
		
		System.out.println(objeto.verificaEstado());
		estado.encontrado();		
		System.out.println(objeto.verificaEstado());
	}
	
	@SuppressWarnings("unused")
	@Test (expected = ExcecaoPerdido.class)
	public void testExcecaoEstado() throws ExcecaoEstado {
		Estado estado = new Estado();		
		Objeto objeto = new modelo.ObjetoExtra("bola", estado);
		
		estado.perdido();
	}
	
	@Test
	public void testNovoJogo() {
		gerenciador.criaNovoJogo(estrategia);
		String lista = gerenciador.getListaDeObjetosChave();
		System.out.println(lista);
	}
	
	//OS TESTES A PARTIR DESTE PONTO SÓ FUNCIONAM ENQUANTO CONSTRUTOR DOS GERENCIADORES FOREM PÚBLICOS!!
	
	@Test
	public void testNumeroDeObjetos() {		
		gerenciador = new GerenciadorDoJogo();
		gerenciador.criaNovoJogo(estrategia);
		int num = gerenciador.getObjChaveSize();		
		assertEquals(5, num);
	}
	
	@Test (expected = ExcecaoLocalAtual.class)
	public void testExcecaoLocalAtual() throws ExcecaoMovimento {
		gerenciador = new GerenciadorDoJogo();
		gerenciador.criaNovoJogo(estrategia);
		Jogador jogador = new Jogador();
		jogador.irParaCenario1();
	}
	
	@Test
	public void testMudancaDeLocal() throws ExcecaoMovimento {
		gerenciador = new GerenciadorDoJogo();
		gerenciador.criaNovoJogo(estrategia);
		gerenciador.getJogador().irParaCenario2();
		System.out.println("\n"+gerenciador.getJogador().retornaPosicao());
	}
}
