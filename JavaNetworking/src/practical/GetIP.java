package practical;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GetIP {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hostname: ");
		String hostname = input.next();
		try {
			InetAddress ip = InetAddress.getByName(hostname);
			System.out.println("Hostname: " + ip.getHostName());
			System.out.println("IP Address: " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
