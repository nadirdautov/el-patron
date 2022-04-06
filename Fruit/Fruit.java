package Java3Lesson1.Fruit;

public abstract class Fruit {
    private float weight;
    private String name;

    public Fruit(float weight, String name) {
        this.name = name;
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
