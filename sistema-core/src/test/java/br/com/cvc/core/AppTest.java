package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cvc.core.dominio.OperacaoException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
	private static final BigDecimal VALOR_PADRAO = new BigDecimal("100");
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

   /**
    * Teste da OperacaoTipoA
    */
    public void testarOperacaoTipoA() throws OperacaoException
    {
        final OperacaoBasica operacaoTipoA = new OperacaoTipoA(LocalDate.now());
        final BigDecimal taxa = operacaoTipoA.calcularTaxa(VALOR_PADRAO);
    	assertTrue( taxa.equals(BigDecimal.valueOf(6)) );
        
    }
    
    /**
     * Teste da OperacaoTipoB
     */
     public void testarOperacaoTipoB() throws OperacaoException
     {
         final OperacaoBasica operacaoTipoB = new OperacaoTipoB(LocalDate.now().plusDays(2));
         final BigDecimal taxa = operacaoTipoB.calcularTaxa(VALOR_PADRAO);
     	assertTrue( taxa.equals(BigDecimal.valueOf(24)) );
         
     }
     
     /**
      * Teste da testarOperacaoTipoC com 11 dias
      */
      public void testarOperacaoTipoC11Dias() throws OperacaoException
      {
          final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(11));
          final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
      		assertTrue( taxa.equals(BigDecimal.valueOf(8)) );
          
      }
      
      /**
       * Teste da testarOperacaoTipoC com 20 dias
       */
       public void testarOperacaoTipoC20Dias() throws OperacaoException
       {
           final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(20));
           final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
           assertTrue( taxa.equals(BigDecimal.valueOf(8)) );
           
       }
       
       /**
        * Teste da testarOperacaoTipoC com 21 dias
        */
        public void testarOperacaoTipoC21Dias() throws OperacaoException
        {
            final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(21));
            final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
            assertTrue( taxa.equals(BigDecimal.valueOf(6)) );
            
        }
        
        /**
         * Teste da testarOperacaoTipoC com 30 dias
         */
         public void testarOperacaoTipoC30Dias() throws OperacaoException
         {
             final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(30));
             final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
             assertTrue(taxa.equals(BigDecimal.valueOf(6)));
             
         }
         
         /**
          * Teste da testarOperacaoTipoC com 31 dias
         * @throws OperacaoException 
          */
          public void testarOperacaoTipoC31Dias() throws OperacaoException
          {
              final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(31));
              final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
              assertTrue( taxa.equals(BigDecimal.valueOf(4)) );
              
          }
          
          /**
           * Teste da testarOperacaoTipoC com 40 dias
           */
           public void testarOperacaoTipoC40Dias() throws OperacaoException
           {
               final OperacaoBasica operacaoTipoC = new OperacaoTipoC(LocalDate.now().plusDays(40));
               final BigDecimal taxa = operacaoTipoC.calcularTaxa(VALOR_PADRAO);
               assertTrue( taxa.equals(BigDecimal.valueOf(4)) );
               
           }
}
