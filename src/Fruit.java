abstract class Fruit implements Comparable<Fruit> {
    private double weight;
    private double sugarContent;
    private double waterContent;
    private FruitColor color;

    public Fruit(double weight, double sugarContent, double waterContent, FruitColor color) {
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.waterContent = waterContent;
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public double getWaterContent() {
        return waterContent;
    }

    public FruitColor getColor() {
        return color;
    }

    public abstract void printFruitDetails();

    @Override
    public int compareTo(Fruit other) {
        return Double.compare(this.weight, other.weight);
    }
}
