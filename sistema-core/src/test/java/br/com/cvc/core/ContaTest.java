package br.com.cvc.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.cvc.core.dominio.Agendamento;
import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.dominio.Transferencia;

/**
 * Teste unitário para Operacao.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ContaTest{

	private static final BigDecimal VALOR_PADRAO = new BigDecimal("100");

	private static final LocalDate HOJE = LocalDate.now();

	private ContaBasica conta;

	/**
	 * Testae conta.getInstance().
	 */
	@BeforeAll
	@Test
	public void testarSingleton() {
		this.conta = Conta.getInstance();

		assertNotNull(this.conta);
	}
	
	/**
	 * Testar agendarTransferencia.
	 * @throws OperacaoException 
	 */
	@Test
	public void testarAgendarTransferencia() {
		final Boolean ok = Boolean.TRUE;
		final Agendamento transacao = new Agendamento("000001", "000002", VALOR_PADRAO, HOJE.plusDays(2));
		
		try {
			this.conta.agendarTransferencia(transacao);
		} catch (OperacaoException e) {
			assertTrue(!ok);
		}
		
		assertTrue(ok);

		
	}

	/**
	 * Teste listarExtrato.
	 */
	@Test
	public void testarListarExtrato() {
		List<Transferencia> extrato = this.conta.listarExtrato();
		
		assertNotNull(extrato);
	}
	
	@Test
	@AfterAll
	public void testarListarExtratoComSingleton() throws OperacaoException {
		final ContaBasica outraConta = Conta.getInstance();
		final Agendamento transacao = new Agendamento("000001", "000002", VALOR_PADRAO, HOJE.plusDays(2));
		
		outraConta.agendarTransferencia(transacao);
		List<Transferencia> extrato = outraConta.listarExtrato();

		assertAll("extrato",
				()-> assertNotNull(outraConta),
				()-> assertNotNull(extrato),
				()-> assertTrue(extrato.size() > 0));
	}

}
