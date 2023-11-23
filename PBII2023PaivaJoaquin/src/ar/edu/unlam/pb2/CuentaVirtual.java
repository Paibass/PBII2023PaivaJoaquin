package ar.edu.unlam.pb2;

public class CuentaVirtual extends Medio implements Pagadora{
	private double saldo;
	
	public CuentaVirtual(String cvu, double saldoActual) {
		super(cvu);
		this.saldo = saldoActual;
		
	}

	@Override
	public Boolean pagar(Juridica vendedor, Double importe)
			throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		if(saldo >= importe) {
			actualizarSaldo(importe);
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
	}
	
	public void actualizarSaldo(Double importe) {
		saldo -= importe;
	}
	
}