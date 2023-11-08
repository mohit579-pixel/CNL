import java.io.*;
import java.net.*;

public class Fileclient {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server on port 12345
            Socket socket = new Socket("localhost", 12345);

            // Create input and output streams for file transfer
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt");

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Transfer the file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            // Close the streams and socket
            fileOutputStream.close();
            inputStream.close();
            socket.close();
            System.out.println("File received and saved as 'received_file.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
