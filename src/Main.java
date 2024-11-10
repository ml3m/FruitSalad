import java.io.*;
import java.util.*;

public class Main {
    private static final String DATA_FILE = "clients_data.txt";
    private static List<Client> clients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        loadClientData();

        while (!exit) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add New Client");
            System.out.println("2. Buy Fruit for Existing Client");
            System.out.println("3. View Client Information");
            System.out.println("4. Save Data to File");
            System.out.println("5. Load Data from File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> addNewClient();
                case 2 -> buyFruit();
                case 3 -> viewClientInfo();
                case 4 -> saveClientData();
                case 5 -> loadClientData();
                case 6 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewClient() {
        System.out.print("Enter the client's name: ");
        String name = scanner.nextLine();

        try {
            for (Client client : clients) {
                if (client.getName().equalsIgnoreCase(name)) {
                    throw new ExistingClientException("Client with this name already exists.");
                }
            }
            clients.add(new Client(name));
            System.out.println("Client added successfully.");
        } catch (ExistingClientException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buyFruit() {
        System.out.print("Enter client's name to buy fruit: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.println("\nChoose fruit to buy:");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Mango");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter weight (in grams): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter sugar content (in %): ");
        double sugarContent = scanner.nextDouble();
        System.out.print("Enter water content (in %): ");
        double waterContent = scanner.nextDouble();
        scanner.nextLine();

        Fruit fruit = switch (choice) {
            case 1 -> new Apple(weight, sugarContent, waterContent, FruitColor.RED);
            case 2 -> new Banana(weight, sugarContent, waterContent);
            case 3 -> new Mango(weight, sugarContent, waterContent);
            default -> {
                System.out.println("Invalid choice. Fruit not added.");
                yield null;
            }
        };

        if (fruit != null) {
            client.buyFruit(fruit);
            System.out.println("Fruit added to client successfully.");
        }
    }

    private static void viewClientInfo() {
        System.out.print("Enter client's name to view information: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client != null) {
            client.printClientDetails();
        } else {
            System.out.println("Client not found.");
        }
    }

    private static Client findClientByName(String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    private static void saveClientData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Client client : clients) {
                writer.write("Client: " + client.getName());
                writer.newLine();
                for (Fruit fruit : client.getPurchasedFruits()) {
                    writer.write(fruit.getClass().getSimpleName() + ": ");
                    writer.write(fruit.getWeight() + " " + fruit.getSugarContent() + " " + fruit.getWaterContent());
                    writer.newLine();
                }
                writer.newLine();  // Separate clients
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadClientData() {
        clients.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            Client currentClient = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Client:")) {
                    String name = line.split(": ")[1];
                    currentClient = new Client(name);
                    clients.add(currentClient);
                } else if (currentClient != null && !line.isBlank()) {
                    String[] parts = line.split(": ");
                    String fruitType = parts[0];

                    // Split attributes and trim each part to remove commas and spaces
                    String[] attributes = parts[1].split(" ");

                    double weight = Double.parseDouble(attributes[0].replace(",", "").trim());
                    double sugarContent = Double.parseDouble(attributes[1].replace(",", "").trim());
                    double waterContent = Double.parseDouble(attributes[2].replace(",", "").trim());

                    Fruit fruit = switch (fruitType) {
                        case "Apple" -> new Apple(weight, sugarContent, waterContent, FruitColor.RED);
                        case "Banana" -> new Banana(weight, sugarContent, waterContent);
                        case "Mango" -> new Mango(weight, sugarContent, waterContent);
                            default -> null;
                    };

                    if (fruit != null) {
                        currentClient.buyFruit(fruit);
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
