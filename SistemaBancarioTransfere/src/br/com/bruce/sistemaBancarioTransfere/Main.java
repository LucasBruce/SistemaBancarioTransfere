package br.com.bruce.sistemaBancarioTransfere;

import java.util.List;
import java.util.Scanner;

import br.com.bruce.sistemaBancarioTransfere.model.ContaCorrente;
import br.com.bruce.sistemaBancarioTransfere.model.Usuario;
import br.com.bruce.sistemaBancarioTransfere.service.ContaCorrenteService;
import br.com.bruce.sistemaBancarioTransfere.service.UsuarioService;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.ContaCorrenteServiceImpl;
import br.com.bruce.sistemaBancarioTransfere.service.serviceImpl.UsuarioServiceImpl;

public class Main {
	public static void main(String[] args) {

		String continuar;
		ContaCorrenteService contaService = new ContaCorrenteServiceImpl();
		UsuarioService usuarioService = new UsuarioServiceImpl();

		try (Scanner scan = new Scanner(System.in)) {
			continuar = "s";
			while ("s".equalsIgnoreCase(continuar)) {
				menu();
				int cont = scan.nextInt();
				switch (cont) {
				case 1:
					System.out.println("Ensira o id da conta/usuario");
					int id = scan.nextInt();
					boolean removidoConta = contaService.removerConta(id);
					boolean removidoUsuario = usuarioService.removerUsuario(id);
					if (removidoConta == true && removidoUsuario == true) {
						System.out.println("Conta/Usuario removidos com sucesso!");
					}
					break;
				case 2:
					System.out.println("Ensira o id da conta/usuario:");
					int idConta = scan.nextInt();
					ContaCorrente contaCorrente = contaService.pesquisarConta(idConta);
					System.out.println(contaCorrente);
					break;
				case 3:
					System.out.println("Ensira o id da conta/usuario:");
					int idUsuario = scan.nextInt();
					usuarioService.desativarUsuario(idUsuario);
					break;
				case 4:
					System.out.println("Ensira o id da conta/usuario:");
					int idAtivar = scan.nextInt();
					usuarioService.ativarUsuario(idAtivar);
					break;
				case 5:
					List<Usuario> usuarios = usuarioService.listarUsuarios();
					usuarios.forEach(System.out::println);
					break;
				case 6:
					List<ContaCorrente> contas = contaService.listarContas();
					contas.forEach(System.out::println);
					break;
				case 7:
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
			System.out.println("deseja continuar <S> para sim <N> para nao (S/N)?");
			continuar = scan.nextLine();
		}

	}

	private static void menu() {
		System.out.println("digite <1> para remover usuario/conta.");
		System.out.println("digite <2> para pesquisar usuario.");
		System.out.println("digite <3> para desativar usuario/conta.");
		System.out.println("digite <4> para ativar usuario/conta.");
		System.out.println("digite <5> para listar usuario.");
		System.out.println("digite <6> para listar conta.");
		System.out.println("digite <7> para transferencia.");
	}

}
