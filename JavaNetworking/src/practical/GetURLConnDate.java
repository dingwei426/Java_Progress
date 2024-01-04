package practical;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class GetURLConnDate {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://www.tutorialspoint.com/cpp_standard_library/cpp_fstream_close.htm");
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println("Connection Date: " + new Date(uc.getDate()));
			uc.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
