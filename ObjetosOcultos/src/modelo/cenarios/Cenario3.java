package modelo.cenarios;

import modelo.GerenciadorDoJogo;
import modelo.Jogador;
import excecoes.excecoesMovimento.ExcecaoLocalAtual;
import excecoes.excecoesMovimento.ExcecaoLocalProibido;
import interfaces.EstrategiaGameSet;
import interfaces.TrocaDeCenarios;

public class Cenario3 implements TrocaDeCenarios {

	private Jogador jogador;
	
	public Cenario3(Jogador jogador, EstrategiaGameSet estrategia) {
		this.jogador = jogador;
		GerenciadorDoJogo.getGerenciadorObjetos().criaNovoJogo(estrategia);
		GerenciadorDoJogo.getGerenciadorObjetos().comecaNovoJogo(this);
	}
	
	@Override
	public void cenario1() throws ExcecaoLocalProibido {
		throw new ExcecaoLocalProibido();
	}
	@Override
	public void cenario2() throws ExcecaoLocalProibido {
		throw new ExcecaoLocalProibido();
	}
	@Override
	public void cenario3() throws ExcecaoLocalAtual {
		throw new ExcecaoLocalAtual();		
	}
	@Override
	public void menu() {
		jogador.alteraCenario(new Menu(this.jogador));		
	}
	@Override
	public void rankings() throws ExcecaoLocalProibido {
		throw new ExcecaoLocalProibido();		
	}
	@Override
	public Jogador getJogador() {		
		return this.jogador;
	}	
}
