package com.kuspanova.middle;

public class Calculate {

    public double add(double firstElem, double secondElem) {
        return firstElem + secondElem;
    }

    public double subtraction(double firstElem, double secondElem) {
        return firstElem - secondElem;
    }

    public double multiplication(double firstElem, double secondElem) {
        return firstElem * secondElem;
    }

    public void division(double firstElem, double secondElem) {
        if (secondElem != 0) {
            double elem = firstElem / secondElem;
            System.out.println(elem);
        } else {
            System.out.println("Нельзя делить на ноль!!!");
        }
    }
}
