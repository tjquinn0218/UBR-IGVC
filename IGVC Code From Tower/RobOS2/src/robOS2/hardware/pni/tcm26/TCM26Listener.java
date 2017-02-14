package robOS2.hardware.pni.tcm26;

import java.io.InputStream;

import org.apache.log4j.Logger;

import gnu.io.SerialPortEvent;
import robOS2.hardware.interfaces.listeners.ICompassListener;

public class TCM26Listener implements ICompassListener{
	static Logger log = Logger.getLogger(TCM26Listener.class.getName());
	
	private byte[] buffer = new byte[1024];
	private InputStream in;
	private String lastReading = "";
	 
	public TCM26Listener(InputStream in) {
		this.in = in;
		log.debug("New TCM26 Listener created.");
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		int data;
		
        int len = 0;
        
        try{
	        // Read in the data until a new line character is seen
	        while ( ( data = in.read()) > -1 ) {
	            if ( data == '\n' ) {
	                break;
	            }
	            buffer[len++] = (byte) data;
	        }
	        
	        lastReading = new String(buffer, 0, len);
	        
        } catch (Exception e){
        	
        }
        
//        String output = new String(buffer, 0, len);
//        log.debug("Recieved: " + output.substring(0, output.length()-1) +
//        		  " from the compass");
	}
	
	public double getPitch() {
		return getData('P');
	}
	
	public double getRoll() {
		return getData('R');
	}
	
	public double getTemperature() {
		return getData('T');
	}
	
	public double getXMagnetometer() {
		return getData('X');
	}
	
	public double getYMagnetometer() {
		return getData('Y');
	}
	
	public double getZMagnetometer() {
		return getData('Z');
	}
	
	@SuppressWarnings("unused")
	private double getData(char filter){
		//double result;
		String temp = "";
		
		for(int i = 0; i < lastReading.length(); i++){
			// Test if we found the start of what we are looking for
			if(lastReading.charAt(i) == filter){
				// Found what we wanted. Make a temp string to hold
				// the output and parse it.

				for(int a = ++i; a < lastReading.length(); a++){
					if(Character.isLetter(lastReading.charAt(a))){
						break;
					} else {
						temp = temp + lastReading.charAt(a);
					}
				}
				
				break;
			}
		}
		if(temp != null){
			return Double.parseDouble(temp);
		}
		
		return filter;
	}

}
