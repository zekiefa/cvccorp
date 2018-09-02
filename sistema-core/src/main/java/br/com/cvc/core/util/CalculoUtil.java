package br.com.cvc.core.util;

import java.math.BigDecimal;

/**
 * Classe utilitária para cálculos.
 * @author joao_
 *
 */
public final class CalculoUtil {
	
	/**
	 * Calcula a porcentagem de um valor.
	 * @param valor
	 * @param porcentagem
	 * @return a porcentagem de um valor
	 */
	public static BigDecimal calcularPorcentagem(final BigDecimal valor, final BigDecimal porcentagem ) {
		return valor.multiply(porcentagem).divide(new BigDecimal("100"));
	}

}
