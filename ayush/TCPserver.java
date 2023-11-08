import java.net.*;
import java.io.*;
import java.util.*;
public class TCPserver {

    public static void main(String[] args){
        try {
            //cs=cslient socket , ss=server socket
            ServerSocket ss=new ServerSocket(5000);
            System.out.println("Waiting for Client.....");
            Socket cs =ss.accept();
            System.out.println("Server is connected");
            System.out.println("client is connected: "+cs.getInetAddress());

            //send data from server to client
            Scanner sc=new Scanner(System.in);
            PrintWriter pw=new PrintWriter(cs.getOutputStream());

            while(true){
                System.out.println("Enter data: ");
                String data= sc.nextLine();
                pw.println(data);
                pw.flush();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}