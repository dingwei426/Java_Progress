package practical;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectSocket {
   public static void main(String[] args) {
	   DataInputStream din;
      try {
         ServerSocket server = new ServerSocket(6123);
         do {
            System.out.println("Listening");
            Socket sock = server.accept();
    		din = new DataInputStream(sock.getInputStream());
            InetAddress addr = sock.getInetAddress();
            System.out.println("Connection made to " + addr.getHostName() + " 	(" + addr.getHostAddress() + ")");
            pause(5000);
            sock.close();
         } while(din.readUTF() != "stop");
      } catch (IOException e) {
         System.out.println("Exception detected: " + e);
      }
   }
   private static void pause(int ms) {
      try {
         Thread.sleep(ms);
      }catch (InterruptedException e) {}
   }
}