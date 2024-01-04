package practical;

import java.net.MalformedURLException;
import java.net.URL;

public class GetURLPath {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.tutorialspoint.com/cpp_standard_library/cpp_fstream_close.htm");
		      System.out.println("URL is " + url.toString());
		      System.out.println("protocol is " + url.getProtocol());
		      System.out.println("file name is " + url.getFile());
		      System.out.println("host is " + url.getHost());
		      System.out.println("path is " + url.getPath());
		      System.out.println("port is " + url.getPort());
		      System.out.println("default port is " + url.getDefaultPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
