package com.company.controller;

public interface ArithmeticControllerInterface<T> {

    /**
     * Adds 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T add(T number1, T number2);

    /**
     * Subtracts 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T subtract(T number1, T number2);

    /**
     * Multiplies 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T multiply(T number1, T number2);

    /**
     * Divides 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T divide(T number1, T number2) throws Exception;

    /**
     * Converts string to number
     * @param input input
     * @return T
     */
    T convert(String input) throws Exception;
}
