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

    public List<Fruit> getPurchasedFruits() {
        return purchasedFruits;
    }

    public void buyFruit(Fruit fruit) {
        purchasedFruits.add(fruit);
    }

    public void printClientDetails() {
        System.out.println("=======================================");
        System.out.printf(" Client: %s | Total Fruits Bought: %d%n", name, purchasedFruits.size());
        System.out.println("=======================================");
        
        Fruit[] fruitsArray = purchasedFruits.toArray(new Fruit[0]);
        FruitPreparation.sortFruitsByWeight(fruitsArray);

        System.out.println(" Fruits (sorted by weight):");
        System.out.println("\n------------------------------");
        System.out.println(); // Adds a blank line between clients for readability
    }

    @Override
    public int compareTo(Client other) {
        return Integer.compare(other.purchasedFruits.size(), this.purchasedFruits.size());
    }
}
