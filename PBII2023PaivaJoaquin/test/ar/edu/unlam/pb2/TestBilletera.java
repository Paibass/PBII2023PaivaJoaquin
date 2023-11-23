package ar.edu.unlam.pb2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class TestBilletera {

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		CuentaBancaria nacion = new CuentaBancaria("454787874", 20000D);
		CuentaVirtual uala = new CuentaVirtual("15454545", 4000D);
		
		j1.agregarMedio(uala);
		j1.agregarMedio(nacion);
		f1.agregarMedio(santander);
		
		
		Compra c1 = billetera.crearCompra(f1, j1, 1000d, uala);
		Transferencia t1 = billetera.crearTransferencia(nacion, santander, 5000D);
		
		billetera.agregarTrasacciones(t1);
		billetera.agregarTrasacciones(c1);
		
		assertEquals(billetera.getTransacciones().size(), 2);
	}
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		assertEquals(billetera.getPersonas().size(),2);
	}
	
	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios() {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		CuentaBancaria nacion = new CuentaBancaria("454787874", 20000D);
		CuentaVirtual uala = new CuentaVirtual("15454545", 4000D);
		
		j1.agregarMedio(uala);
		j1.agregarMedio(nacion);
		f1.agregarMedio(santander);
		
		assertEquals(j1.getMedios().size(),2);
		assertEquals(f1.getMedios().size(),1);
	}
	
	@Test
	public void queSePuedanRealizarCompras() throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		CuentaBancaria nacion = new CuentaBancaria("454787874", 20000D);
		CuentaVirtual uala = new CuentaVirtual("15454545", 4000D);
		
		j1.agregarMedio(uala);
		j1.agregarMedio(nacion);
		f1.agregarMedio(santander);
		
		
		Compra c1 = billetera.crearCompra(f1, j1, 1000d, uala);
		
		assertTrue(c1.realizarCompra());
	}
	
	@Test
	public void queSePuedanRealizarTransferencias() throws SaldoInsuficienteException {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		CuentaBancaria nacion = new CuentaBancaria("454787874", 20000D);
		CuentaVirtual uala = new CuentaVirtual("15454545", 4000D);
		
		j1.agregarMedio(uala);
		j1.agregarMedio(nacion);
		f1.agregarMedio(santander);
		
		
		Transferencia t1 = billetera.crearTransferencia(nacion, santander, 5000D);
		assertTrue(t1.realizarTransferencia());
		
	}
	
	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws  SaldoInsuficienteException, ExcedeLimiteDeCompraException{
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		TarjetaDebito visa = new TarjetaDebito("448487874", 100D);
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		
		f1.agregarMedio(visa);
		j1.agregarMedio(santander);
		
		Compra c1 = billetera.crearCompra(f1, j1, 1000d, visa);
		Boolean compraHecha =c1.realizarCompra();

	}
	
	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra()throws  SaldoInsuficienteException, ExcedeLimiteDeCompraException{
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		CuentaVirtual uala = new CuentaVirtual("454545112", 450D);
		
		f1.agregarMedio(uala);
		j1.agregarMedio(santander);
		
		Compra c1 = billetera.crearCompra(f1, j1, 1000d, uala);
		Boolean compraHecha =c1.realizarCompra();
		
	}
	
	@Test(expected = ExcedeLimiteDeCompraException.class)
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws  SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		Billetera billetera = new Billetera();
		
		Fisica f1 = new Fisica("Juan","1145454884");
		Juridica j1 = new Juridica("Dia", "212154545");
		
		billetera.agregarPersonas(j1);
		billetera.agregarPersonas(f1);
		
		CuentaBancaria santander = new CuentaBancaria("221545454", 100000D);
		TarjetaCredito master = new TarjetaCredito("448787848", 5000D);
		
		f1.agregarMedio(master);
		j1.agregarMedio(santander);
		
		Compra c1 = billetera.crearCompra(f1, j1, 10000d, master);
		Boolean compraHecha =c1.realizarCompra();


	}
	
	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia() {
		
	}
	
	@Test
	public void queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo() {
		
	}
}
