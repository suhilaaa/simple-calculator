package com.company.xite.simplecalculator.classifier;

public class NumberClassificationService {

    public static boolean isNaturalNumber(double number) {

        return isPositiveNumber(number)&&(number == (int) number);
    }

    public static boolean isNegativeNumber(double number) {
        return number < 0;
    }

    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }

    public static boolean isPrimeNumber(double number) {
        boolean isItPrime = true;
        if (number <= 1) {
            isItPrime = false;
        }
        else {
            for (int i = 2; i <= number / 2; i++) {
                if ((number % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
        }
        return isItPrime;
    }


    public static boolean isWholeNumber(double number) {
        boolean isWhole;
        if( number % 1 == 0) {
            isWhole = true;
        } else {
            isWhole = false;
        }
        return isWhole;
    }
}
