package com.gb.pincode;

import java.util.Scanner;

public class for_gb_HW2 {
    public static void main(String[] args) {
        firstQuest();
        secondQuest();
        thirdQuest();
        fourthQuest();
        fifthQuest();
    }
    public static void firstQuest(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("сумма лежит в пределах от 10 до 20 (включительно), \n" +
                "если да – вернуть true, в противном случае – false");
        int a = keyboard.nextInt();
        int b = keyboard.nextInt();
        if(a>=10&&b>=10&&a<=20&&b<=20){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    public static void secondQuest(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("напечатать в консоль, положительное ли число передали или отрицательное");
        int a = keyboard.nextInt();
        if(a>=0){
            System.out.println("Число положительное");
        }else{
            System.out.println("Число отрицательно");
        }
    }
    public static void thirdQuest(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("true, если число отрицательное, и вернуть false если положительное");
        int a = keyboard.nextInt();
        boolean n = a>=0;
        System.out.println(n);
    }

    public static void fourthQuest() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз");
        System.out.println("Write the word");
        String word = keyboard.next();
        System.out.println("Enter the number");
        int n = keyboard.nextInt();
        int i = 0;
        while(i<n){
            System.out.println(word);
            i++;
        }

    }
    public static void fifthQuest(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("является ли год високосным");
        int age = keyboard.nextInt();
        boolean NoWestCoast = false;
        boolean WestCoast = true;
        if(age%4==0&&age%100!=0||age%400==0){
            System.out.println(WestCoast);

        } else{
            System.out.println(NoWestCoast);
        }
    }
}
