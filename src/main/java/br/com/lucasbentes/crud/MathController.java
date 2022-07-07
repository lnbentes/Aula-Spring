package br.com.lucasbentes.crud;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	//Implementando uma calculadora
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		return 1D;
	}

	private boolean isNumeric(String number) {
		// TODO Auto-generated method stub
		return false;
	}

}
