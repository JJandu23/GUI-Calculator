package com.company.model;

public class HexadecimalNumber extends Number {

    private String number;

    /**
     * Constructor for HexadecimalNumber
     * @param number String
     */
    public HexadecimalNumber(String number) {
        this.number = number;
    }

    /**
     * Returns number associated with this class
     * @return Hexadecimal
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets a number to this class
     * @param number Hexadecimal
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * String value of number
     * @return String
     */
    @Override
    public String toString() {
        return number;
    }
}
