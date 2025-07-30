package com.kuspanova;

import java.util.Scanner;

public class MiddleThird {
    /**
     * Для каждого натурального числа в промежутке от N вывести все делители,
     * кроме единицы и самого числа. Значение N вводятся с клавиатуры.
     * N может принимать значение от 1 до 100.
     */
    public static void main(String[] args) {
        System.out.println("Введите число (от 1 до 100): ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

    }
}
