package ar.edu.unlam.pb2;

public class TarjetaCredito extends Medio implements Pagadora{
	private double limiteCompra;
	
	public TarjetaCredito(String numero, double limiteCompra) {
		super(numero);
		this.limiteCompra = limiteCompra;
	}

	@Override
	public Boolean pagar(Juridica vendedor, Double importe) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException{
		if(limiteCompra >= importe) {
			return true;
		}else {
			throw new ExcedeLimiteDeCompraException();
		}
		
	}
	
	
}
