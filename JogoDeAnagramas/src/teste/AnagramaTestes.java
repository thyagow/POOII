package teste;

import static org.junit.Assert.*;
import modelo.GerenciadorDeJogos;

import org.junit.Before;
import org.junit.Test;

import visao.JanelaJogo;
import excecoes.ExcecaoPalavraErrada;

public class AnagramaTestes {

	private GerenciadorDeJogos gerenciador;
	
	@Before
	public void testSetup() {
		gerenciador = new GerenciadorDeJogos();
		gerenciador.criaListaDePalavras();
		gerenciador.imprimeLista();
	}
	
	
	
	@Test 
	public void testChute() throws ExcecaoPalavraErrada{
		try{			
			gerenciador.verificaChute("sajsa");			
		
		}catch(ExcecaoPalavraErrada e){
			System.out.println("Nâo possui a palavra procurada!");
		}
	}
		
}
