package practical;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ConnectServer {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("www.javatutorial.com", 80);
			InetAddress ip = socket.getInetAddress();
			System.out.println("Connected to " + ip);
		} catch (IOException e) {
			System.out.println("Can't connect to " + args[0]);
			e.printStackTrace();
		}
	}

}
