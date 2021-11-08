package br.com.bruce.testeSistemaBancarioTransfere.modelTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;

public class ContaCorrenteTest {

	@Test
	public void setandoIdDaContaCorrente() {
		//cenario
		ContaCorrente conta = new ContaCorrente(0, 0, false);
		
		//execucao
		conta.setIdContaCorrente(1);
		
		assertThat(conta.getIdContaCorrente(), is(1));
		
	}
}
