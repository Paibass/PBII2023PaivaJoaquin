package ar.edu.unlam.pb2;

public class Transferencia extends Transaccion {
	private Transferible origen;
	private Transferible destino;
	private Double importe;
	
	public Transferencia(Transferible origen, Transferible destino, Double importe) {
		this.origen = origen;
		this.destino = destino;
		this.importe = importe;
	}
	
	public Boolean realizarTransferencia() throws SaldoInsuficienteException {
		if(origen.extraer(importe)) {
			destino.depositar(importe);
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
	}
}
