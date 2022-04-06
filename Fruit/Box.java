package Java3Lesson1.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Box <T extends Fruit>{
    private ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }
    public float getWeight(){
        float weight = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            T o = list.get(i);
            weight = weight + o.getWeight();
        }
        return weight;
    }
    //переложим
    public void sprinkle (Box<T> another){
        another.list.addAll(list);
        list.clear();
    }


    public boolean compare(Box<?> another) {
        if (this.getWeight() == another.getWeight()) return true;
        return false;
    }

    public void add(T fruit) {
        list.add(fruit);
    }
    // Хз но вроде правильно заюзал, сорри видосы 2013года мне в помощь) хехе
    public void add(Collection<T> fruit) {
        list.addAll(fruit);
    }

}
