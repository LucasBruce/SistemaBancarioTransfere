package br.com.bruce.sistemaBancarioTransfere.model;

public class ContaCorrente {

	private int idContaCorrente;
	private double saldo;
	private boolean statusConta;

	public ContaCorrente(int idContaCorrente, double saldo, boolean statusConta) {
		this.idContaCorrente = idContaCorrente;
		this.saldo = saldo;
		this.statusConta = statusConta;
	}

	public int getIdContaCorrente()  {
		return idContaCorrente;
	}

	public void setIdContaCorrente(int idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(boolean statusConta) {
		this.statusConta = statusConta;
	}

	@Override
	public String toString() {
		return "\n idContaCorrente: "+ idContaCorrente 
	    + "\n saldo: " + saldo 
	    + "\n statusConta: " + (statusConta?"Ativo\n":"Inativo\n");
	}

}
