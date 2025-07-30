package com.kuspanova;

public class MiddleFirst {
    /**
     * Задан массив целочисленных чисел, вывести сумму всех чисел массива.
     */
    public static void main(String[] args) {
        int[] numbersArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        for (int elem : numbersArray) {
            count += elem;
        }
        System.out.println("Сумма всех чисел равна " + count);
    }
}
