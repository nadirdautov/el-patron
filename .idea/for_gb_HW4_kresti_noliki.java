package com.company.gb;

import java.util.Random;
import java.util.Scanner;

public class for_gb_HW4_kresti_noliki {
    public static final Scanner keyboard = new Scanner(System.in);
    public static final int DOTS_TO_WIN = 3;
    public static final char DOTS_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] MAP;
    public static int SIZE = 3;
    public static final Random RANDOM = new Random();



    public static void main(String[] args) {
        initMap();
        printMap();
            while (true) {
                HumanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Human is winner");
                    printMap();
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("AI is Winner");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }


            }
            System.out.println("игра окончена");
        }


    public static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
            System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        } while (!isCellValid(x, y));

        MAP[x][y] = DOT_O;
    }

    private static void HumanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате 'x' and 'y'");
            x = keyboard.nextInt() - 1;
            y = keyboard.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[y][x] = DOT_X;
    }
    public static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, symbol)) return true;
                if (checkLine(i, j, 1, 1, symbol)) return true;
                if (checkLine(i, j, 1, 0, symbol)) return true;
                if (checkLine(i, j, -1, 1, symbol)) return true;
            }
        }
        return false;
    }


    public static boolean checkLine(int y, int x, int yDir, int xDir, char symbol) {
        int wayX = x + (DOTS_TO_WIN - 1) * xDir;
        int wayY = y + (DOTS_TO_WIN - 1) * yDir;
        if (wayX < 0 || wayY < 0 || wayX > SIZE - 1 || wayY > SIZE - 1) return false;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (MAP[y + i * yDir][x + i * xDir] != symbol) return false;
        }
        return true;
    }




    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (MAP[x][y] == DOTS_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOTS_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOTS_EMPTY;
            }
        }
    }


}
