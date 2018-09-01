package br.com.cvc.core.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Define uma operação de transferência de valores.
 * @author joao_
 *
 */
public class Transferencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163357412825111192L;
	
	private Integer contaOrigem;
	private Integer contaDestino;
	private BigDecimal valor;
	private LocalDate dataTransferencia;
	private LocalDate dataAgendamento;
	private BigDecimal taxa;
	
	public Transferencia() {
		
	}
	
	public Transferencia(final Integer contaOrigem, final Integer contaDestino, final BigDecimal valor, final LocalDate dataTransferencia,
			final LocalDate dataAgendamento, final BigDecimal taxa) {
		
		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.dataTransferencia = dataTransferencia;
		this.dataAgendamento = dataAgendamento;
		this.taxa = taxa;
	}

	public Integer getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(final Integer contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Integer getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(final Integer contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(final LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(final LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(final BigDecimal taxa) {
		this.taxa = taxa;
	}
	
}
