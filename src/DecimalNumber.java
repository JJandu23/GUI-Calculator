package com.company.model;

public class DecimalNumber extends Number {

    private double number;

    /**
     * Constructor for DecimalNumber
     * @param number double
     */
    public DecimalNumber(double number) {
        this.number = number;
    }

    /**
     * Returns number associated with this class
     * @return double
     */
    public double getNumber() {
        return number;
    }

    /**
     * Sets a number to this class
     * @param number double
     */
    public void setNumber(double number) {
        this.number = number;
    }

    /**
     * String value of number
     * @return String
     */
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
