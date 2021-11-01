package br.com.bruce.sistemaBancarioTransfere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.ContaCorrenteService;
import br.com.bruce.sistemaBancarioTransfere.service.UsuarioService;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.ContaCorrenteServiceImpl;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.UsuarioServiceImpl;

/*Classe responsável por executar toda a aplicação e executando 
todas as funcionalidades do sistema
Autor:Lucas Bruce
*/

public class Main {
	/*
	 * Váriaveis estaticas que serão utilizadas para acessar as classes de serviço
	 * ContaCorrenteServiceImpl e UsuarioServiceImpl
	 */
	static ContaCorrenteServiceImpl contaService;
	static UsuarioServiceImpl usuarioService;
	
	public static void main(String[] args) {
		/* Varival utilizada na condicional de execução do sistema */
		String continuar;
		
		/* metodo que retorna os dados que inicializaram o sistema */
		inicializaSistemaBancario();

		//Ao final do bloco do try scan fechara será dado um close
		try (Scanner scan = new Scanner(System.in)) {
			continuar = "s";
			//while funciona aqui como um controle no fluxo de execução do sistema
			while ("s".equalsIgnoreCase(continuar)) {
				//mêtodo que retorna o menu do sistema
				menu();
				/* a variavel cont armazenara o valor passado pelo usuario */
				int cont = scan.nextInt();
				
				/*
				 * condicional do sistema dependendo do valor passado ele caira em um dos case
				 * do switch
				 */
				switch (cont) {
				case 1:
//					removendo usuario pelo id
					System.out.println("Ensira o id da conta/usuario");
					int id = scan.nextInt();
					boolean removidoUsuario = usuarioService.remover(id);
					boolean removidoConta = contaService.removerConta(id);
					if (removidoConta == true && removidoUsuario == true) {
						System.out.println("Conta/Usuario removidos com sucesso!");	
						System.out.println();
						}
				
					break;
				case 2:
//					Imprimindo o usuario e sua respectiva conta
					System.out.println("Ensira o id da conta/usuario:");
					int idConta = scan.nextInt();
					ContaCorrente contaCorrente = contaService.pesquisarConta(idConta);
					Usuario usuario = usuarioService.pesquisarUsuario(idConta);
					System.out.println(usuario);
					System.out.println();
					System.out.println(contaCorrente);
					break;
				case 3:
//					desativando usuario
					System.out.println("Ensira o id da conta/usuario:");
					int idUsuario = scan.nextInt();
					usuarioService.desativarUsuario(idUsuario);
					System.out.println("Desativado com sucesso!");
					break;
				case 4:
//					ativando usuario
					System.out.println("Ensira o id da conta/usuario:");
					int idAtivar = scan.nextInt();
					usuarioService.ativarUsuario(idAtivar);
					break;
				case 5:
//					listar todas as contas dos usuarios
					List<Usuario> usuarios = usuarioService.listarUsuarios();
					usuarios.forEach(System.out::println);
					break;
				case 6:
//					listar todas as contas correntes
					List<ContaCorrente> contas = contaService.listarContas();
					contas.forEach(System.out::println);
					break;
				case 7:
					//fazer transferencia
					System.out.println("Ensira o id da sua conta/usuario:");
					int idOrigem = scan.nextInt();
					System.out.println("Ensira o id da conta/usuario que voce deseja transferir o valor:");
					int idDestino = scan.nextInt();
					System.out.println("Ensira o valor da transferencia");
					double valor = scan.nextDouble();
					contaService.transfere(valor, idOrigem, idDestino);
					break;
				}

			}
//			sair ou continuar na aplicação
			System.out.println("deseja continuar <S> para sim <N> para nao (S/N)?");
			continuar = scan.nextLine();
		}

	}
//menu
	private static void menu() {
		System.out.println("digite <1> para remover usuario/conta.");
		System.out.println("digite <2> para pesquisar usuario/conta.");
		System.out.println("digite <3> para desativar usuario/conta.");
		System.out.println("digite <4> para ativar usuario/conta.");
		System.out.println("digite <5> para listar usuario.");
		System.out.println("digite <6> para listar conta.");
		System.out.println("digite <7> para transferencia.");
	}
//	mêtodo que inicializa o sistema como um todo
	private static void inicializaSistemaBancario() {		
		
		//criando alguns usuarios
		Usuario lucas = new Usuario(1, "Lucas Bruce", 25, "lucasmatheus@yahoo.com", true, 1);
		Usuario onix = new Usuario(2, "Onix Lorezone", 55, "onix@yahoo.com", true, 2);
		Usuario jair = new Usuario(3, "Jair Bolsonaro", 65, "jairbolsonaro@yahoo.com", true, 3);
		Usuario marco = new Usuario(4, "Marco Antonio", 55, "villa@yahoo.com", true, 4);
		
		//adicionando alguns usuarios na lista
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(lucas);
		usuarios.add(onix);
		usuarios.add(jair);
		usuarios.add(marco);
		//criando algumas contas 
		ContaCorrente contaLucas = new ContaCorrente(1, 100.0, true);
		ContaCorrente contaOnix = new ContaCorrente(2, 100.0, true);
		ContaCorrente contaJair = new ContaCorrente(3, 100.0, true);
		ContaCorrente contaMarco = new ContaCorrente(4, 100.0, true);
//		adicionando as contas na lista 
		List<ContaCorrente> contas = new ArrayList<>();
        contas.add(contaLucas);
        contas.add(contaOnix);
        contas.add(contaJair);
        contas.add(contaMarco);
		
        //instanciando as classes de serviço para que possa ser utilizada no metodo main
		 usuarioService = new UsuarioServiceImpl(usuarios, contas);
		 contaService = new ContaCorrenteServiceImpl(contas, usuarios);
		
		
	}

}
