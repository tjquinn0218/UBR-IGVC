package robOS2.jaus;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;

public class UDPConnect implements IJAUSConfig{
	static Logger log = Logger.getLogger(UDPConnect.class.getName());
	private static DatagramSocket _socket;
	
	/**
	 * Constructor to connect to a UDP socket. The connection address is
	 * specified in the IJAUSConfig file. The specific connection information
	 * should be obtained from your local JAUS official
	 */
	public UDPConnect() {
		try {
			_socket = new DatagramSocket();
			InetAddress address = InetAddress.getByAddress(IP_ADDRESS);
			_socket.connect(address, PORT);
			
			log.debug("JAUS Socket opened on: " + address.toString() + ":" + PORT);
		} catch (SocketException e) {
			log.fatal("An unexpected error occured while attempting to connect" +
					  " to the JAUS Socket." + e.getStackTrace());
		} catch (UnknownHostException e) {
			log.fatal("The JAUS host could not be resolved! Check your IP " +
					  "settings in the IJAUSConfig interface." + e.getStackTrace());
		}
	}
	
	/**
	 * Closes the UDP JAUS connection. After closing this you can't send or
	 * receive any more JAUS packets.
	 */
	public void UDPClose(){
		_socket.close();
		_socket = null;
		log.debug("JAUS Socket closed.");
	}
	
	/**
	 * Returns the DatagramSocket being used to communicate to the JAUS host.
	 * @return DatagramSocket - Returns the socket being used for communication.
	 *         If the socket is not open it will simply return null.
	 */
	static DatagramSocket getSocket(){
		return _socket;
	}
}
