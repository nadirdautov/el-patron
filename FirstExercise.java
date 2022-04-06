package Java3Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstExercise{
       public  <T> void swapT(T[] array, int firstIndex, int secondIndex){
           T oneVal = array[firstIndex];
           array[firstIndex] = array [secondIndex];
           array[secondIndex] = oneVal;
       }

       public <T>ArrayList<T> converterToList(T[]array){
           return new ArrayList<>(Arrays.asList(array));
       }
}
