package calcuadoraIMC.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import calcuadoraIMC.DTO.CalculadoraDTO;
import calcuadoraIMC.exception.AlturaInvalidoException;
import calcuadoraIMC.exception.PesoInvalidoException;

@RestController
public class CalculadoraController {
	@RequestMapping(path = "/imc",method = RequestMethod.POST)//mapeamento da url .POST o metodo para inserir
	                                                   //o corpo json
	public ResponseEntity<CalculadoraDTO>  calcularIMC(@RequestBody CalculadoraDTO request) {//crio um responseEntity que e encarregado de dar uma resposta .ok
		System.out.println(request);
		
		if(request.getAltura()<0.0) {
			throw new AlturaInvalidoException();
			/*var response=CalculadoraDTO
					.builder()//cria obj
					.altura(request.getAltura())
					.peso(request.getPeso())
					.mensagem("nao pode numeros negativo")
					.build();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);*/
		}
		if(request.getPeso()>250.0||request.getPeso()<0) {
			throw new PesoInvalidoException();
		}
		var imc=request.getPeso()/Math.pow(request.getAltura(), 2);
		request.setImc(imc);
		
		return ResponseEntity.ok(request);//.ok resposta que esta tudo bem
	}

	

}
