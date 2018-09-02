package br.com.cvc.core.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Informações para realizar um agendamento de transferência de valores.
 * @author joao_
 *
 */
public class Agendamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4948349597810653794L;
	
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private LocalDate dataTransferencia;
	
	
	public Agendamento() {
		
	}
	
	/**
	 * Construtor.
	 * @param contaOrigem
	 * @param contaDestino
	 * @param valorTransferencia
	 * @param dataTransferencia
	 */
	public Agendamento(final String contaOrigem, final String contaDestino, final BigDecimal valorTransferencia, final LocalDate dataTransferencia) {
		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.dataTransferencia = dataTransferencia;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(final String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(final String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(final BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	
	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(final LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	
}
