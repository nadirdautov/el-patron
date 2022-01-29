package TheGame.Human;

import TheGame.Actions.Actions;
import TheGame.Obstacles.Racetrack;
import TheGame.Obstacles.Wall;

public class Human implements Actions {
    private final double jumpHeight;
    private final double runDistance;

    public Human(double jumpHeight, double runDistance){
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }
    public boolean run(Racetrack racetrack){
        if(this.runDistance > racetrack.getTrackLength()) {
            System.out.printf("Человек пробежал беговую дорожку длинной в %,.2f%s \n", racetrack.getTrackLength(), racetrack.getValue());
            return true;
        } else {
            System.out.printf("Человек не смог пробежать беговую дорожку длинной в %,.2f%s\n", racetrack.getTrackLength(), racetrack.getValue());
        }
        return false;
    }
    public boolean jump(Wall wall){
        if(this.jumpHeight > wall.getWallHeight()){
            System.out.printf("Человек перепрыгнул стену высотой в %, .2f%s \n", wall.getWallHeight(),wall.getValue());
            return true;
        }else {
            System.out.printf("Человек не смог перепрыгнуть стену высотой в  %.2f%s \n", wall.getWallHeight(),wall.getValue());
        }
        return false;
    }
}
