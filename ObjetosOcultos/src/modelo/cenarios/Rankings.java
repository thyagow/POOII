package modelo.cenarios;

import modelo.GerenciadorDoJogo;
import modelo.Jogador;
import excecoes.excecoesMovimento.ExcecaoLocalAtual;
import excecoes.excecoesMovimento.ExcecaoLocalProibido;
import excecoes.excecoesMovimento.ExcecaoMovimento;
import interfaces.TrocaDeCenarios;

public class Rankings implements TrocaDeCenarios {

	private Jogador jogador;
		
	public Rankings(Jogador jogador) {
		this.jogador = jogador;
		GerenciadorDoJogo.getGerenciadorObjetos().criajanelaRankings(this);
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
	public void cenario3() throws ExcecaoLocalProibido {
		throw new ExcecaoLocalProibido();		
	}
	@Override
	public void menu() throws ExcecaoMovimento {
		jogador.alteraCenario(new Menu(this.jogador));
	}
	@Override
	public void rankings() throws ExcecaoLocalAtual {
		throw new ExcecaoLocalAtual();		
	}
	@Override
	public Jogador getJogador() {		
		return this.jogador;
	}	
}
