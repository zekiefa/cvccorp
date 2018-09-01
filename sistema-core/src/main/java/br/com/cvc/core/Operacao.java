package br.com.cvc.core;

import java.math.BigDecimal;

import br.com.cvc.core.dominio.OperacaoException;

/**
 * Define uma operação do sistema.
 * @author joao_
 *
 */
public interface Operacao {
	
	/**
	 * Calcula a taxa de acordo com o valor da operação.
	 * @return taxa calculada
	 * @throws OperacaoException quando uma taxa não é aplicável
	 */
	BigDecimal calcularTaxa()  throws OperacaoException;
}
