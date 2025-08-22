package com.kuspanova.middle;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class MainPebbles {
    /**
     * Правила следующие: играют 2 игрока, компьютер загадывает число от 1 до 100.
     * Каждый игрок вводит с клавиатуры число, а компьютер суммирует числа игроков.
     * Если игрок загадал число и оно в сумме дало больше, чем загадал компьютер, то этот игрок проиграл.
     * Пример: компьютер загадал число 48.
     * Первый игрок вводит 30
     * Второй игрок вводит 10 ; // суммарно 40
     * Первый игрок вводит 9 ; // суммарно 49 > 48 Первый игрок проиграл.
     * Игра должна быть написана в ООП стиле, с использованием классов и методов.
     * Для этого создайте класс Player, у которого будет имя и текущий счётчик побед.
     * После завершения игры компьютер выводит победителя и его результат.
     */
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        Random randomNumber = new Random();
        int flag = 1;
        System.out.println("Введите имя первого игрока: ");
        String nameFirst = scan.nextLine();
        PlayerPebbles playerFirst = new PlayerPebbles(0,nameFirst);
        System.out.println("Введите имя второго игрока:");
        String nameSecond = scan.nextLine();
        PlayerPebbles playerSecond = new PlayerPebbles(0,nameSecond);
        System.out.println("-----Компьютер загадал число!----");
        int numberComputer = randomNumber.nextInt(1,101);
        while(flag == 1){
            System.out.println("Выберите вариант:");
            System.out.println("1. Начать игру");
            System.out.println("2. Выход");
            System.out.print("Выбор: ");
            flag = scan.nextInt();
            switch (flag){
                case 1:
                    int whoseMove = randomNumber.nextInt(1,3);
                    int sum = 0;
                    int loser = 0;
                    while(true){
                        if(whoseMove == 1){
                            System.out.println("--------Ходит первый участник игры--------");
                            System.out.println("Первый игрок [" + playerFirst.getName() + "] вводит число: ");
                            int numberFirst = scan.nextInt();
                            sum += numberFirst;
                            if(sum > numberComputer){
                                loser = 1;
                                playerSecond.setCountVictories(playerSecond.getCountVictories() + 1);
                                break;
                            }
                            whoseMove = 2;
                        }
                        else if (whoseMove == 2){
                            System.out.println("--------Ходит второй участник игры--------");
                            System.out.println("Второй игрок [" + playerSecond.getName() + "] вводит число: ");
                            int numberSecond = scan.nextInt();
                            sum += numberSecond;
                            if(sum > numberComputer){
                                loser = 2;
                                playerFirst.setCountVictories(playerFirst.getCountVictories() + 1);
                                break;
                            }
                            whoseMove = 1;
                        }
                    }

                    if(loser == 1){
                        System.out.println("Компьютер загадал число " + numberComputer);
                        System.out.println("Выиграл игрок №" + 2);
                    }
                    else{
                        System.out.println("Компьютер загадал число " + numberComputer);
                        System.out.println("Выиграл игрок №" + 1);
                    }
                    break;
                case 2:
                    flag = 2;
                    System.out.println("Результаты игр: "
                            + playerFirst.getName() + " и " + playerSecond.getName()
                            + " - " + playerFirst.getCountVictories() + ":" + playerSecond.getCountVictories());
                    break;
                default:
                    System.out.println("Нет такого варианта ответа!!!");
                    break;
            }
        }
    }
}