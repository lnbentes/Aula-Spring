package br.com.lucasbentes.crud.controller;

import java.util.concurrent.atomic.AtomicLong;

import br.com.lucasbentes.crud.converter.NumberConverter;
import br.com.lucasbentes.crud.exceptions.UnsupportedMathOperationException;
import br.com.lucasbentes.crud.math.SimpleMath;
import br.com.lucasbentes.crud.validation.NumericValidation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.lucasbentes.crud.converter.NumberConverter.convertToDouble;
import static br.com.lucasbentes.crud.converter.NumberConverter.isNumeric;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();

	SimpleMath math = new SimpleMath();
	NumericValidation validation = new NumericValidation();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		validation.validationNumber(numberOne, numberTwo);
		
		return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception{

		validation.validationNumber(numberOne, numberTwo);

		return math.sub(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multi(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception{

		validation.validationNumber(numberOne, numberTwo);

		return math.multi(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception{

		validation.validationNumber(numberOne, numberTwo);

		return math.div(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws Exception{

		validation.validationNumber(numberOne, numberTwo);

		return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
	public Double sqrt(
			@PathVariable(value = "numberOne") String number
	) throws Exception{

		validation.validationNumber(number);

		return math.sqrt(convertToDouble(number));
	}

}
