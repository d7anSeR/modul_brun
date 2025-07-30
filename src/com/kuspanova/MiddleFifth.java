package com.kuspanova;

import java.util.Scanner;

public class MiddleFifth {
    /**
     * Задан двумерный массив размера N на N, где N находится в пределах от 1 до 10.
     * Каждый элемент массива — число. Необходимо вывести сумму чисел,
     * которые находятся на главной диагонали массива.
     * Главная диагональ - это элементы с индексами 0:0, 1:1, 2:2 … N:N.
     */
    public static void main(String[] args) {
        System.out.println("Введите число N (от 1 до 10) : ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int elem = scan.nextInt();
                if (i == j) {
                    count += elem;
                }
            }
        }
        System.out.println(count);

    }
}
