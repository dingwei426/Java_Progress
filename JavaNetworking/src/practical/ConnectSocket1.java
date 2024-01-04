package practical;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectSocket1 {	
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("localhost", 6123);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = "";
			while (!str.equals("stop")) {
				str = br.readLine();
				dout.writeUTF(str);
				dout.flush();
			}

			dout.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
