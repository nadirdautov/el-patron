package java2lesson4;

public class lastElementException extends RuntimeException{

    public lastElementException(String s){
        System.out.println("Вы наткнулись на NullPointerException" + '\n' + s);
    }
}
