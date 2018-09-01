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
public class OperacaoTipoA implements OperacaoBasica {
	
	private static final BigDecimal VALOR_TAXA = new BigDecimal("3");
	
	private static final BigDecimal PORCENTAGEM = new BigDecimal("3");
	
	private LocalDate dataTransferencia;
	
	/**
	 * Construtor
	 */
	public OperacaoTipoA(final LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	/* (non-Javadoc)
	 * @see br.com.cvc.core.OperacaoBasica#calcularTaxa(java.math.BigDecimal)
	 */
	public BigDecimal calcularTaxa(final BigDecimal valor)  throws OperacaoException {
		final BigDecimal taxa = VALOR_TAXA.add(CalculoUtil.calcularPorcentagem(valor, PORCENTAGEM));
		
		return taxa;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}
	
	

}
