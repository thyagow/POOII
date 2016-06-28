package modelo.estados;

import modelo.Estado;
import excecoes.ExcecaoEncontrado;
import interfaces.PadraoEstado;

public class Encontrado implements PadraoEstado {

	@SuppressWarnings("unused")
	private Estado estadoObjeto;
	
	public Encontrado(Estado estadoObjeto) {
		this.estadoObjeto = estadoObjeto;
	}
	
	@Override
	public void encontrado() throws ExcecaoEncontrado {
		throw new ExcecaoEncontrado();	
	}

	@Override
	public void perdido() throws ExcecaoEncontrado {
		throw new ExcecaoEncontrado();	
	}
	
	public String toString() {
		return "Objeto encontrado.";
	}
}
