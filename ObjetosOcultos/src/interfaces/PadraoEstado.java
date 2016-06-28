package interfaces;

import excecoes.ExcecaoEstado;

public interface PadraoEstado {

	public void encontrado() throws ExcecaoEstado;
	
	public void perdido() throws ExcecaoEstado;			
}
