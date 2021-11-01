package br.com.bruce.sistemaBancarioTransfere.model;

/*classe Usuario responsavel pela representacao das propriedades do usuario
de acordo com o plano de negocio bancario
@autor: Lucas Bruce
*/

public class Usuario {

	private int id;
	private String nome;
	private int idade;
	private String email;
	private boolean status;
	private int idContaCorrente;

	/*
	 * Construtor da classe usuario além de receber os parametros ele tambem invoca
	 * o construtor da classe pai que e ContaCorrente passando como parametros os dados
	 * para a classe pai
	 */
	public Usuario(int id, String nome, int idade, String email, boolean status, int idContaCorrente) {
		
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.status = status;
		this.idContaCorrente = idContaCorrente;
        
	}

	/*
	 * secao dos gettes e settes onde serao atualizados os valores dos atributos da
	 * classe por meio dos settes e os valores poderao retorna por meio dos gettes
	 */
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(int idContaCorrent) {
		this.idContaCorrente = idContaCorrent;
	}

	/*
	 * toString serao override ou sobescrito para que retorne os atributos da classe
	 */
	@Override
	public String toString() {
		return "\n id:" + id + "\n nome:" + nome + "\n idade: " + idade + "\n email: " + email + "\n status: "
				+ (status?"Ativo":"Inativo") + "\n idContaCorrent:" + idContaCorrente+"\n";
	}

}
