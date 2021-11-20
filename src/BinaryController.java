package com.company.controller;

import com.company.model.BinaryNumber;
import com.company.model.DecimalNumber;

public class BinaryController implements ArithmeticControllerInterface<BinaryNumber> {

    /**
     * Adds 2 BinaryNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BinaryNumber
     */
    @Override
    public BinaryNumber add(BinaryNumber number1, BinaryNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.add(getDecimalFromBinary(number1), getDecimalFromBinary(number2));
        return getBinaryFromDecimal(result);
    }

    /**
     * Subtracts 2 BinaryNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BinaryNumber
     */
    @Override
    public BinaryNumber subtract(BinaryNumber number1, BinaryNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.subtract(getDecimalFromBinary(number1), getDecimalFromBinary(number2));
        return getBinaryFromDecimal(result);
    }

    /**
     * Multiplies 2 BinaryNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BinaryNumber
     */
    @Override
    public BinaryNumber multiply(BinaryNumber number1, BinaryNumber number2) {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.multiply(getDecimalFromBinary(number1), getDecimalFromBinary(number2));
        return getBinaryFromDecimal(result);
    }

    /**
     * Divides 2 BinaryNumbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return BinaryNumber
     */
    @Override
    public BinaryNumber divide(BinaryNumber number1, BinaryNumber number2) throws Exception {
        DecimalController controller = new DecimalController();
        DecimalNumber result = controller.divide(getDecimalFromBinary(number1), getDecimalFromBinary(number2));
        return getBinaryFromDecimal(result);
    }

    /**
     * Converts string to BinaryNumber
     * @param input input
     * @return BinaryNumber
     */
    @Override
    public BinaryNumber convert(String input) throws Exception {
        try {
            int inputInt = Integer.parseInt(input);
            return new BinaryNumber(inputInt);
        }
        catch (Exception e) {
            throw new Exception("Please enter a valid binary number");
        }
    }

    /**
     * Converts given decimal number to binary
     * @param number Input decimal number
     * @return BinaryNumber
     */
    private static BinaryNumber getBinaryFromDecimal(DecimalNumber number) {
        if (((int) number.getNumber()) == 0) {
            return new BinaryNumber(0);
        }
        int[] binary = new int[40];
        int index = 0;
        while (((int) number.getNumber()) > 0) {
            binary[index++] = ((int) number.getNumber()) % 2;
            number.setNumber((number.getNumber())/2);
        }
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            binaryNumber.append(binary[i]);
        }
        return new BinaryNumber(Integer.parseInt(binaryNumber.toString()));
    }

    /**
     * Converts given binary number to decimal
     * @param number Input binary number
     * @return DecimalNumber
     */
    private DecimalNumber getDecimalFromBinary(BinaryNumber number) {
        //Convert binary string to binary init
        int binaryValueInt = number.getNumber();
        int decimalValue = 0;
        int power = 0;
        //Keep on iterating until binary value is non 0
        while (binaryValueInt != 0) {
            int remainder = binaryValueInt % 10;
            decimalValue += remainder * Math.pow(2, power);
            binaryValueInt = binaryValueInt / 10;
            power++;
        }
        return new DecimalNumber(decimalValue);
    }
}
