package br.com.cvc.core;

import java.math.BigDecimal;

import br.com.cvc.core.dominio.OperacaoException;

/**
 * Define uma operação do sistema.
 * @author joao_
 *
 */
public interface OperacaoBasica {
	
	/**
	 * Calcula a taxa de acordo com o valor da operação.
	 * @param valor da operação
	 * @param data da realização da transferencia
	 * @return taxa calculada
	 * @throws OperacaoException quando uma taxa não é aplicável
	 */
	BigDecimal calcularTaxa(final BigDecimal valor)  throws OperacaoException;
}
