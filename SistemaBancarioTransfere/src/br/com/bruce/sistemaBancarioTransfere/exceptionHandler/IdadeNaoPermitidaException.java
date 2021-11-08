package br.com.bruce.sistemaBancarioTransfere.exceptionHandler;

/*Quando o usuario inserir uma idade invalida sera lancada uma exception para 
indicar que a informacao e invalida
@Autor:Lucas Bruce
*/
public class IdadeNaoPermitidaException extends Exception{
    
	
	private static final long serialVersionUID = 1L;

	public IdadeNaoPermitidaException(String msg) {
		super(msg);
	}
}
