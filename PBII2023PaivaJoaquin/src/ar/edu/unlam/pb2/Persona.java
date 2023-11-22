package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public abstract class Persona {
	private String nombre;
	private Set<Medio> medios;
	
	public Persona(String nombre) {
		super();
		this.medios = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Medio> getMedios() {
		return medios;
	}
	
	public Double getTarjetaDebitoMonto() {
		for(Medio medio : medios) {
			if(medio instanceof TarjetaDebito) {
				medio = (TarjetaDebito) medio;
				return medio.mostrarSaldo();
			}
		}
		return null;
		
	}

	public void setMedios(Set<Medio> medios) {
		this.medios = medios;
	}
	
	public void agregarMedio(Medio medio) {
		medios.add(medio);
	}
}
