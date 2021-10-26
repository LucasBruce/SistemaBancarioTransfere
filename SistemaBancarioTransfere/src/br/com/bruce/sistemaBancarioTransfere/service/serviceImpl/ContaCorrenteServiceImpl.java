package br.com.bruce.sistemaBancarioTransfere.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.ContaCorrenteService;

/*ContaCorrenteServiceImpl ira implementar a interface ContaCorrenteService sobrescrevendo
os metodos
@Autor:Lucas Bruce*/
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

	/* Criando a lista de contas correntes */
	private List<ContaCorrente> contas = new ArrayList<>();

	private UsuarioServiceImpl usuarioService;


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
	public ContaCorrente adicionarConta(ContaCorrente contaCorrente) {
		contas.add(contaCorrente);
		return contaCorrente;
	}

	/*
	 * Metodo pesquisar conta corrente recebe como parametro o idConta para
	 * pesquisar na lista de contas a conta referente ao id passado por fim o metodo
	 * retorna essa conta
	 */
	@Override
	public ContaCorrente pesquisarConta(int idConta) {
		for (ContaCorrente conta : contas) {
			if (conta.getIdContaCorrente() == idConta) {
				return conta;
			}
		}
		return null;
	}

	/*
	 * Metodo removerConta remove uma conta especifica na lista de contas a partir
	 * do id recebido como parametro
	 */
	@Override
	public boolean removerConta(int idConta) {
		boolean sucesso = false;
		ContaCorrente conta = pesquisarConta(idConta);
		contas.remove(conta);
		sucesso = contas.contains(conta);
		return sucesso;
	}

	/*
	 * o metodo transfere deduz o valor passado como parametro da conta origem e
	 * adiciona na conta destino
	 */
	@Override
	public boolean transfere(double valor, int idUsuarioOrigem, int idUsuarioDestino) {
		usuarioService = new UsuarioServiceImpl();
		boolean sucesso = false;
		double saldo = 0.0;

		Usuario usuarioOrigem = this.usuarioService.pesquisarUsuario(idUsuarioOrigem);
		Usuario usuarioDestino = this.usuarioService.pesquisarUsuario(idUsuarioDestino);
		ContaCorrente contaOrigem = pesquisarConta(usuarioOrigem.getIdContaCorrente());
		ContaCorrente contaDestino = pesquisarConta(usuarioDestino.getIdContaCorrente());

		if (contaOrigem.getStatusConta() == true) {
			sucesso = true;
			saldo -= valor;
			contaOrigem.setSaldo(saldo);
		} else {
			return contaOrigem.getStatusConta();
		}
		if (contaDestino.getStatusConta() == true) {
			sucesso = true;
			saldo += valor;
			contaDestino.setSaldo(saldo);
		} else {
			return contaDestino.getStatusConta();
		}
		return sucesso;
	}

}
