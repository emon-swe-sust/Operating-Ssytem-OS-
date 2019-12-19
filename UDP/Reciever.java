package udp;

import java.net.InetSocketAddress;
import java.net.SocketException;
import java.io.IOException;
import java.util.Scanner;

public class Reciever {    
    
    
    public static void main(String[] args) {
      
    Scanner in = new Scanner(System.in);
    String Name;
    int Sourceport;
    int Destinationport;
    String DestinationIP;
    
    boolean main = false;
    boolean good = false;
    Channel channel = new Channel();
    InetSocketAddress address;
        
    Name = in.next();
    Sourceport = in.nextInt();
    Destinationport = in.nextInt();
    DestinationIP = in.next();
    
    try {
            channel.bind(Sourceport);
        } catch (SocketException ex) {
            System.out.println("Error");
        }
        address = new InetSocketAddress(DestinationIP,Destinationport);
        channel.start();
        System.out.println("Started : ");
    
     while(true)
     {
        String msg = in.nextLine();
        msg = Name +" >>  " + msg;
        try {
            channel.sendTo(address, msg);
        } catch (IOException ex) {
            System.out.println("Error");
        }
     }
    
    } 
}
