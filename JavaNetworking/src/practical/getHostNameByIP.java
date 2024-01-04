package practical;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getHostNameByIP {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("74.125.67.100");
			System.out.println("Hostname: " + ip.getHostName());
			System.out.println("IP Address: " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
