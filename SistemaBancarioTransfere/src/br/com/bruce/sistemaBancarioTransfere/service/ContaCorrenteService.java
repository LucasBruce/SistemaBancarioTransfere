package br.com.bruce.sistemaBancarioTransfere.service;

import java.util.List;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;

/*A interface ContaCorrenteService tem como funcao organizar os metodos e criar
a assinatura dos metodos
@Autor:Lucas Bruce*/
public interface ContaCorrenteService {
     
	List<ContaCorrente> listarContas();

	ContaCorrente adicionarConta(ContaCorrente contaCorrente);

	ContaCorrente pesquisarConta(int idConta);

	boolean removerConta(int idConta);
	
	boolean transfere(double valor, int idUsuarioOrigem, int idUsuarioDestino);

}
