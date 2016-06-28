package interfaces;

import modelo.Jogador;
import excecoes.excecoesMovimento.ExcecaoMovimento;

public interface TrocaDeCenarios {

	public void cenario1() throws ExcecaoMovimento;
	
	public void cenario2() throws ExcecaoMovimento;
	
	public void cenario3() throws ExcecaoMovimento;
	
	public void menu() throws ExcecaoMovimento;
	
	public void rankings() throws ExcecaoMovimento;
	
	public Jogador getJogador();
}
