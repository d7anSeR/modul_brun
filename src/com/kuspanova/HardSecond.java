package com.kuspanova;

import java.util.Scanner;

public class HardSecond {
    /**
     * Создать программу, которая из заданного массива будет удалять все повторяющиеся элементы
     * (порядок не важен). С консоли вводится в первой строке длина массива, а во второй строке —
     * элементы массива. Длина массива не более 1000 элементов, значение каждого элемента массива
     * положительно и не превышает 1000.
     */
    public static void main(String[] args) {
        System.out.println("Введите кол-во элементов: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];

        int[] marker = new int[1001];
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            input[i] = value;
            if (value >= 1 && value <= 1000) {
                marker[value] = 1;
            }
        }
        System.out.println("Уникальные элементы:");
        for (int i = 1; i <= 1000; i++) {
            if (marker[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
