package br.com.bruce.sistemaBancarioTransfere.exceptionHandler;

/*Quando o usuario inserir uma idade invalida sera lancada uma exception para 
indicar que a informacao e invalida
@Autor:Lucas Bruce
*/
public class IdadeNaoPermitidaException extends Exception{

	public static String MSG_IDADE_INVALIDA = "Idade invalida a idade precisa ser entre 18 e 65";
    
	public IdadeNaoPermitidaException(String msg) {
		super(msg);
	}
}
