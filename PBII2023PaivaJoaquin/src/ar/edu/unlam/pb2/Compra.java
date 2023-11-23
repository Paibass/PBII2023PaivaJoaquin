package ar.edu.unlam.pb2;

public class Compra extends Transaccion{
	private Fisica comprador;
	private Juridica vendedor;
	private Double importe;
	private Medio medioPago;
	
	public Compra(Fisica comprador, Juridica vendedor, Double importe, Medio medioPago) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.importe = importe;
        this.medioPago = medioPago;
    }

	public Boolean realizarCompra() throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		 if (medioPago instanceof Pagadora) {
	            Pagadora pagador = (Pagadora) medioPago;
	            boolean pagoExitoso = pagador.pagar(vendedor, importe);
	            if(pagoExitoso) {
	            	for (Medio medioVendedor : vendedor.getMedios()) {
	            		if(medioVendedor instanceof Transferible) {
	            			Transferible cuentaVendedor = (Transferible) medioVendedor;
	            			cuentaVendedor.depositar(importe);
	            			return true;
	            		}
	            	}
	            }
	}
		 return false;
}
}

