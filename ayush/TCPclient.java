import java.net.*;
import java.io.*;
import java.util.*;

public class TCPclient{
    public static void main(String[] args){

        try{
            Socket client=new Socket ("localhost" ,5000);
            System.out.println("server is connected");
            BufferedReader br=new BufferedReader (new InputStreamReader(client.getInputStream()));
            
            while (true) {
                String data=br.readLine();
                System.out.println("data from server: "+data);
            }

        }
        
        catch(Exception e){
            System.out.println(e);
        }
        

    }
}
