package com.kuspanova.middle;

import java.util.Random;
import java.util.Scanner;

class Game {
    private char[][] board = new char[3][3];
    private Player human;
    private Player computer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Game(Player human, Player computer) {
        this.human = human;
        this.computer = computer;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private boolean isCellFree(int cell) {
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        return board[row][col] == ' ';
    }

    public void playerMove(Player player) {
        int cell;
        while (true) {
            System.out.print(player.getName() + ", введите номер ячейки (1-9): ");
            cell = scanner.nextInt();
            if (cell >= 1 && cell <= 9 && isCellFree(cell)) {
                break;
            } else {
                System.out.println("Неверный ход, попробуйте снова.");
            }
        }
        placeSymbol(cell, player.getSymbol());
    }

    public void computerMove() {
        int cell;
        do {
            cell = random.nextInt(9) + 1;
        } while (!isCellFree(cell));
        System.out.println("Компьютер выбрал ячейку: " + cell);
        placeSymbol(cell, computer.getSymbol());
    }

    private void placeSymbol(int cell, char symbol) {
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        board[row][col] = symbol;
    }

    public boolean checkWinner(Player player) {
        char sym = player.getSymbol();

        // Проверка строк и столбцов
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == sym && board[i][1] == sym && board[i][2] == sym) ||
                    (board[0][i] == sym && board[1][i] == sym && board[2][i] == sym)) {
                return true;
            }
        }

        if ((board[0][0] == sym && board[1][1] == sym && board[2][2] == sym) ||
                (board[0][2] == sym && board[1][1] == sym && board[2][0] == sym)) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void start() {
        printBoard();
        while (true) {
            playerMove(human);
            printBoard();
            if (checkWinner(human)) {
                System.out.println("Поздравляем, " + human.getName() + "! Вы победили!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            computerMove();
            printBoard();
            if (checkWinner(computer)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
