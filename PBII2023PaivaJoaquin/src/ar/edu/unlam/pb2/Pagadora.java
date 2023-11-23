package ar.edu.unlam.pb2;

public interface Pagadora {
	
	Boolean pagar(Juridica vendedor, Double importe) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException;
}
