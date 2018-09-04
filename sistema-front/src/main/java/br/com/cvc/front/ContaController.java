package br.com.cvc.front;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.cvc.core.Conta;
import br.com.cvc.core.ContaBasica;
import br.com.cvc.core.dominio.Agendamento;
import br.com.cvc.core.dominio.OperacaoException;
import br.com.cvc.core.dominio.Transferencia;

@Controller 
public class ContaController {

	private ContaBasica conta;
	
	@Inject
    private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	public ContaController() {
		this.conta = Conta.getInstance();
	}
	
	@Get
	public List<Transferencia> listar(){
		return this.conta.listarExtrato();
	}
	
	@Post
	public void agendar(Agendamento agendamento){
		
		
		try {
			this.conta.agendarTransferencia(agendamento);
			
			result.redirectTo(ContaController.class).listar();
		} catch (OperacaoException e) {
			validator.add(new SimpleMessage("erro", e.getMessage()));
			validator.onErrorForwardTo(ContaController.class).form();
		}
		
	}
	
	public void form() {
		
	}
}
