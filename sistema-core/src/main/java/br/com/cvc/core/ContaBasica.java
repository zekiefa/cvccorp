package br.com.cvc.core;

import java.util.List;

import br.com.cvc.core.dominio.Agendamento;
import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.dominio.Transferencia;

/**
 * Interface para expor os serviços diposnível por uma conta no sistema.
 * Futuramente novas interfaces podem estender dessa para expor os serviços de outros tipo de conta, como investimento, de pagamento etc.
 * (Pattern Facade implementado aqui)
 * @author joao_
 *
 */
public interface ContaBasica {

	/**
	 * Lista os agendamentos realizados.
	 * @return lista de transferências.
	 */
	List<Transferencia> listarExtrato();

	/**
	 * Agenda uma transferência de valor.
	 * @param transacao dados do agendamento.
	 */
	void agendarTransferencia(Agendamento transacao) throws OperacaoException;

}