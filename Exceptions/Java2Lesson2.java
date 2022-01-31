package Exceptions;

import static java.lang.String.valueOf;

public class Java2Lesson2 {
    public static void main(String[] args) {
        String [][] stringArray0 = new String[][]{
                {"1","2","3","g"},
                {"h","1","2","5"},
                {"1","1","1","1"}
        };
        String [][] stringArray1 = new String[][]{
                {"1","2","3"},
                {"2","1","2","5"},
                {"3","1","1"},
                {"4","k","l","1"}
        };
        String [][] stringArray2 = new String[][]{
                {"6","2","3"},
                {"7","1","2"},
                {"8","1","1"},
                {"9","k","l"}
        };
        String [][] stringArray3 = new String[][]{
                {"11","2","3","g"},
                {"12","1","2","5"},
                {"13","1","1","1"},
                {"14","k","l","1"}
        };

        try {
            System.out.println("Сумма элементов массива равна " + Exceptions(stringArray0));
        } catch (MyArraySizeException | MyArrayDataException e ){
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + Exceptions(stringArray1));
        } catch (MyArraySizeException | MyArrayDataException e ){
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + Exceptions(stringArray2));
        } catch (MyArraySizeException | MyArrayDataException e ){
            System.out.println(e);
        }
        try {
            System.out.println("Сумма элементов массива равна " + Exceptions(stringArray3));
        } catch (MyArraySizeException | MyArrayDataException e ){
            System.out.println(e);
        }


    }

    private static int Exceptions (String [][] arr) throws MyArraySizeException, MyArrayDataException{
        int cub = 4;
        int num = 0;

        if(arr.length !=cub){
            throw new MyArraySizeException("Размерность массива должна быть 4х4");
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i].length != cub){
                throw new MyArraySizeException("Размерность массива должна быть 4х4");
            }
        }
        for(int i = 0; i<arr.length; i++){
            for (int j = 0; j< arr[i].length; j++){
                try{
                    num += Integer.valueOf(arr[i][j]);
                    } catch (NumberFormatException e){
                    throw new MyArrayDataException("В позиции исходного массива находится не целое число");
                }finally {
                    System.out.println("Мы прошли finally");
                }
            }
        }return num;
    }
}
