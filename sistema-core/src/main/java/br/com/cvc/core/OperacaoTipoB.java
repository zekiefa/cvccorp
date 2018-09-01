/**
 * 
 */
package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import br.com.cvc.core.dominio.OperacaoException;

/**
 * Representa transferências agendadas em até 10 dias.
 * @author joao_
 *
 */
public class OperacaoTipoB extends OperacaoBasica {
	
	private static final BigDecimal VALOR_TAXA = new BigDecimal("12");
	
	/**
	 * 
	 */
	public OperacaoTipoB(final LocalDate dataTransferencia, final BigDecimal valor) {
		super(dataTransferencia, valor);
	}

	/* (non-Javadoc)
	 * @see br.com.cvc.core.OperacaoBasica#calcularTaxa(java.math.BigDecimal)
	 */
	public BigDecimal calcularTaxa()  throws OperacaoException {
		final Period intervalo = Period.between(LocalDate.now(), this.getDataTransferencia());
		final BigDecimal taxa = VALOR_TAXA.multiply(BigDecimal.valueOf(intervalo.getDays()));
		
		return taxa;
	}
	
}
