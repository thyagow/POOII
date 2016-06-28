package modelo;

import interfaces.EstrategiaGameSet;
import interfaces.TrocaDeCenarios;

import java.util.ArrayList;
import java.util.List;

import modelo.cenarios.Cenario1;
import modelo.cenarios.Cenario2;
import modelo.cenarios.Cenario3;
import modelo.cenarios.Menu;
import modelo.cenarios.Rankings;
import visao.JanelaCenario1;
import visao.JanelaCenario2;
import visao.JanelaCenario3;
import visao.JanelaMenu;
import visao.JanelaRankings;


public class GerenciadorDoJogo {

	private static GerenciadorDoJogo gerenciador;
	private List<Objeto> listaDeObjetos;	
	private Objeto objeto;
	private Jogador jogador; 
	
	public GerenciadorDoJogo() {
		this.listaDeObjetos = new ArrayList<>();
	}	
	@SuppressWarnings("unchecked")
	public void criaNovoJogo(EstrategiaGameSet estrategia) {		
		List<String> strObj = estrategia.pegaObjetos();				
		String nomeObjeto = "";			
		listaDeObjetos.removeAll(listaDeObjetos);
		for (int i = 0; i < strObj.size(); i++) {
			nomeObjeto = strObj.get(i);
			objeto = new ObjetoChave(nomeObjeto, new Estado());
			listaDeObjetos.add(objeto);			
		}
		//System.out.println(listaDeObjetos.size());
	}
	public void criajanelaRankings(Rankings rankings) {
		new JanelaRankings(rankings);
	}
	public void criaJanelaMenu(Menu menu) {
		new JanelaMenu(menu);		
	}
	public void comecaNovoJogo(TrocaDeCenarios cenario) {
		if(cenario instanceof Cenario1)
			new JanelaCenario1(listaDeObjetos,cenario);	
		if(cenario instanceof Cenario2)
			new JanelaCenario2(listaDeObjetos, cenario);
		if(cenario instanceof Cenario3)
			new JanelaCenario3(listaDeObjetos, cenario);
	}	
	public static GerenciadorDoJogo getGerenciadorObjetos() {
		if(gerenciador == null)
			gerenciador = new GerenciadorDoJogo();
		return gerenciador;
	}
	//-------METODOS TESTE J UNIT--------------------------------	
	public String getListaDeObjetosChave() {
		String saida = "";
		for (int i = 0; i < listaDeObjetos.size(); i++) {			
				saida += listaDeObjetos.get(i).toString()+"\n";
		}
		return saida;
	}	
	//-----------------------------------------------------------
	public int getObjChaveSize() {
		return listaDeObjetos.size();
	}		
	public Jogador getJogador() {
		return jogador;
	}	
}
