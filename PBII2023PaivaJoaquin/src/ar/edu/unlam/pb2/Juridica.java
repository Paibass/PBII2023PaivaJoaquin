package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Juridica extends Persona{ 
	private Set<Medio> medios;
	
	public Juridica(String nombre, String cuit) {
		super(nombre, cuit);
		this.medios = new HashSet<>();
	}
	
	public void agregarMedio(Medio medio) {
		medios.add(medio);
	}

	public Set<Medio> getMedios() {
		return medios;
	}
	
	
}
