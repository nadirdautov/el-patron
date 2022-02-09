package Threads;

public class ThreadHomeWork {
    /*1. Необходимо написать два метода, которые делают следующее:
    1) Создают одномерный длинный массив, например:

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    2) Заполняют этот массив единицами;
    3) Засекают время выполнения: long a = System.currentTimeMillis();
    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    5) Проверяется время окончания метода System.currentTimeMillis();
    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

    Отличие первого метода от второго:
    Первый просто бежит по массиву и вычисляет значения.
    Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

    Пример деления одного массива на два:

            System.arraycopy(arr, 0, a1, 0, h);
    System.arraycopy(arr, h, a2, 0, h);

    Пример обратной склейки:

            System.arraycopy(a1, 0, arr, 0, h);
    System.arraycopy(a2, 0, arr, h, h);

    Примечание:
            System.arraycopy() – копирует данные из одного массива в другой:
            System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
            массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
    По замерам времени:
    Для первого метода надо считать время только на цикл расчета:

            for (int i = 0; i < size; i++) {
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.*/
   /* public class psvm {
        public static void main(String[] args) {
            int size = 10;
            float [] f = new float[size];
            int half = size/2;
            f = new float[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
            float [] newF = new float[size];
            System.arraycopy(f,0,newF,half,half);
            for (int i = 0; i<newF.length; i++){
                System.out.println(newF[i]);
            }
        }
    }*/

    static final int size = 10000000;
    static final int h = size/2;

    public static void main(String[] args) {
        /* 1) Создают одномерный длинный массив, например:*/
        float[] arr = new float[size];

        /*2) Заполняют этот массив единицами;*/
        filledArray(arr);

        /*3) Засекают время выполнения: long a = System.currentTimeMillis();*/
        long a = System.currentTimeMillis();
        /* 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));*/
        method1(arr);

        /*5) Проверяется время окончания метода System.currentTimeMillis();*/
        /*6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);*/
        System.out.println("Before with method1: " + (System.currentTimeMillis() - a));

        System.out.println();
        /*3) Засекают время выполнения: long a = System.currentTimeMillis();*/
        a = System.currentTimeMillis();

        /* 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));*/
        method2(arr);

        /*5) Проверяется время окончания метода System.currentTimeMillis();*/
        /*6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);*/
        System.out.println("After with method2: " + (System.currentTimeMillis() - a));

    }

    /*2) Заполняют этот массив единицами;*/
    public static void filledArray (float [] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }

    /*4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));*/
    public static void method1 (float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void method2x (float[] arr, int h) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
        }
    }
    public static void method2 (float[] arr){
        float arr1 [] = new float[h];
        float arr2 [] = new float[h];

        System.arraycopy(arr,0,arr1,0,h);
        System.arraycopy(arr,h,arr2,0,h);



        new Thread (() -> ThreadHomeWork.method2x(arr1,0)).start();
        new Thread(()-> ThreadHomeWork.method2x(arr2,h)).start();

        System.arraycopy(arr1,0,arr,0,h);
        System.arraycopy(arr2,0,arr,h,h);




    }
}



