package ulpgc;

public class Person {
    private final int index;
    private final double height;
    private final double weight;


    public Person(int index, double height, double weight) {
        this.index = index;
        this.height = height;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}