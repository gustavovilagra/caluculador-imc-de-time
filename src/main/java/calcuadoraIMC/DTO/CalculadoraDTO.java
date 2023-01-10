package calcuadoraIMC.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculadoraDTO {
	private Double peso;
	private Double altura;
	private Double imc;
	private String mensagem;
	
}