import java.io.InputStream;
import java.util.Scanner;

public class InputDevice {
    private InputStream inputStream;
    private Scanner scanner;

    public InputDevice(InputStream inputStream) {
        this.inputStream = inputStream;
        this.scanner = new Scanner(inputStream);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
