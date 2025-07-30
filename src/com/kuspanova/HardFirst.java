package com.kuspanova;

import java.util.Scanner;

public class HardFirst {
    /**
     * Вывести на экран ряд чисел Фибоначчи, состоящий из N элементов.
     * Значение N вводится с клавиатуры. Числа Фибоначчи – это элементы
     * числовой последовательности 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …,
     * в которой каждое последующее число равно сумме двух предыдущих.
     */
    public static void main(String[] args) {
        System.out.println("Введите число N: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
