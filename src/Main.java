//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /* data is hardcoded for now */

        Fruit apple = new Apple(150, 10, 85, FruitColor.RED);
        Fruit banana = new Banana(120, 12, 80);
        Fruit mango = new Mango(200, 15, 70);
        Fruit greenApple = new Apple(130, 8, 86, FruitColor.GREEN);

        // Create clients
        Client client1 = new Client("Mlem");
        Client client2 = new Client("Ghost");
        Client client3 = new Client("Yuzu");

        // Clients buy fruits
        client1.buyFruit(apple);
        client1.buyFruit(banana);

        client2.buyFruit(mango);

        client3.buyFruit(banana);
        client3.buyFruit(mango);
        client3.buyFruit(greenApple);

        // Add clients to an array and sort
        Client[] clients = { client1, client2, client3 };
        Arrays.sort(clients);

        // Print sorted client details
        System.out.println("Clients sorted by the number of fruits bought:\n");
        for (Client client : clients) {
            client.printClientDetails();
            System.out.println();
        }
    }

    /*
    public static double computeWeight(Fruit[] fruits) {
        double totalWeight = 0;
        for (Fruit fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }
     */

    /*
    public static double computeSugarContent(Fruit[] fruits) {
        double totalSugarContent = 0;
        for (Fruit fruit : fruits) {
            totalSugarContent += (fruit.getWeight() * (fruit.getSugarContent() / 100));
        }
        return totalSugarContent;
    }
    */


    /*
    public static void askUserForFile(InputDevice inputDevice, OutputDevice outputDevice) {
        while (true) {
            outputDevice.write("Enter the name of the file to read: ");
            String fileName = inputDevice.readLine();

            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                Scanner fileScanner = new Scanner(fileInputStream);
                while (fileScanner.hasNextLine()) {
                    outputDevice.write(fileScanner.nextLine() + "\n");
                }
                fileScanner.close();
                break; 
            } catch (IOException e) {
                outputDevice.write("Error reading file. Please try another file.\n");
            }
        }
    }*/


    /*public static void writeRandomNumbers(InputDevice inputDevice, OutputDevice outputDevice) {
        Random random = new Random();

        while (true) {
            outputDevice.write("Enter the name of the file to write random numbers: ");
            String fileName = inputDevice.readLine();

            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                for (int i = 0; i < 10; i++) {
                    int randomNumber = random.nextInt(100); 
                    String numberString = randomNumber + "\n";
                    fileOutputStream.write(numberString.getBytes());
                }
                break;
            } catch (IOException e) {
                outputDevice.write("Error writing to file. Please try another file.\n");
            }
        }
    }
     */
}
