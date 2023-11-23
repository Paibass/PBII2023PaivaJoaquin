package ar.edu.unlam.pb2;

public abstract class Medio{
	private String identificador;
	
	public Medio(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}
	
}
