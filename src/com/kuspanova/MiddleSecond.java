package com.kuspanova;

import java.util.Scanner;

import static java.lang.Math.abs;

public class MiddleSecond {
    /**
     * В массиве, состоящем из N вещественных элементов найти максимальный по модулю элемент массива.
     * N может принимать значение от 1 до 100
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите количество элементов (от 1 до 100): ");
            n = scan.nextInt();
        } while (n < 1 || n > 100);

        double[] array = new double[n];
        System.out.println("Введите " + n + " вещественных чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextDouble();
        }
        double maxAbs = Math.abs(array[0]);
        double maxElement = array[0];
        for (int i = 1; i < n; i++) {
            double absValue = Math.abs(array[i]);
            if (absValue > maxAbs) {
                maxAbs = absValue;
                maxElement = array[i];
            }
        }
        System.out.println("Максимальный по модулю элемент: " + maxElement);
    }
}
