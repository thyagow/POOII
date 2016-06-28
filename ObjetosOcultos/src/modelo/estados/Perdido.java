package modelo.estados;

import excecoes.ExcecaoPerdido;
import modelo.Estado;
import interfaces.PadraoEstado;

public class Perdido implements PadraoEstado {

	private Estado estadoObjeto;
	
	public Perdido(Estado estadoObjeto) {
		this.estadoObjeto = estadoObjeto;
	}
	
	@Override
	public void encontrado() {		
		estadoObjeto.alteraEstado(new Encontrado(this.estadoObjeto));		
	}

	@Override
	public void perdido() throws ExcecaoPerdido {
		throw new ExcecaoPerdido();	
	}
	
	public String toString() {
		return "Objeto não encontrado.";
	}	
}
