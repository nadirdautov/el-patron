package com.gb.pincode;

import java.util.Scanner;

public class for_gb_1_HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign ();
        printColor();
        compareNumbers();
    }
    public static void printThreeWords() {
            String first = "Orange";
            String second = "Banana";
            String third = "Apple";
            System.out.println(first + '\n' + second + '\n' + third);
        }
        public static void checkSumSign () {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the first number");
            int a = keyboard.nextInt();
            System.out.println("Enter the second number");
            int b = keyboard.nextInt();
            a += b;
            if (a >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }

        }

    public static void printColor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value to choose a color");
        int value = scanner.nextInt();
        String red = "Красный";
        String yellow = "Жёлтый";
        String green = "Зелёный";
        if(value>0&&value<=100) {
            System.out.println(yellow);
        }else if(value<0) {
            System.out.println(red);
        }else{
            System.out.println(green);
    }
    }
    public static void  compareNumbers(){
        Scanner k = new Scanner(System.in);
        System.out.println("Enter numbers for Compare Numbers");
        int a = k.nextInt();
        int b = k.nextInt();
        if(a>=b){
            System.out.println("a>=b");
        }else{
            System.out.println("a<b");
        }
    }
}