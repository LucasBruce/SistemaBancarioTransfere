package br.com.bruce.testeSistemaBancarioTransfere.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.ContaCorrenteServiceImpl;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.UsuarioServiceImpl;

public class ContaCorrenteServiceTest {

	private List<Usuario> usuarios;
	private List<ContaCorrente> contas;
    private ContaCorrenteServiceImpl contaService;
    private UsuarioServiceImpl usuarioService;
    private ContaCorrente contaBenicio;
	private ContaCorrente contaHernesto;
    
	@Before
	public void setUp() {
		//Cenário de teste 
		usuarios = new ArrayList<>();
		contas = new ArrayList<>();
		
		Usuario Benicio = new Usuario(1, "Benicio", 35, "benicio@yahoo.com", true, 1);
		Usuario Hernesto = new Usuario(2, "Hernesto", 32, "hernesto@yahoo.com", true, 2);
		Usuario Joseph = new Usuario(1, "Joseph", 40, "Joseph@yahoo.com", true, 3);
		
		usuarios.add(Benicio);
		usuarios.add(Hernesto);
		usuarios.add(Joseph);
		
		contaBenicio = new ContaCorrente(1, 100.0, true);
		contaHernesto = new ContaCorrente(2, 100.0, true);
		ContaCorrente contaJoseph = new ContaCorrente(3, 100.0, true);
		
		contas.add(contaBenicio);
		contas.add(contaHernesto);
		contas.add(contaJoseph);
		
		contaService = new ContaCorrenteServiceImpl(contas, usuarios);
		usuarioService = new UsuarioServiceImpl(usuarios, contas);
	}
	
	@Test
	public void retornaListaContas() {	
		
		//execução
		List<ContaCorrente> contasRetorno = contaService.listarContas();
		
		//verificação
		assertThat(contasRetorno, is(contas));
	}
	
	@Test
	public void adicionaContaNaListaContas() {	
		//cenário
		ContaCorrente contaTeste = new ContaCorrente(0, 0, false);
		
		//execução
		boolean contaFoiAdicionada = contaService.adicionarConta(contaTeste);
		
		//verificação
		assertTrue(contaFoiAdicionada);
	}
	
	@Test
	public void pesquisaContaPeloIdConta() {
		
		//execução
		ContaCorrente contaPesquisada = this.contaService.pesquisarConta(1);
		
		//verificação
		assertThat(contaPesquisada.getIdContaCorrente(), is(1));
	}
	
	@Test
	public void ContaRemovidaDaListaContas() {
		
		//execução
		boolean contaFoiRemovida = this.contaService.removerConta(1);
		
		//verificação
		assertTrue(contaFoiRemovida);
	}
	
	@Test
	public void transfereValorDeUmaContaParaOutra() {
		
		//execução
		this.contaService.transfere(50, 1, 2);
		
		//verificação
		assertThat(this.contaBenicio.getSaldo(), is(50.0));
		
		assertThat(this.contaHernesto.getSaldo(), is(150.0));

	}


	@After
	public void teaDown() {
		usuarios.clear();
		contas.clear();
	}
}
