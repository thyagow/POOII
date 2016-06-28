package modelo.cenarios;

import excecoes.excecoesMovimento.ExcecaoLocalAtual;
import modelo.FabricaDeEstrategia;
import modelo.FabricaDeEstrategia.tipoEstrategia;
import modelo.GerenciadorDoJogo;
import modelo.Jogador;
import interfaces.EstrategiaGameSet;
import interfaces.TrocaDeCenarios;

public class Menu implements TrocaDeCenarios {

	private Jogador jogador;
	
	public Menu(Jogador jogador) {
		this.jogador = jogador;
		GerenciadorDoJogo.getGerenciadorObjetos().criaJanelaMenu(this);
	}
	
	@Override
	public void cenario1() {
		FabricaDeEstrategia fabrica = new FabricaDeEstrategia();
		EstrategiaGameSet estrategia = fabrica.retornaEstrategia(tipoEstrategia.cenario1);
		jogador.alteraCenario(new Cenario1(this.jogador, estrategia));
	}
	@Override
	public void cenario2() {
		FabricaDeEstrategia fabrica = new FabricaDeEstrategia();
		EstrategiaGameSet estrategia = fabrica.retornaEstrategia(tipoEstrategia.cenario2);
		jogador.alteraCenario(new Cenario2(this.jogador, estrategia));
	}
	@Override
	public void cenario3() {
		FabricaDeEstrategia fabrica = new FabricaDeEstrategia();
		EstrategiaGameSet estrategia = fabrica.retornaEstrategia(tipoEstrategia.cenario3);
		jogador.alteraCenario(new Cenario3(this.jogador, estrategia));		
	}
	@Override
	public void menu() throws ExcecaoLocalAtual {
		throw new ExcecaoLocalAtual();
	}
	@Override
	public void rankings() {
		jogador.alteraCenario(new Rankings(this.jogador));		
	}
	@Override
	public Jogador getJogador() {		
		return this.jogador;
	}	
}
