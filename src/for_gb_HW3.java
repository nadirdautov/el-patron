package com.gb.pincode;

import java.util.Scanner;

    public class for_gb_HW3 {
        public static void main(String[] args) {
            first();
            second();
            third();
            fourth();
            fifth();
            sixth();
            seventh();
            eighth();
        }

        public static void first() {
            int [] x = {0,1,0,1,1,1,0,0,1,0};
            for(int i = 0; i<x.length;i++){
                if(x[i]==0 ){
                    x[i] = 1;
                } else if(x[i]==1){
                    x[i] = 0;
                }
                System.out.println (i + "-" + x[i]+" ");
            }


        }
        public static void second(){
            int [] sum = new int[100];
            for(int i = 0; i<sum.length;i++){
                sum[i] = i +1 + sum[i];
                System.out.println(i + ": " + sum[i]+" ");
            }
        }
        public static void third(){
            int [] num = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for(int i= 0;i<num.length;i++){
                if(num[i]<6){
                    num[i] *= 2;
                    System.out.println(i + " if: " + num[i] + " ");
                }else{
                    System.out.println(i + " else: " + num[i] + " ");
                }
            }
        }
        public static void fourth(){
            int[][] matrice = new int[3][3];
            for(int i = 0; i<matrice.length;i++){
                for (int j = 0, x = matrice[i].length; j < matrice[i].length; j++, x--) {
                    if (i == j || i == x - 1) matrice[i][j] = 1;
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
        public static void fifth(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Количество внутри массива крч");
            int len = keyboard.nextInt();
            System.out.println("Че будет внутри количества, устал объяснять");
            int initialValue = keyboard.nextInt();
            int [] returningAOneDimensionalArray = new int[len];
            for(int i = 0; i<returningAOneDimensionalArray.length; i++){
                returningAOneDimensionalArray[i] = initialValue;
                System.out.print(returningAOneDimensionalArray[i] + " ");

            }
            System.out.println();

        }
        public static void sixth(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a amount of number");
            int n = keyboard.nextInt();
            int [] array = new int[n];
            for(int i = 0; i<array.length;i++){
                array[i] = keyboard.nextInt();
            }
            int min = array [0];
            for (int i = 0; i<array.length; i++){
                if(min>array[i]){
                    min=array[i];
                }
            }
            int max = array [0];
            for(int i = 0; i<array.length; i++){
                if(max<array[i]){
                    max=array[i];
                }
            }
            System.out.println("Max value is: " + max );
            System.out.println("Min value is: " + min);

        }
        public static void seventh(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter n number");
            int n = keyboard.nextInt();
            int [] array = new int[n];
            int equality = 0;
            for(int i = 0; i<array.length;i++) {
                System.out.println("Enter the array[i]");
                array[i] = keyboard.nextInt();
                equality = equality + array[i];
            }
            System.out.println(equality);
            if(equality % 2 == 0){                          //просто какая разница что право что лево для нас
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
        public static void eighth(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Пропиши сдвиг");
            int k = keyboard.nextInt();
            System.out.println("Количество элементов");
            int n = keyboard.nextInt();
            int[] array = new int[n];
            int i;
            int l=0;
            for (i = 0; i < n; i++) {
                System.out.println("Пропиши циферки");
                array[i] = keyboard.nextInt();
                l = i+k; // обычка
                if(l<n) {
                    System.out.println(l); //проверь работает или нет
                }
                else if(l == n){
                    l = l-n;  //равенство
                    System.out.println(l);
                }else if(l>n){
                    l = k-1; //ну он уже вышел за рамки
                    System.out.println(l);

                }
            }
        }
    }