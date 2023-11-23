package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Billetera {

	private List<Transaccion> transacciones;
	private Set<Persona> personas;
	
	public Billetera() {
		this.transacciones = new ArrayList<>();
		this.personas = new TreeSet<>();
	}
	
	public void agregarTrasacciones(Transaccion transaccion) {
		transacciones.add(transaccion);
	}
	
	public void agregarPersonas(Persona persona) {
		personas.add(persona);
	}
	
	public Compra crearCompra(Fisica comprador, Juridica vendedor, Double importe, Medio medioPago) {
		return new Compra(comprador,vendedor,importe,medioPago);
	}
	
	public Transferencia crearTransferencia(Transferible origen, Transferible destino, Double importe) {
		return new Transferencia(origen,destino,importe);
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}
	
	
}
