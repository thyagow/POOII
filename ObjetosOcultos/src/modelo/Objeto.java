package modelo;

public abstract class Objeto {			

	private String nome;
	private Estado estado;
	
	public Objeto(String nome, Estado estado) {		
		this.nome = nome;
		this.estado = estado;
	}
	
	@Override
	public String toString() {		
		return "Objeto: "+this.nome;
	}

	public boolean equals(Objeto o) {
		if(this.nome.equals(o.getNome()))
			return true;
		else
			return false;
	}

	public String getNome() {
		return this.nome;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public String verificaEstado() {
		return "Estado: "+estado.retornaEstado().toString();
	}
}
