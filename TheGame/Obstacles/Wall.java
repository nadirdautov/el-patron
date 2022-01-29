package TheGame.Obstacles;

public class Wall extends Obstacles{
    private double wallHeight;
    private final String value = "м. ";

    public Wall(String name, double wallHeight){
        this.setName(name);
        this.wallHeight = wallHeight;
    }

    public double getWallHeight() {
        return wallHeight;
    }

    public String getValue() {
        return value;
    }
}
