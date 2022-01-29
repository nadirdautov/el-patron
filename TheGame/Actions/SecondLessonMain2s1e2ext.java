package TheGame.Actions;

import TheGame.Cat.Cat;
import TheGame.Human.Human;
import TheGame.Obstacles.Obstacles;
import TheGame.Obstacles.Racetrack;
import TheGame.Obstacles.Wall;
import TheGame.Robot.Robot;

import java.util.ArrayList;

public class SecondLessonMain2s1e2ext {
    public static ArrayList<Obstacles>ObstaclesCreate(){
        ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
        Obstacles newRacetrack = new Racetrack("Беговая дорожка", 1000);
        Obstacles newWall = new Wall("Стена", 2);

        obstacles.add(newRacetrack);
        obstacles.add(newWall);
        return obstacles;
    }
    public static ArrayList<Actions>ActionsCreate(){
        ArrayList<Actions> actions = new ArrayList<Actions>();
        Actions newHuman = new Human(1.5,3000);
        Actions newRobot = new Robot(4,500);
        Actions newCat = new Cat(0.5,100);

        actions.add(newHuman);
        actions.add(newRobot);
        actions.add(newCat);

        return actions;
    }


    public static void main(String[] args) {
        ArrayList<Obstacles> obstacles = ObstaclesCreate();
        ArrayList<Actions> actions = ActionsCreate();

        for(Actions action : actions){
            for (Obstacles obstacle: obstacles){
                boolean result = false;
                if(obstacle instanceof Wall){
                    Wall wall = (Wall) obstacle;
                    System.out.printf("Впереди %s высотой %,.2f%s \n",obstacle.getName(),wall.getWallHeight(),wall.getValue());
                    result = action.jump(wall);
                } else if (obstacle instanceof Racetrack){
                    Racetrack racetrack = (Racetrack) obstacle;
                    System.out.printf("Впереди %s длиной %,.2f%s \n",obstacle.getName(),racetrack.getTrackLength(),racetrack.getValue());
                    result = action.run(racetrack);
                } else{
                    break;
                }
            }
        }
    }
}
