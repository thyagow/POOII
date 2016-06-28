package modelo;

import interfaces.EstrategiaGameSet;

import java.util.HashMap;
import java.util.Map;

import modelo.objetos.CenarioObjetos1;
import modelo.objetos.CenarioObjetos2;
import modelo.objetos.CenarioObjetos3;
	
public class FabricaDeEstrategia {

	public enum tipoEstrategia {cenario1, cenario2, cenario3};
	public Map<tipoEstrategia, EstrategiaGameSet> mapaEstrategia;
	private static FabricaDeEstrategia fabrica;
	
	public FabricaDeEstrategia() {
		this.mapaEstrategia = new HashMap<>();
		this.mapaEstrategia.put(tipoEstrategia.cenario1, new CenarioObjetos1());
		this.mapaEstrategia.put(tipoEstrategia.cenario2, new CenarioObjetos2());
		this.mapaEstrategia.put(tipoEstrategia.cenario3, new CenarioObjetos3());
	}
	
	public EstrategiaGameSet retornaEstrategia(tipoEstrategia tipo) {
		return this.mapaEstrategia.get(tipo);
	}
	
	public static FabricaDeEstrategia getFabrica() {
		if(fabrica == null)
			fabrica = new FabricaDeEstrategia();
		return fabrica;
	}
}
