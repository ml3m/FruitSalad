public class Apple extends Fruit implements SeedRemovable {
    private boolean seedsRemoved;

    public Apple(double weight, double sugarContent, double waterContent, FruitColor color) {
        super(weight, sugarContent, waterContent, color);
        this.seedsRemoved = false;
    }

    @Override
    public void printFruitDetails() {
        System.out.println("Apple Details:");
        System.out.println("Weight: " + getWeight() + " grams");
        System.out.println("Sugar Content: " + getSugarContent() + "%");
        System.out.println("Water Content: " + getWaterContent() + "%");
        System.out.println("Color: " + getColor());
        System.out.println("Are Seeds Removed: " + (seedsRemoved ? "Yes" : "No"));
    }

    @Override
    public boolean hasSeeds() {
        return !seedsRemoved;
    }

    @Override
    public void removeSeeds() {
        if (!seedsRemoved) {
            System.out.println("Removing seeds from the apple...");
            seedsRemoved = true;
        } else {
            System.out.println("The seeds have already been removed from the apple.");
        }
    }

}
