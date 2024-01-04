package practical;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetLastModified {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.tutorialspoint.com/cpp_standard_library/cpp_fstream_close.htm");
			URLConnection uc = url.openConnection();
			System.out.println("Last Modified Date: " + uc.getLastModified());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
