package br.com.cvc.core;

import static java.util.Objects.isNull;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class Conta implements ContaBasica {
	
	/*
	 * Instância do padrão Singleton.
	 */
	private static ContaBasica instance;
	
	private List<Transferencia> extrato;
	
	private Conta() {
	}
	
	/**
	 * Garante uma única instância da Conta para garantir a persistência na memória do hhistórico de agendamentos.
	 * Em uma aplicação com persistência em banco de dados, por exemplo, poderia ser utilizado JPA, Hibernate ou Spring Data.
	 * 
	 * @return a única instância da conta.
	 */
	public static synchronized ContaBasica getInstance() {
		if( isNull(instance) ) {
			instance = new Conta();
		}
		
		return instance;
	}

		/* (non-Javadoc)
	 * @see br.com.cvc.core.ContaBasica#listarExtrato()
	 */
	@Override
	public List<Transferencia> listarExtrato() {
		return extrato;
	}
	
	/**
	 * Atualiza o extrato com um novo agendamento.
	 * @param transacao
	 */
	private void atualizarExtrato(final Transferencia agendamento) {
		if( isNull(this.extrato) ) {
			this.extrato = new ArrayList<Transferencia>();
		}
		
		this.extrato.add(agendamento);
	}
	
	/* (non-Javadoc)
	 * @see br.com.cvc.core.ContaBasica#agendarTransferencia(br.com.cvc.core.dominio.Agendamento)
	 */
	@Override
	public void agendarTransferencia(final Agendamento transacao) throws OperacaoException {
		Transferencia transferencia = validarTransacao(transacao);
		final Operacao operacao = new OperacaoBuilder().build(transferencia.getDataTransferencia(), transferencia.getValor());
		
		transferencia.setTaxa(operacao.calcularTaxa());
		
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
		 
		 if( isNull(transacao) ) {
			throw new OperacaoException("Transação nula");
		}
		
		if( isNull(transacao.getContaDestino()) ) {
			throw new OperacaoException("Conta de Destino não informada.");
		}
		
		if( isNull(transacao.getContaOrigem()) ) {
			throw new OperacaoException("Conta de Origem não informada.");
		}
		
		if( isNull(transacao.getDataTransferencia()) ) {
			throw new OperacaoException("Data da Transferência não informada.");
		}else if( transacao.getDataTransferencia().isBefore(LocalDate.now()) ) {
			throw new OperacaoException("Data da Transferência tem que ser igual a hoje ou depois.");
		}
		
		if( isNull(transacao.getValorTransferencia()) ) {
			throw new OperacaoException("Valor da Transferência não informado.");
		}else if( transacao.getValorTransferencia().compareTo(BigDecimal.ZERO) <= 0 ) {
			throw new OperacaoException("Valor da Transferência tem que ser maior que zero.");
		}
		
		transferencia.setContaOrigem(transacao.getContaOrigem());
		transferencia.setContaDestino(transacao.getContaDestino());
		transferencia.setDataTransferencia(transacao.getDataTransferencia());
		transferencia.setDataAgendamento(LocalDate.now());
		transferencia.setValor(transacao.getValorTransferencia());
		transferencia.setTaxa(BigDecimal.ZERO);
		
		return transferencia;
	}
	
}
