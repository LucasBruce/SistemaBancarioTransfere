package br.com.bruce.sistemaBancarioTransfere.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.UsuarioService;

/*A classe usuarioServiceImpl e criada para implementar
 *  os metodos propostos pela interface
 *  @autor:Lucas Bruce
 *   */
public class UsuarioServiceImpl implements UsuarioService {

//	Criando a lista de usuarios
	private List<Usuario> usuarios = new ArrayList<>();

	/* o metodo listarUsuario retorna uma lista de usuarios para quem o invocou */
	@Override
	public List<Usuario> listarUsuarios() {
		return this.usuarios;
	}

	/*
	 * O metodo adicionarUsuario passa como parametro uma instancia de Usuario
	 * instancia essa que sera adicionado na lista Usuarios e por fim retorna a
	 * instancia salva
	 */
	@Override
	public Usuario adicionarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		return usuario;
	}

	/*
	 * O metodo pesquisarUsuario tem como funcao buscar um usuario especifico na
	 * lista de usuarios atraves de um id que e passado como parametro e por fim o
	 * metodo retorna um booleano que verifica se o usuario foi encontrado ou nao
	 */
	@Override
	public Usuario pesquisarUsuario(int id) {
		Usuario usuario = new Usuario(id, null, id, null, false, id, id);
		for (Usuario user : usuarios) {
			if (user.getId() == id) {
				usuario = user;
				break;
			}
		}
		return usuario;

	}

	/*
	 * O metodo removerUsuario ira remover um usuario da lista de usuario atraves do
	 * seu id passado como parametro e por fim ele retorna um valor booleano para
	 * verificar se o usuario foi deletado ou nao
	 */
	@Override
	public boolean removerUsuario(int id) {
       boolean sucesso = false;
       for(Usuario usuario:usuarios) {
    	   if(usuario.getId() == id) {
    		   usuarios.remove(usuario);
    		   sucesso = true;
    	   }
       }
		
		 return sucesso;
	}

	@Override
	public boolean desativarUsuario(int id) {

		return false;
	}

	@Override
	public boolean ativarUsuario(int id) {

		return false;
	}

	@Override
	public boolean validarIdade(int idade) {

		return false;
	}

}
