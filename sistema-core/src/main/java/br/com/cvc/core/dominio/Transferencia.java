package br.com.cvc.core.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Define uma operação de transferência de valores.
 * 
 * @author joao_
 *
 */
public class Transferencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163357412825111192L;

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private LocalDate dataTransferencia;
	private LocalDate dataAgendamento;
	private BigDecimal taxa;

	public Transferencia() {

	}

	public Transferencia(final String contaOrigem, final String contaDestino, final BigDecimal valor,
			final LocalDate dataTransferencia, final LocalDate dataAgendamento, final BigDecimal taxa) {

		super();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.dataTransferencia = dataTransferencia;
		this.dataAgendamento = dataAgendamento;
		this.taxa = taxa;
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

	@Override
	public int hashCode() {

		return new HashCodeBuilder()
				.append(this.contaDestino)
				.append(this.contaOrigem)
				.append(this.dataAgendamento)
				.append(this.dataTransferencia)
				.append(this.taxa)
				.append(this.valor)
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
		Transferencia other = (Transferencia) obj;
		
		return new EqualsBuilder()
				.append(this.contaDestino, other.contaDestino)
				.append(this.contaOrigem, other.contaOrigem)
				.append(this.dataAgendamento, other.dataAgendamento)
				.append(this.dataTransferencia, other.dataTransferencia)
				.append(this.taxa, other.taxa)
				.append(this.valor, other.valor)
				.isEquals();
	}

}
