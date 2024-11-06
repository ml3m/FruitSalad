import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FruitPreparation {

    // Sort fruits by weight
    public static void sortFruitsByWeight(Fruit[] fruits) {
        Arrays.sort(fruits);
        System.out.println("Fruits sorted by weight:");
        int fruits_c = 1;
        for (Fruit fruit : fruits) {
            System.out.printf("\n----------- Fruit %d ------------", fruits_c);
            fruits_c++;
            fruit.printFruitDetails();
        }
    }

    // Sort fruits by sugar content
    public static void sortFruitsBySugarContent(Fruit[] fruits) {
        Arrays.sort(fruits, Comparator.comparingDouble(Fruit::getSugarContent));
        System.out.println("Fruits sorted by sugar content:");
        for (Fruit fruit : fruits) {
            fruit.printFruitDetails();
        }
    }

    // Group fruits by color
    public static void groupFruitsByColor(Fruit[] fruits) {
        Map<FruitColor, List<Fruit>> groupedByColor = Arrays.stream(fruits)
                .collect(Collectors.groupingBy(Fruit::getColor));

        System.out.println("Fruits grouped by color:");
        for (FruitColor color : groupedByColor.keySet()) {
            System.out.println(color + ":");
            for (Fruit fruit : groupedByColor.get(color)) {
                fruit.printFruitDetails();
            }
        }
    }
}
