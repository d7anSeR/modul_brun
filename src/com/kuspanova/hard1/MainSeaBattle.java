package com.kuspanova.hard1;

import java.util.Random;
import java.util.Scanner;

public class MainSeaBattle {
    /**
     * Создать игру «Морской бой»
     * Создайте 2 поля размером 10 на 10.
     * В начале игры компьютер должен создать поле (матрицу) с заполненными координатами своих кораблей
     * (1 — четырёхклеточный, 2 — трёхклеточных, 3 — двухклеточных и 4 — одноклеточных кораблей).
     * После компьютер предлагает вам ввести координаты ваших кораблей. После расположения кораблей игра начинается.
     * Подсказка: создайте класс Field, у которого будет поле типа двумерный массив.
     * Вместо буквенных обозначений можно использовать цифры, например: A1 — это [0][0], B4 — это [2][5].
     * Клеточка может иметь 3 состояния: корабль есть, корабля нет и корабль подбит.
     * Можно за тип массива взять int тип. Например, если 0 — пустая клетка, 1 — корабль есть и 2 — корабль подбит.
     * Когда вы угадываете расположение корабля, то меняете значение клетки.
     * Компьютер предлагает вам вводить координаты на поле, если вы попали, то попытки продолжаются,
     * пока не будет промах. Следующим ходит компьютер. Выигрывает тот, кто смог поразить все корабли соперника.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Введите ваше имя:");
        String playerName = scanner.nextLine();

        Field humanField = new Field();
        Field computerField = new Field();

        humanField.placeAllShips();
        computerField.placeAllShips();

        boolean humanTurn = true;

        while (true) {
            if (humanTurn) {
                System.out.println("\nВаше поле:");
                humanField.printField(false);

                System.out.println("\nПоле противника:");
                computerField.printField(true);

                System.out.println("Ваш ход (x y):");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                boolean hit = computerField.shoot(x, y);
                if (hit) {
                    System.out.println("Попадание! Стреляйте ещё раз!");
                } else {
                    System.out.println("Мимо!");
                    humanTurn = false;
                }
            } else {
                int x = rnd.nextInt(10);
                int y = rnd.nextInt(10);
                System.out.println("Компьютер стреляет в " + x + " " + y);
                boolean hit = humanField.shoot(x, y);
                if (hit) {
                    System.out.println("Компьютер попал!");
                } else {
                    System.out.println("Компьютер промахнулся!");
                    humanTurn = true;
                }
            }

            if (!humanField.hasShips()) {
                System.out.println("Компьютер победил!");
                break;
            } else if (!computerField.hasShips()) {
                System.out.println("Вы победили!");
                break;
            }
        }
    }
}
