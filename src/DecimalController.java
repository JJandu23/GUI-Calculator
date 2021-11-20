package com.company.controller;

import com.company.model.DecimalNumber;

public class DecimalController implements ArithmeticControllerInterface<DecimalNumber> {

    /**
     * Adds 2 DecimalNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return DecimalNumber
     */
    @Override
    public DecimalNumber add(DecimalNumber number1, DecimalNumber number2) {
        return new DecimalNumber(number1.getNumber() + number2.getNumber());
    }

    /**
     * Subtracts 2 DecimalNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return DecimalNumber
     */
    @Override
    public DecimalNumber subtract(DecimalNumber number1, DecimalNumber number2) {
        return new DecimalNumber(number1.getNumber() - number2.getNumber());
    }

    /**
     * Multiplies 2 DecimalNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return DecimalNumber
     */
    @Override
    public DecimalNumber multiply(DecimalNumber number1, DecimalNumber number2) {
        return new DecimalNumber(number1.getNumber() * number2.getNumber());
    }

    /**
     * Divides 2 DecimalNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return DecimalNumber
     */
    @Override
    public DecimalNumber divide(DecimalNumber number1, DecimalNumber number2) throws Exception {
        if(number2.getNumber() == 0) {
            throw new Exception("Divisor can not be 0");
        }
        return new DecimalNumber(number1.getNumber() / number2.getNumber());
    }

    /**
     * Converts string to DecimalNumber
     * @param input input
     * @return DecimalNumber
     */
    @Override
    public DecimalNumber convert(String input) throws Exception {
        try {
            double inputDouble = Double.parseDouble(input);
            return new DecimalNumber(inputDouble);
        }
        catch (Exception e) {
            throw new Exception("Please enter a valid decimal number");
        }
    }
}
