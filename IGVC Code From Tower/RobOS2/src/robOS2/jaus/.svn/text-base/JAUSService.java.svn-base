package robOS2.jaus;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.apache.log4j.Logger;

public class JAUSService implements Runnable{
	static Logger log = Logger.getLogger(JAUSService.class.getName());
	private boolean _isRunning = false;
	private DatagramSocket _socket;

	/**
	 * Starts the JAUS Service. This will not only send new JAUS packets,
	 * it will also monitor for new packets coming from the COP
	 */
	public void start(){
		_isRunning = true;
	}
	
	/**
	 * Stops the JAUS Service. No more packets will be sent after the service
	 * is stopped, and new incoming packets will be ignored.
	 */
	public void stop(){
		_isRunning = false;
	}
	
	/**
	 * Keeps the tread running. DO NOT call this method to start it up. Instead
	 * call the start() method. That will take care of all the checks
	 * ensuring that everything is up and running like it should be.
	 */
	@Override
	public void run() {
		while(_isRunning == false){
			
		}
	}
	
	/**
	 * Sends a UDP Packet out to the specified address and port in the IJAUSConfig
	 * file. This also checks to make sure the connection is open, and if it is
	 * not issues a fatal log4j message and simply returns from the function.
	 * 
	 * @param packet - Datagram packet to be sent out.
	 */
	public void sendPacket(DatagramPacket packet){
		//Check to make sure we are connected.
		if (_socket == null || _socket.isClosed()){
			log.fatal("UDP Connection is not open. Can not send any packets!");
			return;
		}
		
		//We are connected, go ahead and feel free to send packets
		try {
			_socket.send(packet);
			log.debug("UDP Packet sent");
		} catch (IOException e) {
			log.error("An IO Exception occured while attempting to send the UDP " +
					  "packet. " + e.getStackTrace().toString());
		}
	}
}
