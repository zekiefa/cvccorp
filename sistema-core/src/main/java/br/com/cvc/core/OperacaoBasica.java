package br.com.cvc.core;

import java.math.BigDecimal;

/**
 * Define uma operação do sistema.
 * @author joao_
 *
 */
public interface OperacaoBasica {
	
	/**
	 * Calcula a taxa de acordo com o valor da operação.
	 * @param valor da operação
	 * @return taxa calculada
	 */
	BigDecimal calcularTaxa(final BigDecimal valor);
}
