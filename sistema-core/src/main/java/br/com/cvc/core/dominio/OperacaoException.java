/**
 * 
 */
package br.com.cvc.core.dominio;

/**
 * Representa qualquer erro durante uma operação no sistema.
 * @author joao_
 *
 */
public class OperacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774686604285817523L;

	/**
	 * 
	 */
	public OperacaoException() {
		
	}
	
	public OperacaoException(final String mensagem) {
		super(mensagem);
	}

	public OperacaoException(final String mensagem, final Throwable erro) {
		super(mensagem, erro);
	}

	
}
