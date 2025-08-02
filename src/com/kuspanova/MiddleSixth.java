package com.kuspanova;

import java.util.Random;
import java.util.Scanner;

public class MiddleSixth {
    /**
     * Написать программу для проверки знания таблицы умножения.
     * Для этого необходимо сгенерировать числа А и В при помощи
     * new Random().nextInt()
     * (смотри урок 4). Затем перемножить их и сохранить в переменную С.
     * Далее выведите на экран вопрос: “Сколько будет A * B?”.
     * Пользователь вводит ответ. Необходимо считать ответ пользователя и проверить,
     * правильно ли он ответил. Выведите 5 примеров из таблицы умножения
     */
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int correctAnswers = 0;

        for (int i = 1; i <= 5; i++) {
            int a = random.nextInt(9) + 1; // от 1 до 9
            int b = random.nextInt(9) + 1;
            int c = a * b;

            System.out.print("Пример " + i + ": Сколько будет " + a + " * " + b + "? ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == c) {
                System.out.println("Правильно!");
                correctAnswers++;
            } else {
                System.out.println("Неправильно. Правильный ответ: " + c);
            }
        }

        System.out.println("Вы правильно ответили на " + correctAnswers + " из 5 вопросов.");
    }
}
