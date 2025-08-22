package com.kuspanova.middle;

import java.util.Scanner;

public class MainSticks {
    /**
     * Играют два игрока (вы и компьютер).
     * В консоли компьютер выводит 20 палочек.
     * По очереди игрок и компьютер должны снимать 1, 2 или 3 палочки.
     * Каждый шаг компьютер отрисовывает оставшиеся палочки в консоль.
     * Победителем считается тот, кто оставил своему оппоненту одну палочку.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sticks sticks = new Sticks(true, 20);
        while (sticks.getCountSticks() > 1) {
            if (sticks.isRightPlayPerson()) {
                System.out.println("-------Ход пользователя-------");
                System.out.println("Введите кол-во палочек, которые хотите убрать: ");
                int countSticksPerson = scan.nextInt();
                if (countSticksPerson != 1 && countSticksPerson != 2 && countSticksPerson != 3) {
                    System.out.println("Введенное число не корректно!!!! Попробуйте еще раз.");
                    continue;
                }
                sticks.setCountSticks(sticks.getCountSticks() - countSticksPerson);
                System.out.println(sticks.drawSticks());
            } else {
                System.out.println("-------Ход компьютера-------");
                int countAfterComputerStep = sticks.getCountSticks() - sticks.stepComputer();
                System.out.println("Кол-во палочек, которые хочет убрать компьютер: " + countAfterComputerStep);
                sticks.setCountSticks(countAfterComputerStep);
                System.out.println(sticks.drawSticks());
            }
            if (sticks.isVictory()) {
                if (sticks.isRightPlayPerson())
                    System.out.println("Вы оставили компьютеру 1 палочку. Вы победили!");
                else
                    System.out.println("Компьютер оставил вам 1 палочку. Компьютер победил.");
                break;
            }
            sticks.setRightPlayPerson(!sticks.isRightPlayPerson());
        }
    }
}