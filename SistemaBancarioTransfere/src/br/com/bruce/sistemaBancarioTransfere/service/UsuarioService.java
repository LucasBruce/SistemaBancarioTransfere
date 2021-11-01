package br.com.bruce.sistemaBancarioTransfere.service;

import java.util.List;

import br.com.bruce.sistemaBancarioTransfere.exceptionHandler.IdadeNaoPermitidaException;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;

/*A interface UsuarioService foi criada para organizar 
 * e criar a assinatura dos metodos propostos
 * @autor:Lucas Bruce
 * */
public interface UsuarioService {

	List<Usuario> listarUsuarios();

	Usuario adicionarUsuario(Usuario usuario);

	Usuario pesquisarUsuario(int id);

	boolean remover(int id);

	boolean desativarUsuario(int id);

	boolean ativarUsuario(int id);

	boolean validarIdade(int idade) throws IdadeNaoPermitidaException;
}
