package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cvc.core.dominio.OperacaoException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Teste unitário para Operacao.
 */
public class OperacaoTest 
    extends TestCase
{
    
	private static final BigDecimal VALOR_PADRAO = new BigDecimal("100");
	
	private static final LocalDate HOJE = LocalDate.now();
	
	private OperacaoBuilder builder;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public OperacaoTest( String testName )
    {
        super( testName );
        this.builder = new OperacaoBuilder();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( OperacaoTest.class );
    }

   /**
    * Teste da OperacaoTipoA
    */
    public void testarOperacaoTipoA() throws OperacaoException
    {
        final Operacao operacaoTipoA = this.builder.build(HOJE, VALOR_PADRAO);
        final BigDecimal taxa = operacaoTipoA.calcularTaxa();
    	assertTrue( taxa.equals(BigDecimal.valueOf(6)) );
        
    }
    
    /**
     * Teste da OperacaoTipoB
     */
	 public void testarOperacaoTipoB() throws OperacaoException
	 {
	     final Operacao operacaoTipoB = this.builder.build(HOJE.plusDays(2), VALOR_PADRAO);
	     final BigDecimal taxa = operacaoTipoB.calcularTaxa();
	 	assertTrue( taxa.equals(BigDecimal.valueOf(24)) );
	     
	 }
     
     /**
      * Teste da testarOperacaoTipoC com 11 dias
      */
      public void testarOperacaoTipoC11Dias() throws OperacaoException
      {
          final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(11), VALOR_PADRAO);
          final BigDecimal taxa = operacaoTipoC.calcularTaxa();
      		assertTrue( taxa.equals(BigDecimal.valueOf(8)) );
          
      }
      
	/**
	 * Teste da testarOperacaoTipoC com 20 dias
	 */
	public void testarOperacaoTipoC20Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(20), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(8)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 21 dias
	 */
	public void testarOperacaoTipoC21Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(21), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(6)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 30 dias
	 */
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
	public void testarOperacaoTipoC31Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(31), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(4)));

	}

	/**
	 * Teste da testarOperacaoTipoC com 40 dias
	 */
	public void testarOperacaoTipoC40Dias() throws OperacaoException {
		final Operacao operacaoTipoC = this.builder.build(HOJE.plusDays(40), VALOR_PADRAO);
		final BigDecimal taxa = operacaoTipoC.calcularTaxa();
		assertTrue(taxa.equals(BigDecimal.valueOf(4)));

	}
}
