package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.util.CalculoUtil;

/**
 * Representa transferências com taxa regressiva dependendo da data do agendamento.
 * @author joao_
 *
 */
public class OperacaoTipoC extends OperacaoBasica {
	
	private static final BigDecimal PORCENTAGEM_OITO = new BigDecimal("8");
	
	private static final BigDecimal PORCENTAGEM_SEIS = new BigDecimal("6");
	
	private static final BigDecimal PORCENTAGEM_QUATRO = new BigDecimal("4");
	
	private static final BigDecimal PORCENTAGEM_DOIS = new BigDecimal("2");
	
	private static final BigDecimal LIMITE_VALOR_MINIMO = new BigDecimal("100000");
	
	public OperacaoTipoC(final LocalDate dataTransferencia, final BigDecimal valor) {
		super(dataTransferencia, valor);
	}
	
	/* (non-Javadoc)
	 * @see br.com.cvc.core.OperacaoBasica#calcularTaxa(java.math.BigDecimal)
	 */
	public BigDecimal calcularTaxa() throws OperacaoException {
		BigDecimal taxa = BigDecimal.ZERO;
		final Period intervalo = Period.between(LocalDate.now(), this.getDataTransferencia());
		final Integer dias = intervalo.getDays();
		final Integer meses = intervalo.getMonths();
		
		if( meses == 0 && (dias > 10 && dias <= 20) ) { // acima de 10 dias até 20 dias
			taxa = CalculoUtil.calcularPorcentagem(this.getValor(), PORCENTAGEM_OITO);
		}else if((meses == 1 && dias == 0) || (meses == 0 && dias > 20)) { // acima de 30 dias até 30 dias
			taxa = CalculoUtil.calcularPorcentagem(this.getValor(), PORCENTAGEM_SEIS);
		}else if(meses == 1 && (dias >= 1 && dias <= 10)) { // acima de 30 dias até 40 dias
			taxa = CalculoUtil.calcularPorcentagem(this.getValor(), PORCENTAGEM_QUATRO);
		}else if(meses > 1 || (meses == 1 && dias >= 10) && (this.getValor().compareTo(LIMITE_VALOR_MINIMO) > 0)) { // acima de 40 dias e valor > 100 k
			taxa = CalculoUtil.calcularPorcentagem(this.getValor(), PORCENTAGEM_DOIS);
		}else {
			throw new OperacaoException("Taxa não aplicável.");
		}
		
		return taxa;
	}
	
}
