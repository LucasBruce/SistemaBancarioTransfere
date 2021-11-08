package br.com.bruce.testeSistemaBancarioTransfere.modelTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.bruce.sistemaBancarioTransfere.model.Usuario;

public class UsuarioTest {

	private Usuario usuario;
	
	//cenario
	@Before
	public void setUp() {
		usuario = new Usuario(0, null, 0, null, false, 0);
	}
	
	@Test
	public void setandoIdDoUsuario() {			
		//execução
		usuario.setId(1);
		
		//verificação
		assertThat(usuario.getId(), is(1));
	}
	
	@Test
	public void setandoNomeDoUsuario() {			
		//execução
		usuario.setNome("lucas");
		
		//verificação
		assertThat(usuario.getNome(), is("lucas"));
	}
	
	@Test
	public void setandoIdadeDoUsuario() {			
		//execução
		usuario.setIdade(17);
		
		//verificação
		assertThat(usuario.getIdade(), is(17));
	}
	
	@Test
	public void setandoEmailDoUsuario() {			
		//execução
		usuario.setEmail("lucasmatheusbruce@gmail.com");
		
		//verificação
		assertThat(usuario.getEmail(), is("lucasmatheusbruce@gmail.com"));
	}
	
	@Test
	public void setandoIdDaContaDoUsuario() {			
		//execução
		usuario.setIdContaCorrente(1);;
		
		//verificação
		assertThat(usuario.getIdContaCorrente(), is(1));
	}
	
	
	
	
	
}
