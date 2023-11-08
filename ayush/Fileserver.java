import java.io.*;
import java.net.*;

public class Fileserver {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress());

            // Create input and output streams for file transfer
            FileInputStream fileInputStream = new FileInputStream("sendfile.txt");
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Transfer the file
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the streams and socket
            fileInputStream.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("File transfer complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
