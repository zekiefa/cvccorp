package br.com.cvc.core.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.contaDestino)
				.append(this.contaOrigem)
				.append(this.dataTransferencia)
				.append(this.valorTransferencia)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		
		return new EqualsBuilder()
				.append(this.contaDestino, other.contaDestino)
				.append(this.contaOrigem, other.contaOrigem)
				.append(this.dataTransferencia, other.dataTransferencia)
				.append(this.valorTransferencia, this.valorTransferencia)
				.isEquals();
	}
	
	
	
}
