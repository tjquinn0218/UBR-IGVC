package robOS2.network.tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTester {
	
	public TCPTester() {
		try {
			Socket testSocket = new Socket("localhost", 5993);
			OutputStreamWriter osw = new OutputStreamWriter(testSocket.getOutputStream());
			
			osw.write("Hello World!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new TCPTester();
	}

}
