package com.kuspanova.middle;

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
        int numberComputer = randomNumber.nextInt(1,101);
        System.out.println("-----Компьютер загадал число!----");
        PlayerPebbles playerFirst = new PlayerPebbles(0,"Первый игрок");
        PlayerPebbles playerSecond = new PlayerPebbles(0,"Второй игрок");
        int whoseMove = randomNumber.nextInt(1,3);
        while(true){
            if(whoseMove == 1){
                System.out.println("--------Ходит первый участник полета.--------");
                System.out.println("Первый игрок вводит число: ");
                int numberFirst = scan.nextInt();
                playerFirst.setCountVictories(playerFirst.getCountVictories() + numberFirst);
                playerSecond.setCountVictories(playerFirst.getCountVictories());
            }
            else if (whoseMove == 2){
                System.out.println("--------Ходит второй участник полета.--------");
                System.out.println("Второй игрок вводит число: ");
                int numberSecond = scan.nextInt();
                playerSecond.setCountVictories(playerSecond.getCountVictories() + numberSecond);
            }
            if(playerFirst.getCountVictories() > numberComputer){
                if(whoseMove == 1){
                    sout
                }
            }
        }
    }
}
