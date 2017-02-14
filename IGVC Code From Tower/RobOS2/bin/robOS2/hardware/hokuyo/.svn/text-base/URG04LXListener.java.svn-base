package robOS2.hardware.hokuyo;

import java.io.InputStream;

import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.listeners.ILIDARListener;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class URG04LXListener implements ILIDARListener, SerialPortEventListener{
	static Logger log = Logger.getLogger(URG04LXListener.class.getName());
	private byte[] buffer = new byte[1024];
	private InputStream _in;
	
	/**
	 * Serial listener for the Hokuyo URG-04-LX series LIDAR. This class was built
	 * using the documentation provided by Hokuyo at the following URL:
	 * 
	 * @param in
	 */
	public URG04LXListener(InputStream in) {
		_in = in;
	}
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {
		int data;
        int len = 0;
        boolean secondNewLine = false;
        try{
	        // Read in the data until a new line character is seen
	        while ( ( data = _in.read()) > -1 ) {
	            if ( (data == '\n') && secondNewLine) {
	            	break;
	            } else if (data == '\n'){
	            	secondNewLine = true;
	            } else {
	            	buffer[len++] = (byte) data;
	            }
	        }
	        //lastReading = new String(buffer, 0, len);
	        log.debug(new String(buffer, 0, len-1));
        } catch (Exception e){
        	// Lets just ignore errors from this sensor :)
        }
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}
}
