package br.com.bruce.testeSistemaBancarioTransfere.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.bruce.sistemaBancarioTransfere.exceptionHandler.IdadeNaoPermitidaException;
import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.UsuarioServiceImpl;

public class UsuarioServiceTest {

	private List<Usuario> usuarios;
	private List<ContaCorrente> contas;
	private UsuarioServiceImpl usuarioService;
	private Usuario Benicio;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		//Cenário de teste 
		usuarios = new ArrayList<>();
		contas = new ArrayList<>();
		
		Benicio = new Usuario(1, "Benicio", 35, "benicio@yahoo.com", true, 1);
		Usuario Hernesto = new Usuario(2, "Hernesto", 32, "hernesto@yahoo.com", true, 2);
		Usuario Joseph = new Usuario(1, "Joseph", 40, "Joseph@yahoo.com", true, 3);
		
		usuarios.add(Benicio);
		usuarios.add(Hernesto);
		usuarios.add(Joseph);
		
		ContaCorrente contaBenicio = new ContaCorrente(1, 100.0, true);
		ContaCorrente contaHernesto = new ContaCorrente(2, 100.0, true);
		ContaCorrente contaJoseph = new ContaCorrente(3, 100.0, true);
		
		contas.add(contaBenicio);
		contas.add(contaHernesto);
		contas.add(contaJoseph);
		
	    usuarioService = new UsuarioServiceImpl(usuarios, contas);
		
	}
	
	@Test
	public void retornoDaListaUsuarios() {
		//execucao
		List<Usuario> usuariosRetorno = this.usuarioService.listarUsuarios();
		
		//verificacao
		assertThat(usuariosRetorno, is(usuarios));
	}
	
	@Test
	public void adicionandoUsuarioNaLista() {
		//cenario
		Usuario Ribeiro = new Usuario(10, "ribeiro", 32, "ribeiro@yahoo.com", true, 2);
		
		//execucap
		this.usuarioService.adicionarUsuario(Ribeiro);
		boolean usuarioEsta = usuarios.contains(Ribeiro);
		
		//verificacao
		assertTrue(usuarioEsta);
	}
	
	@Test
	public void pesquisandoUsuarioPorId() {
		//execucao
	    Usuario usuarioPesquisado = this.usuarioService.pesquisarUsuario(1);	
	
	    //verificacao
	    assertThat(usuarioPesquisado.getId(), is(1));
	}
	
	@Test
	public void deletandoUsuarioDaLista() {
		//execucao
	boolean foiRemovido = this.usuarioService.remover(1);
		
	    //verificacao
	assertFalse(foiRemovido);
	}
	
	@Test
	public void desativandoUsuario() {
		
		//execucao
		this.usuarioService.desativarUsuario(1);
		
		//verificacao
		assertFalse(Benicio.getStatus());
	}
	
	@Test
	public void ativandoUsuario() {
		
		//execucao
		this.usuarioService.ativarUsuario(1);
        
		assertTrue(Benicio.getStatus());
	}
	
	@Test(expected = IdadeNaoPermitidaException.class)
	public void usuarioNaoPodeTerMenos18EMaisDe65() throws IdadeNaoPermitidaException {
		this.usuarioService.validarIdade(17);		
		
	}
	
	@Test
	public void idadeValidaRetornaFalse() throws IdadeNaoPermitidaException {
		
		//execucao
	 boolean retornoFalso = this.usuarioService.validarIdade(18);
        
		assertFalse(retornoFalso);
	}
}
