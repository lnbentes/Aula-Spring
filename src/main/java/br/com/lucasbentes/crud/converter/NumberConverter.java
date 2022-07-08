package br.com.lucasbentes.crud.converter;

public class NumberConverter {

    public static Double convertToDouble(String srtNumber) {
        if(srtNumber == null) return 0D;
        String number = srtNumber.replaceAll(",", "."); //Converter o numerico BRL para o USA
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String srtNumber) {
        if(srtNumber == null) return false;
        String number = srtNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // Aplicando regex para verificar se realmente e um numero
    }
}
