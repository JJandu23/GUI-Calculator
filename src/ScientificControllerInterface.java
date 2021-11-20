package com.company.controller;

public interface ScientificControllerInterface<T> extends ArithmeticControllerInterface<T> {

    /**
     * Calculates power of a number
     * @param number1 Input number
     * @param power T
     * @return T
     */
    T power(T number1, int power);

    /**
     * Calculates square root of a number
     * @param number1 Input number
     * @return T
     */
    T sqrt(T number1);

    /**
     * Calculates factorial of a number
     * @param number Input number
     * @return T
     */
    T factorial(T number);

    /**
     * Modulo of 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T mod(T number1, T number2);

    /**
     * GCD of 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T gcd(T number1, T number2);

    /**
     * LCM of 2 numbers
     * @param number1 1st number
     * @param number2 2nd number
     * @return T
     */
    T lcm(T number1, T number2) throws Exception;
}
