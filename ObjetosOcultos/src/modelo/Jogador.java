package modelo;

import modelo.cenarios.Menu;
import excecoes.excecoesMovimento.ExcecaoMovimento;
import interfaces.TrocaDeCenarios;

public class Jogador {

	private TrocaDeCenarios cenarioEntrar;
	
	public Jogador() {
		this.cenarioEntrar = new Menu(this);
	}	
	
	public void irParaCenario1() throws ExcecaoMovimento {
		cenarioEntrar.cenario1();
	}	
	public void irParaCenario2() throws ExcecaoMovimento {
		cenarioEntrar.cenario2();
	}	
	public void irParaCenario3() throws ExcecaoMovimento {
		cenarioEntrar.cenario3();
	}	
	public void irParaMenu() throws ExcecaoMovimento {
		cenarioEntrar.menu();
	}	
	public void irParaRankings() throws ExcecaoMovimento {
		cenarioEntrar.rankings();
	}	
	public void alteraCenario(TrocaDeCenarios cenario) {
		this.cenarioEntrar = cenario;
	}	
	public String retornaPosicao() {
		return "Posição: "+this.cenarioEntrar.toString();
	}
	public TrocaDeCenarios getCenarioEntrar() {
		return cenarioEntrar;
	}	
}
