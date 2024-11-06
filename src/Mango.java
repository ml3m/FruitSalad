public class Mango extends Fruit implements Peelable, SeedRemovable {
    private boolean isPeeled;
    private boolean seedsRemoved;

    public Mango(double weight, double sugarContent, double waterContent) {
        super(weight, sugarContent, waterContent, FruitColor.YELLOW);
        this.isPeeled = false;
        this.seedsRemoved = false;
    }

    @Override
    public void printFruitDetails() {
        System.out.println("Mango Details:");
        System.out.println("Weight: " + getWeight() + " grams");
        System.out.println("Sugar Content: " + getSugarContent() + "%");
        System.out.println("Water Content: " + getWaterContent() + "%");
        System.out.println("Color: " + getColor());
        System.out.println("Is Peeled: " + (isPeeled ? "Yes" : "No"));
        System.out.println("Are Seeds Removed: " + (seedsRemoved ? "Yes" : "No"));
    }

    @Override
    public boolean hasPeel() {
        return !isPeeled;
    }

    @Override
    public void peelOff() {
        if (!isPeeled) {
            System.out.println("Peeling off the mango...");
            isPeeled = true;
        } else {
            System.out.println("The mango is already peeled.");
        }
    }

    @Override
    public boolean hasSeeds() {
        return !seedsRemoved;
    }

    @Override
    public void removeSeeds() {
        if (!seedsRemoved) {
            System.out.println("Removing seeds from the mango...");
            seedsRemoved = true;
        } else {
            System.out.println("The seeds have already been removed from the mango.");
        }
    }
}
