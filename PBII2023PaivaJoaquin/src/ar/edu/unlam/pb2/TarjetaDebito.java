package ar.edu.unlam.pb2;

public class TarjetaDebito extends Medio implements Pagadora{
	private Double saldo;
	
	public TarjetaDebito(String numero, Double saldo) {
		super(numero);
		this.saldo = saldo;
	}

	@Override
	public Boolean pagar(Juridica vendedor, Double importe)
			throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		if(saldo >= importe) {
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
	}
	
	

}
