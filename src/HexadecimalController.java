package com.company.controller;

import com.company.model.BinaryNumber;
import com.company.model.DecimalNumber;
import com.company.model.HexadecimalNumber;

import static java.lang.Math.abs;

public class HexadecimalController implements ArithmeticControllerInterface<HexadecimalNumber> {

    /**
     * Adds 2 Hexadecimal numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    @Override
    public HexadecimalNumber add(HexadecimalNumber number1, HexadecimalNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.add(getDecimalFromHexadecimal(number1), getDecimalFromHexadecimal(number2));
        return getHexadecimalFromDecimal(result);
    }

    /**
     * Subtracts 2 Hexadecimal numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return HexadecimalNumber
     */
    @Override
    public HexadecimalNumber subtract(HexadecimalNumber number1, HexadecimalNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.subtract(getDecimalFromHexadecimal(number1), getDecimalFromHexadecimal(number2));
        return getHexadecimalFromDecimal(result);
    }

    /**
     * Multiplies 2 Hexadecimal numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return HexadecimalNumber
     */
    @Override
    public HexadecimalNumber multiply(HexadecimalNumber number1, HexadecimalNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.multiply(getDecimalFromHexadecimal(number1), getDecimalFromHexadecimal(number2));
        return getHexadecimalFromDecimal(result);
    }

    /**
     * Divides 2 Hexadecimal numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return HexadecimalNumber
     */
    @Override
    public HexadecimalNumber divide(HexadecimalNumber number1, HexadecimalNumber number2) throws Exception {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.divide(getDecimalFromHexadecimal(number1), getDecimalFromHexadecimal(number2));
        return getHexadecimalFromDecimal(result);
    }

    /**
     * Converts string to Hexadecimal number
     * @param input input
     * @return HexadecimalNumber
     */
    @Override
    public HexadecimalNumber convert(String input) throws Exception {
        try {
            Long.parseLong(input, 16);
            return new HexadecimalNumber(input);
        }
        catch (NumberFormatException ex) {
            throw new Exception("Please enter a valid hexadecimal number");
        }
    }

    /**
     * Converts given hexadecimal number to decimal
     * @param number Input Hexadecimal number
     * @return DecimalNumber
     */
    private DecimalNumber getDecimalFromHexadecimal(HexadecimalNumber number) {
        String hexadecimalCharString = "0123456789ABCDEF";
        //Convert input string to uppercase as in hexadecimal all chars are upper case
        number = new HexadecimalNumber(number.getNumber().toUpperCase());
        int decimalValue = 0;
        //Iterate on give value to convert to decimal
        for (int i = 0; i < number.getNumber().length(); i++) {
            char ch = number.getNumber().charAt(i);
            int n = hexadecimalCharString.indexOf(ch);
            decimalValue = 16 * decimalValue + n;
        }
        return new DecimalNumber(decimalValue);
    }

    /**
     * Converts given decimal number to hexadecimal
     * @param number Input decimal number
     * @return HexadecimalNumber
     */
    private static HexadecimalNumber getHexadecimalFromDecimal(DecimalNumber number) {
        int decimalIntValue = abs((int) number.getNumber());
        String hexadecimalValue = "";
        int remainder;
        //Create list of applicable hex chars
        char[] hexadecimalCharacters = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        //Get the last digit by dividing by 16
        while(decimalIntValue > 0) {
            remainder = decimalIntValue % 16;
            hexadecimalValue = String.format("%s%s", hexadecimalCharacters[remainder], hexadecimalValue);
            decimalIntValue = decimalIntValue/16;
        }
        if(number.getNumber() < 0) {
            return new HexadecimalNumber("-"+hexadecimalValue);
        }
        return new HexadecimalNumber(hexadecimalValue);
    }
}
