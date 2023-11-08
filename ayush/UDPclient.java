import java.net.*;
import java.io.*;

public class UDPclient {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            String message = "Hello from the client!";
            byte[] sendData = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Create a DatagramPacket to send data to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);

            // Send data to the server
            clientSocket.send(sendPacket);

            System.out.println("Sent: " + message);

            // Close the socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
