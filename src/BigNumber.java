package com.company.model;

import java.math.BigInteger;

public class BigNumber extends Number {

    private BigInteger number;

    /**
     * Constructor for BigNumber
     * @param number BigInteger
     */
    public BigNumber(BigInteger number) {
        this.number = number;
    }

    /**
     * Constructor for BigNumber
     * @param longValue long
     */
    public BigNumber(long longValue) {
        this.number = new BigInteger(String.valueOf(longValue));
    }

    /**
     * Returns number associated with this class
     * @return BigInteger
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets a number to this class
     * @param number BigInteger
     */
    public void setNumber(BigInteger number) {
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
