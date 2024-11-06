public class Banana extends Fruit implements Peelable {
    private boolean isPeeled;

    public Banana(double weight, double sugarContent, double waterContent) {
        super(weight, sugarContent, waterContent, FruitColor.YELLOW);
        this.isPeeled = false;
    }

    @Override
    public void printFruitDetails() {
        System.out.println("Banana Details:");
        System.out.println("Weight: " + getWeight() + " grams");
        System.out.println("Sugar Content: " + getSugarContent() + "%");
        System.out.println("Water Content: " + getWaterContent() + "%");
        System.out.println("Color: " + getColor());
        System.out.println("Is Peeled: " + (isPeeled ? "Yes" : "No"));
    }

    @Override
    public boolean hasPeel() {
        return !isPeeled;
    }

    @Override
    public void peelOff() {
        if (!isPeeled) {
            System.out.println("Peeling off the banana...");
            isPeeled = true;
        } else {
            System.out.println("The banana is already peeled.");
        }
    }
}
