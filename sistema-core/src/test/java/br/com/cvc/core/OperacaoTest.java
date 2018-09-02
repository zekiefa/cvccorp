package br.com.cvc.core;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.function.Executable;

import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.util.CalculoUtil;

/**
 * Teste unitário para Operacao.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class OperacaoTest {

	private static final BigDecimal VALOR_PADRAO = new BigDecimal("100");
	private static final BigDecimal VALOR_SUPERIOR = new BigDecimal("110000");

	private static final LocalDate HOJE = LocalDate.now();

	private OperacaoBuilder builder;

	/**
	 * Teste do pattern Builder.
	 *
	 * @param testName
	 *            name of the test case
	 */
	@BeforeAll
	public void testBuilder() {
		this.builder = new OperacaoBuilder();
	}

	/**
	 * Teste da OperacaoTipoA
	 */
	@Test
	public void testarOperacaoTipoA() throws OperacaoException {
		final Operacao operacaoTipoA = this.builder.build(HOJE, VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoA.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(6)));

	}

	/**
	 * Teste da OperacaoTipoB
	 */
	@Test
	public void testarOperacaoTipoB() throws OperacaoException {
		final Operacao operacaoTipoB = this.builder.build(HOJE.plusDays(2), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoB.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(24)));

	}

	/**
     * Teste da testarOperacaoTipoC com 11 dias
     */
	@Test
	public void testarOperacaoTipoC11Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(11), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(8)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 20 dias
	 */
	@Test
	public void testarOperacaoTipoC20Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(20), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(8)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 21 dias
	 */
	@Test
	public void testarOperacaoTipoC21Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(21), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(6)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 30 dias
	 */
	@Test
	public void testarOperacaoTipoC30Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(30), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(6)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 31 dias
	 * 
	 * @throws OperacaoException
	 */
	@Test
	public void testarOperacaoTipoC31Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(31), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(4)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 40 dias
	 */
	@Test
	public void testarOperacaoTipoC40Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(40), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(4)));

	}
	
	/**
	 * Teste testarOperacaoTipoCAcima40Dias
	 * @throws OperacaoException
	 */
	@Test
	public void testarOperacaoTipoCAcima40Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(50), VALOR_SUPERIOR);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(CalculoUtil.calcularPorcentagem(VALOR_SUPERIOR, new BigDecimal("2"))));

	}
	
	/**
	 * Testar taxa não aplicável.
	 */
	@Test
	public void testarTaxaNaoAplicavel() {
		final Operacao operacao = this.builder.build(HOJE.plusDays(50), VALOR_PADRAO);
		
		Executable closure = ()-> operacao.calcularTaxa();
		
		assertThrows(OperacaoException.class, closure, "Taxa não aplicável.");
	}
}
