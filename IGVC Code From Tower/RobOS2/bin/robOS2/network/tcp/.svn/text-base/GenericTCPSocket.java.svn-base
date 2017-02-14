package robOS2.network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;

import robOS2.network.listener.AndriodBigBlueNetworkListener;
import robOS2.network.listener.INetworkListener;
import robOS2.network.listener.VisionListener;

/**
 * Creates a new non-blocking TCP Socket. In order to recieve data from this
 * socket you need to also create and attach a INetworkListener to the
 * newly created socket.
 * 
 * @author <a href = "mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public class GenericTCPSocket {
	static Logger log = Logger.getLogger(GenericTCPSocket.class.getName());
	private INetworkListener _listener;
	private OutputStream _os;
	private InputStreamReader _isr;
	private ServerSocket _socket;
	
	/**
	 * Creates a new TCP / IP socket connection to the specified
	 * host and port.
	 * 
	 * @param host
	 * @param port
	 */
	public GenericTCPSocket() {
		try {
			_socket = new ServerSocket(5993);
			
			log.info("Connected to: " + " on port: ");
			
			while(true){
				System.out.println("Waiting for a connection");
				Socket s = _socket.accept();
				System.out.println("got a connection");
				//BufferedReader socketRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//OutputStreamWriter socketWrite = new OutputStreamWriter(s.getOutputStream());
				//while(s.isConnected()){
				//	System.out.println("Recieved: " + socketRead.readLine());
				//}
				//System.out.println("Socket disconnected");
				new AndriodBigBlueNetworkListener(s);
			}
		} catch (Exception e){
			
		}

	}
	

	
	public static void main(String[] args) {
//		GenericTCPSocket socket = new GenericTCPSocket("localhost", 5993);
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//socket.attachListener(new VisionListener(_is));
		new GenericTCPSocket();
	}
}
