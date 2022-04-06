package Java2Lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<Long>>map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void addSecondName(String secondName){
        map.put(secondName, new ArrayList<>());
    }

    public void addNumberBySecondName(String secondName, long phoneNumber){
        if(map.containsKey(secondName)){
            map.get(secondName).add(phoneNumber);
        } else {
            System.out.println("SecondName not found");
        }
    }
    public ArrayList<Long> getPhoneNumbersBySecondName (String secondName){
        return map.get(secondName);
    }

}
