package Java2Lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ArrayManager {
    public static void main(String[] args) {
        /**
         * Java. Level 2. Lesson 3. HomeWork3
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         *    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         *    Этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
         *    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
         *    тогда при запросе такой фамилии должны выводиться все телефоны.
         **/



        //capacity of List equals 12 and size equals 12
        ArrayList<String> stringArrayList = new ArrayList<>(12);
        /*1*/stringArrayList.add("Kazakhstan");
        /*2*/stringArrayList.add("Kazakhstan");
        /*3*/stringArrayList.add("Kazakhstan");
        /*4*/stringArrayList.add("Kazakhstan");
        /*5*/stringArrayList.add("Ukraine");
        /*6*/stringArrayList.add("Russia");
        /*7*/stringArrayList.add("Kazakhstan");
        /*8*/stringArrayList.add("Ireland");
        /*9*/stringArrayList.add("England");
        /*10*/stringArrayList.add("Latvia");
        /*11*/stringArrayList.add("Germany");
        /*12*/stringArrayList.add("France");

        Map <String,Integer> counter = new HashMap<>();

        ArrayList<String> uniqueList = new ArrayList<>();
        for (int i = 0; i < stringArrayList.size(); i++) {
            String unique = stringArrayList.get(i);
            if (!uniqueList.contains(unique))
                uniqueList.add(unique);
            if (!counter.containsKey(unique)) {
                counter.put(unique, 1);
            }else {
                int count = counter.get(unique);
                counter.put(unique,count+1);
            }
        }
        for(String element : uniqueList){
            System.out.println(element);
        }

        for(Map.Entry<String,Integer> entry : counter.entrySet()){
            System.out.println(entry.getKey()+ " repeats " + entry.getValue() + " times");
        }
        // Так второе задание, сорян тупой я такой
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addSecondName("Dautov");
        phoneBook.addSecondName("Kabaev");
        phoneBook.addNumberBySecondName("Dautov",87770261166L);
        phoneBook.addNumberBySecondName("Dautov",87710375477L);
        phoneBook.addNumberBySecondName("Kabaev",87056000776L);

        System.out.println("\nSecond practice");

        System.out.println(phoneBook.getPhoneNumbersBySecondName("Dautov"));

    }


}
