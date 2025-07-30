package com.kuspanova;

import java.util.Scanner;

public class MiddleFourth {
    /**
     * Вычислить факториал числа, которое ввёл пользователь.
     */
    public static void main(String[] args) {
        System.out.println("Введите число : ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int count = number;
        for (int i = 1; i < number; i++) {
            count *= i;
        }
        System.out.println("Факториал числа " + number + " равен " + count);
    }
}
