package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public abstract class Persona implements Comparable<Persona> {
	private String nombre;
	private String identificador;
	
	public Persona(String nombre, String identificador) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
    public int compareTo(Persona otraPersona) {
        return this.identificador.compareTo(otraPersona.getIdentificador());
    }
}
