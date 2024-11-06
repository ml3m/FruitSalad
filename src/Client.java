import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client> {
    private String name;
    private List<Fruit> purchasedFruits;

    public Client(String name) {
        this.name = name;
        this.purchasedFruits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getFruitCount() {
        return purchasedFruits.size();
    }

    public void buyFruit(Fruit fruit) {
        purchasedFruits.add(fruit);
    }

    public void printClientDetails() {
        System.out.println("=======================================");
        System.out.printf(" Client: %s | Total Fruits Bought: %d%n", name, getFruitCount());
        System.out.println("=======================================");
        
        // Convert List to Array to use the sortFruitsByWeight method
        Fruit[] fruitsArray = purchasedFruits.toArray(new Fruit[0]);

        // Sort fruits by weight in ascending order
        FruitPreparation.sortFruitsByWeight(fruitsArray);

        System.out.println(" Fruits (sorted by weight):");
            System.out.println("\n------------------------------");
        System.out.println(); // Adds a blank line between clients for better readability
    }

    @Override
    public int compareTo(Client other) {
        // Sort by the number of fruits bought in descending order
        return Integer.compare(other.getFruitCount(), this.getFruitCount());
    }
}
