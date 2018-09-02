package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

/**
 * Patter desing Builder para construir os diversos tipos de operações.
 * @author joao_
 *
 */
public class OperacaoBuilder {
	
	public OperacaoBuilder() {
		
	}
	
	/**
	 * Devolve uma operação de acordo com a data de transferência e o valor.
	 * @param dataTransferencia
	 * @param valor
	 * @return operação
	 */
	public Operacao build(final LocalDate dataTransferencia, final BigDecimal valor) {
		final Period intervalo = Period.between(LocalDate.now(), dataTransferencia);
		
		Operacao operacao = new OperacaoTipoC(dataTransferencia, valor);
		
		if( intervalo.getMonths() == 0 ) {
			if( intervalo.getDays() == 0  ) {
				operacao = new OperacaoTipoA(dataTransferencia, valor);
			}else if( intervalo.getDays() > 0 && intervalo.getDays() <= 10 ) {
				operacao = new OperacaoTipoB(dataTransferencia, valor);
			}
		}
		
		return operacao;
	}
	
	
	
}
