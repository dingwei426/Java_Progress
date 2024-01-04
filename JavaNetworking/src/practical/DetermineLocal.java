package practical;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DetermineLocal {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Hostname: " + ip.getHostName());
			System.out.println("Host Address: " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
