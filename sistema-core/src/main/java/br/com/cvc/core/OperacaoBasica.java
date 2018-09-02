package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cvc.core.dominio.OperacaoException;

public abstract class OperacaoBasica implements Operacao {
	
	private LocalDate dataTransferencia;
	
	private BigDecimal valor;
	
	public OperacaoBasica(final LocalDate dataTransferencia, final BigDecimal valor) {
		this.dataTransferencia = dataTransferencia;
		this.valor = valor;
	}

	@Override
	public abstract BigDecimal calcularTaxa() throws OperacaoException;

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	

}
