package com.kuspanova.hard;

import java.util.Random;

class Field {
    private int[][] grid = new int[10][10];
    private Random rnd = new Random();

    public int[][] getGrid() {
        return grid;
    }

    private boolean canPlaceShip(int x, int y, int length, boolean horizontal) {
        for (int i = 0; i < length; i++) {
            int xi = x + (horizontal ? 0 : i);
            int yi = y + (horizontal ? i : 0);
            if (xi < 0 || xi >= 10 || yi < 0 || yi >= 10) return false;
            if (grid[xi][yi] != 0) return false;

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = xi + dx;
                    int ny = yi + dy;
                    if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && grid[nx][ny] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void placeShip(int x, int y, int length, boolean horizontal) {
        for (int i = 0; i < length; i++) {
            int xi = x + (horizontal ? 0 : i);
            int yi = y + (horizontal ? i : 0);
            grid[xi][yi] = 1;
        }
    }

    public void placeAllShips() {
        int[] ships = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

        for (int length : ships) {
            boolean placed = false;
            while (!placed) {
                int x = rnd.nextInt(10);
                int y = rnd.nextInt(10);
                boolean horizontal = rnd.nextBoolean();
                if (canPlaceShip(x, y, length, horizontal)) {
                    placeShip(x, y, length, horizontal);
                    placed = true;
                }
            }
        }
    }

    public boolean shoot(int x, int y) {
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            return true;
        } else if (grid[x][y] == 0) {
            grid[x][y] = 3;
        }
        return false;
    }

    public boolean hasShips() {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return true;
            }
        }
        return false;
    }

    public void printField(boolean hideShips) {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                int cell = grid[i][j];
                if (cell == 0) System.out.print(". ");
                else if (cell == 1) System.out.print(hideShips ? ". " : "■ ");
                else if (cell == 2) System.out.print("X ");
                else if (cell == 3) System.out.print("o ");
            }
            System.out.println();
        }
    }
}

