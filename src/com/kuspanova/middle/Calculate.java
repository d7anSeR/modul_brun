package com.kuspanova.middle;

public class Calculate {
    double firstElem;
    double secondElem;

    public Calculate(double firstElem, double secondElem) {
        this.firstElem = firstElem;
        this.secondElem = secondElem;
    }
    public double add(){
        return firstElem + secondElem;
    }
    public double subtraction(){
        return firstElem - secondElem;
    }
    public double multiplication(){
        return firstElem * secondElem;
    }
    public void division() {
        if (secondElem != 0) {
            double elem = firstElem / secondElem;
            System.out.println(elem);
        }
        else {
            System.out.println("Нельзя делить на ноль!!!");
        }
    }
}
