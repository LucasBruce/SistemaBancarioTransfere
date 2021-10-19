package br.com.bruce.sistemaBancarioTransfere.model;

public class ContaCorrente {

	private int idContaCorrente;
	private double saldo;
	private boolean ativo;

	public ContaCorrente(int idContaCorrente, double saldo, boolean ativo) {
		this.idContaCorrente = idContaCorrente;
		this.saldo = saldo;
		this.ativo = ativo;
	}

	public int getIdContaCorrente() {
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "idContaCorrente: " + idContaCorrente + "/n saldo: " + saldo + "/n ativo: " + ativo;
	}

}
