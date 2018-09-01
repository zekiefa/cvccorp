package br.com.cvc.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import br.com.cvc.core.dominio.Agendamento;
import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.dominio.Transferencia;

/**
 * Representa uma conta de movimentação financeira.
 * @author joao_
 *
 */
public class Conta {
	
	/*
	 * Instância do padrão Singleton.
	 */
	private static Conta instance;
	
	private Integer numero;
	private List<Transferencia> extrato;
	
	private Conta() {
	}
	
	/**
	 * Garante uma única instância da Conta para garantir a persistência na memória do hhistórico de agendamentos.
	 * Em uma aplicação com persistência em banco de dados, por exemplo, poderia ser utilizado JPA, Hibernate ou Spring Data.
	 * 
	 * @return a única instância da conta.
	 */
	public static synchronized Conta getInstance() {
		if( instance == null ) {
			instance = new Conta();
		}
		
		return instance;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}
	
	/**
	 * Lista os agendamentos realizados.
	 * @return lista de transferências.
	 */
	public List<Transferencia> listarExtrato() {
		return extrato;
	}
	
	/**
	 * Atualiza o extrato com um novo agendamento.
	 * @param transacao
	 */
	private void atualizarExtrato(final Transferencia agendamento) {
		if( this.extrato == null ) {
			this.extrato = new ArrayList<Transferencia>();
		}
		
		this.extrato.add(agendamento);
	}
	
	/**
	 * Agenda uma transferência de valor.
	 * @param transacao dados do agendamento.
	 */
	public void agendarTransferencia(final Agendamento transacao) throws OperacaoException {
		final OperacaoBasica operacao;
		Transferencia transferencia = validarTransacao(transacao);
		final Period intervalo = Period.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
		
		if( intervalo.getDays() == 1  ) {
			operacao = new OperacaoTipoA(transferencia.getDataTransferencia());
		}else if( intervalo.getDays() <= 10 ) {
			operacao = new OperacaoTipoB(transferencia.getDataTransferencia());
		}else if( intervalo.getDays() >= 10 ) {
			operacao = new OperacaoTipoC(transferencia.getDataTransferencia());
		}else {
			throw new OperacaoException("Taxa da transação não aplicável");
		}
		
		transferencia.setTaxa(operacao.calcularTaxa(transferencia.getValor()));
		
		this.atualizarExtrato(transferencia);
	}
	
	/**
	 * Valida as informações do agendamento da transferência.
	 * @param transacao transacao dados do agendamento
	 * @return uma transferência com os dados da transação.
	 * @throws OperacaoException ocorre quando há alguma informação faltando.
	 * 
	 */
	private Transferencia validarTransacao(final Agendamento transacao) throws OperacaoException {
		 Transferencia transferencia = new Transferencia();
		 
		 if( transacao == null ) {
			throw new OperacaoException("Transação nula");
		}
		
		if( transacao.getContaDestino() == null ) {
			throw new OperacaoException("Conta de Destino não informada.");
		}
		
		if( transacao.getContaOrigem() == null ) {
			throw new OperacaoException("Conta de Origem não informada.");
		}
		
		if( transacao.getDataTransferencia() == null ) {
			throw new OperacaoException("Data da Transferência não informada.");
		}else if( transacao.getDataTransferencia().isBefore(LocalDate.now()) ) {
			throw new OperacaoException("Data da Transferência tem que ser igual a hoje ou depois.");
		}
		
		if( transacao.getValorTransferencia() == null ) {
			throw new OperacaoException("Valor da Transferência não informado.");
		}else if( transacao.getValorTransferencia().compareTo(BigDecimal.ZERO) <= 0 ) {
			throw new OperacaoException("Valor da Transferência tem que ser maior que zero.");
		}
		
		transferencia.setContaOrigem(transacao.getContaOrigem());
		transferencia.setContaDestino(transacao.getContaDestino());
		transferencia.setDataTransferencia(transferencia.getDataTransferencia());
		transferencia.setDataAgendamento(LocalDate.now());
		transferencia.setValor(transacao.getValorTransferencia());
		transferencia.setTaxa(BigDecimal.ZERO);
		
		return transferencia;
	}
	
}
