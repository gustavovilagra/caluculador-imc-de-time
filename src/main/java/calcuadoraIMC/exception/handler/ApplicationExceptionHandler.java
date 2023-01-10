package calcuadoraIMC.exception.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import calcuadoraIMC.DTO.ApiErroDTO;
import calcuadoraIMC.exception.AlturaInvalidoException;
import calcuadoraIMC.exception.PesoInvalidoException;

@ControllerAdvice//controlador de exception

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AlturaInvalidoException.class)//cada vez que acontecer um erro na classe nomeada vai executar esse metodo,dessa forma marco e administro minhas exception
	public ResponseEntity<ApiErroDTO> erroAltura(AlturaInvalidoException ex){
		
		var mensagem=new ApiErroDTO(HttpStatus.BAD_REQUEST,LocalDateTime.now(),"nao se permite numeros negativos");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
		
	}
	@ExceptionHandler(PesoInvalidoException.class)
	public ResponseEntity<ApiErroDTO> pesoInvalido(PesoInvalidoException ex){
		var mensagem=new ApiErroDTO(HttpStatus.BAD_REQUEST,LocalDateTime.now(),"pelas regras de negocio seu peso esta errado");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
		
	}
}
