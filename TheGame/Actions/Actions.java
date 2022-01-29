package TheGame.Actions;

import TheGame.Obstacles.Racetrack;
import TheGame.Obstacles.Wall;

public interface Actions {
    default boolean run(Racetrack racetrack){
        System.out.println("Пробежал");
        return true;
    }
    default boolean jump(Wall wall){
        System.out.println("Прыгнул");
        return true;
    }
}