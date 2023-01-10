package calcuadoraIMC.exception;

public class PesoInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PesoInvalidoException() {
		super("regra de negocio= seu peso nao pode ser maior de 100 kilos");
	}

}
