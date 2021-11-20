package com.company.model;

public class BinaryNumber extends Number {

    private int number;

    /**
     * Constructor for BinaryNumber
     * @param number int
     */
    public BinaryNumber(int number) {
        this.number = number;
    }

    /**
     * Returns number associated with this class
     * @return int
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets a number to this class
     * @param number int
     */
    public void setNumber(int number) {
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
