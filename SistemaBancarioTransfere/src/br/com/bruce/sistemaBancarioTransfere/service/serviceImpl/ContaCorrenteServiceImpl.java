package br.com.bruce.sistemaBancarioTransfere.service.serviceImpl;

import java.util.List;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.ContaCorrenteService;

/*ContaCorrenteServiceImpl ira implementar a interface ContaCorrenteService sobrescrevendo
os metodos
@Autor:Lucas Bruce*/
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

	/* Criando a lista de contas correntes */
	private List<ContaCorrente> contas;

	private List<Usuario> usuarios;

	public ContaCorrenteServiceImpl(List<ContaCorrente> contas, List<Usuario> usuarios) {
		this.contas = contas;
		this.usuarios = usuarios;
	}

	/* Metodo listarContas me retorna a lista de contas criada anteriormente */
	@Override
	public List<ContaCorrente> listarContas() {
		return contas;
	}

	/*
	 * Metodo adicionarConta passa uma instancia de conta corrente que sera
	 * adicionada na lista de contas
	 */
	@Override
	public boolean adicionarConta(ContaCorrente contaCorrente) {
		contas.add(contaCorrente);
		boolean contaAdicionada = contas.contains(contaCorrente);
		return contaAdicionada;
	}

	/*
	 * Metodo pesquisar conta corrente recebe como parametro o idConta para
	 * pesquisar na lista de contas a conta referente ao id passado por fim o metodo
	 * retorna essa conta
	 */
	@Override
	public ContaCorrente pesquisarConta(int idConta) {
		ContaCorrente contaAchada = new ContaCorrente(0, 0, false);
		for (ContaCorrente conta : contas) {
			if (conta.getIdContaCorrente() == idConta) {
				contaAchada = conta;
				break;
			}
		}
		return contaAchada;
	}

	/*
	 * Metodo removerConta remove uma conta especifica na lista de contas a partir
	 * do id recebido como parametro
	 */
	@Override
	public boolean removerConta(int idConta) {
		
			boolean clienteRemovido = false;
			
			for (int i = 0; i < this.contas.size(); i++) {
				ContaCorrente conta = contas.get(i);
				if(conta.getIdContaCorrente() == idConta){
					contas.remove(i);
					clienteRemovido = true;
					break;
				}
			}
			
			return clienteRemovido;
	}

	/*
	 * o metodo transfere deduz o valor passado como parametro da conta origem e
	 * adiciona na conta destino
	 */
	@Override
	public boolean transfere(double valor, int idContaOrigem, int idContaDestino) {

		boolean sucesso = false;
		
		ContaCorrente contaOrigem = pesquisarConta(idContaOrigem);
		ContaCorrente contaDestino = pesquisarConta(idContaDestino);

		if (contaOrigem.getStatusConta() == true) {
			sucesso = true;
			contaOrigem.setSaldo(contaOrigem.getSaldo()-valor); 
		
		} else {
			return contaOrigem.getStatusConta();
		}
		if (contaDestino.getStatusConta() == true) {
			sucesso = true;
			contaDestino.setSaldo(contaDestino.getSaldo()+valor);
		} else {
			return contaDestino.getStatusConta();
		}
		return sucesso;
	}

}
