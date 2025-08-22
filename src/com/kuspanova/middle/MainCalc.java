package com.kuspanova.middle;

import java.util.Scanner;

public class MainCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите действие: ");
        String action = scan.nextLine();
        System.out.println("Введите первое число: ");
        double a = scan.nextInt();
        System.out.println("Введите второе число: ");
        double b = scan.nextInt();
        Calculate calculate = new Calculate(a, b);
        System.out.print("Результат: ");
        switch (action) {
            case "+":
                System.out.println(calculate.add());
                break;
            case "-":
                System.out.println(calculate.subtraction());
                break;
            case "*":
                System.out.println(calculate.multiplication());
                break;
            case "/":
                calculate.division();
                break;
            default:
                System.out.println("нет такой операции");
        }
    }
}