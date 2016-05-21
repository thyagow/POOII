package modelo;

public class PalavraCom4Letras extends Palavra {

private String palavra, palavraComAcento;
	
	public PalavraCom4Letras(String palavra, String palavraComAcento) {
		this.palavra = palavra;
		this.palavraComAcento = palavraComAcento;
	}

	
	public boolean equals(String palavra) {
		
		if(this.palavra.equals(palavra))
			return true;
		else
			return false;
	}
	
	
	public String getPalavra() {
		return palavra;
	}

	public String getPalavraComAcento() {
		return palavraComAcento;
	}


	@Override
	public String toString() {
		
		return this.palavraComAcento;
	}	
}
