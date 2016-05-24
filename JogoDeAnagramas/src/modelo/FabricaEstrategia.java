package modelo;

import interfaces.EstrategiaGameSet;

import java.util.HashMap;
import java.util.Map;

import estrategias.Jogo1;
import estrategias.Jogo2;
import estrategias.Jogo3;
import estrategias.Jogo4;
import estrategias.Jogo5;
import estrategias.Jogo6;
import estrategias.Jogo7;
import estrategias.Jogo8;
import estrategias.Jogo9;

public class FabricaEstrategia {

	public enum TiposEstrategia{Jogo1, Jogo2, Jogo3, Jogo4, Jogo5, Jogo6, Jogo7, Jogo8, Jogo9}
	private Map<TiposEstrategia, EstrategiaGameSet> mapaTipoEstrategia;
	private static FabricaEstrategia fabrica;
	
	public FabricaEstrategia() {
		this.mapaTipoEstrategia = new HashMap<TiposEstrategia, EstrategiaGameSet>();
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo1, new Jogo1());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo2, new Jogo2());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo3, new Jogo3());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo4, new Jogo4());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo5, new Jogo5());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo6, new Jogo6());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo7, new Jogo7());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo8, new Jogo8());
		this.mapaTipoEstrategia.put(TiposEstrategia.Jogo9, new Jogo9());
	}
	
	public EstrategiaGameSet retornaEstrategia(TiposEstrategia tipo) {
		return this.mapaTipoEstrategia.get(tipo);
	}
	
	public static FabricaEstrategia getFabricaEstrategia() {
		if(fabrica == null)
			fabrica = new FabricaEstrategia();
		return fabrica;
	}
	
}
