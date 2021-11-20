package com.company.controller;

import com.company.model.BigNumber;
import java.math.BigInteger;

public class BigNumberController implements ScientificControllerInterface<BigNumber> {

    /**
     * Adds 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber add(BigNumber number1, BigNumber number2) {
        return new BigNumber(number1.getNumber().add(number2.getNumber()));
    }

    /**
     * Subtracts 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber subtract(BigNumber number1, BigNumber number2) {
        return new BigNumber(number1.getNumber().subtract(number2.getNumber()));
    }

    /**
     * Multiplies 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber multiply(BigNumber number1, BigNumber number2) {
        return new BigNumber(number1.getNumber().multiply(number2.getNumber()));
    }

    /**
     * Divides 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber divide(BigNumber number1, BigNumber number2) throws ArithmeticException {
        if(number2.getNumber().intValue() == 0) {
            throw new ArithmeticException();
        }
        return new BigNumber(number1.getNumber().divide(number2.getNumber()));
    }

    /**
     * Converts string to BigNumber
     * @param input input
     * @return BigNumber
     */
    @Override
    public BigNumber convert(String input) throws Exception {
        try {
            long inputLong = Long.parseLong(input);
            return new BigNumber(inputLong);
        }
        catch (Exception e) {
            throw new Exception("Please enter a valid number");
        }
    }

    /**
     * Calculates results of power raised to a BigNumber
     * @param number1 Input number
     * @param power Power to be raised
     * @return BigNumber
     */
    @Override
    public BigNumber power(BigNumber number1, int power) {
        return new BigNumber(number1.getNumber().pow(power));
    }

    /**
     * Calculates square root of a BigNumber
     * @param number1 Input number
     * @return BigNumber
     */
    @Override
    public BigNumber sqrt(BigNumber number1) {
        return new BigNumber(number1.getNumber().sqrt());
    }

    /**
     * Calculates factorial of a BigNumber
     * @param number Input number
     * @return BigNumber
     */
    @Override
    public BigNumber factorial(BigNumber number) {
        BigNumber factorial = new BigNumber(BigInteger.ONE);
        for (int i = number.getNumber().intValue(); i > 0; i--) {
            factorial = multiply(factorial, new BigNumber(i));
        }
        return factorial;
    }

    /**
     * Modulo of 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber mod(BigNumber number1, BigNumber number2) {
        return new BigNumber(number1.getNumber().mod(number2.getNumber()));
    }

    /**
     * GCD of 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber gcd(BigNumber number1, BigNumber number2) {
        return new BigNumber(number1.getNumber().gcd(number2.getNumber()));
    }

    /**
     * LCM of 2 BigNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BigNumber
     */
    @Override
    public BigNumber lcm(BigNumber number1, BigNumber number2) throws ArithmeticException {
        // calculate multiplication of two bigNumbers
        BigNumber multiply = multiply(number1, number2);

        // calculate gcd of two bigNumbers
        BigNumber gcd = gcd(number1, number2);

        // calculate lcm using formula: lcm * gcd = x * y
        return divide(multiply, gcd);
    }
}
