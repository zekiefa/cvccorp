/**
 * 
 */
package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.util.CalculoUtil;

/**
 * Representa transferências agendadas no mesmo dia.
 * @author joao_
 *
 */
public class OperacaoTipoA extends OperacaoBasica {
	
	private static final BigDecimal VALOR_TAXA = new BigDecimal("3");
	
	private static final BigDecimal PORCENTAGEM = new BigDecimal("3");
	
	public OperacaoTipoA(LocalDate dataTransferencia, BigDecimal valor) {
		super(dataTransferencia, valor);
	}
	
	/* (non-Javadoc)
	 * @see br.com.cvc.core.OperacaoBasica#calcularTaxa(java.math.BigDecimal)
	 */
	public BigDecimal calcularTaxa()  throws OperacaoException {
		final BigDecimal taxa = VALOR_TAXA.add(CalculoUtil.calcularPorcentagem(this.getValor(), PORCENTAGEM));
		
		return taxa;
	}

}
