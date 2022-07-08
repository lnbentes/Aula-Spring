package br.com.lucasbentes.crud.validation;

import br.com.lucasbentes.crud.exceptions.UnsupportedMathOperationException;

import static br.com.lucasbentes.crud.converter.NumberConverter.isNumeric;

public class NumericValidation {

    public void validationNumber(String strNumber){
        if(!isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please use a Numeric value!");
        }
    }

    public void validationNumber(String strNumberOne, String strNumberTwo){
        if(!isNumeric(strNumberOne) || !isNumeric(strNumberTwo)) {
            throw new UnsupportedMathOperationException("Please use a Numeric value!");
        }
    }

}
