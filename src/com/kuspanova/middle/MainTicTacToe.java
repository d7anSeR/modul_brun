package com.kuspanova.middle;

import java.util.Scanner;

public class MainTicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        Player human = new Player(name, 'X');
        Player computer = new Player("Компьютер", 'O');

        Game game = new Game(human, computer);
        game.start();
    }
}
