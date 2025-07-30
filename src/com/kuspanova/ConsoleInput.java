package com.kuspanova;

import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) {
        System.out.println("Введите число и степень");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        int b = a;
        for (int i = 0; i < n - 1; i++) {
            b *= a;
        }
        System.out.println("число " + a + " в степени " + n + " равно " + b);
    }
}
