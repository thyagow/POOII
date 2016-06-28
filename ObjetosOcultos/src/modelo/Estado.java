package modelo;

import modelo.estados.Perdido;
import excecoes.ExcecaoEstado;
import interfaces.PadraoEstado;

public class Estado {

	private PadraoEstado interfaceEstados;
	
	public Estado() {
		this.interfaceEstados = new Perdido(this);
	}
	
	public void encontrado() throws ExcecaoEstado {
		interfaceEstados.encontrado();
	}
	
	public void perdido() throws ExcecaoEstado {
		interfaceEstados.perdido();
	}
	
	public PadraoEstado retornaEstado() {
		return this.interfaceEstados;
	}
	
	public void alteraEstado(PadraoEstado estado) {
		this.interfaceEstados = estado;
	}
}
