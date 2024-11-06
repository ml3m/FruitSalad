import java.io.IOException;
import java.io.OutputStream;

public class OutputDevice {
    private OutputStream outputStream;

    public OutputDevice(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String data) {
        try {
            outputStream.write(data.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // For closing the output stream when done
    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
