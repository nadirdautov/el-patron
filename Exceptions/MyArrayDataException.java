package Exceptions;

public class MyArrayDataException extends Exception {
    MyArrayDataException(String msg){
        super("Ошибка преобразования элемента массива в целое число.\n" + " " + msg);
    }
}
