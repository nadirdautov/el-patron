package TheGame.Obstacles;


public class Racetrack extends Obstacles {
    private double trackLength;
    private final String value = "м. ";

    public Racetrack(String name, double trackLength){
        this.setName(name);
        this.trackLength = trackLength;
    }

    public double getTrackLength() {
        return trackLength;
    }

    public String getValue() {
        return value;
    }
}
