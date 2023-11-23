package ar.edu.unlam.pb2;

public class CuentaBancaria extends Medio implements Transferible {
	private Double saldo;
	
	public CuentaBancaria(String cbu, Double saldoInicial) {
		super(cbu);
		this.saldo = saldoInicial;
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

	@Override
	public void depositar(Double importe) {
		saldo += importe;
	}

	@Override
	public Boolean extraer(Double importe) {
		if(saldo >= importe) {
			saldo -= importe;
			return true;
		}
		return false;
	}
}