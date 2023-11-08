import java.net.*;
import java.io.*;

public class UDPserver {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];

            while (true) {
                // Create a DatagramPacket to receive data
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive data from the client
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Display received data
                System.out.println("Received: " + message);

                // Reset the buffer
                receiveData = new byte[1024];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
