package calcuadoraIMC.exception;



public class AlturaInvalidoException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public AlturaInvalidoException() {
		super("minha excesao de negocio= nao pode numeros negativos");
	}

}
