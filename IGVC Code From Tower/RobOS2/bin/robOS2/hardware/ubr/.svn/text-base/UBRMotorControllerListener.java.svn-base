package robOS2.hardware.ubr;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.listeners.IFourMotorListener;
import gnu.io.SerialPortEvent;

public class UBRMotorControllerListener implements IFourMotorListener {
	static Logger log = Logger.getLogger(UBRMotorController.class.getName());
	
    private InputStream in;
    private byte[] buffer = new byte[1024];
    private int _lastE1 = Integer.MIN_VALUE;		// Initialize initial
    private int _lastE2 = Integer.MIN_VALUE;		// encoder values to the
    private int _lastE3 = Integer.MIN_VALUE;		// minimum value of an
    private int _lastE4 = Integer.MIN_VALUE;		// int so we know if we
    												// got good data
    
    /**
     * Creates a new motor controller listener based on the provided input
     * stream.
     */
    public UBRMotorControllerListener ( InputStream in ) {
        this.in = in;
    }
	
    /**
     * Listens for new data received on the serial line.
     */
	@Override
	public void serialEvent(SerialPortEvent arg0) {
        int data;
      
        try {
            int len = 0;
            // Read in the data until a new line character is seen
            while ( ( data = in.read()) > -1 ) {
                if ( data == '\n' ) {
                    break;
                }
                buffer[len++] = (byte) data;
            }
            String output = new String(buffer, 0, len);
            log.debug("Recieved: " + output.substring(0, output.length()-1) +
            		  " from the motor controller");
            
            char firstChar = output.charAt(0);	// Figure out the type of data
            char secondChar = output.charAt(1);	// Figure out exact sensor
            switch(firstChar){
            case 'E':
            	switch(secondChar){
            	case '1':
            		// Front left wheel encoder
            		_lastE1 = Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '2':
            		// Back left wheel encoder
            		_lastE2 = Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '3':
            		// Front right wheel encoder
            		_lastE3 = Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '4':
            		// Back right wheel encoder
            		_lastE4 = Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case 'S':
            		log.warn("ESTOP Message recieved from the robot!");
            		break;
            	}
            	break;
            case 'e':
            	switch(secondChar){
            	case '1':
            		// Front left wheel encoder
            		_lastE1 = -Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '2':
            		// Back left wheel encoder
            		_lastE2 = -Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '3':
            		// Front right wheel encoder
            		_lastE3 = -Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	case '4':
            		// Back right wheel encoder
            		_lastE4 = -Integer.parseInt(output.substring(2, output.length()-1));
            		break;
            	}
            	break;
            	
            case 'L':
            	// We need to load a profile & respond with "Go"
            	String loadOutput = output.substring(4, 6);
            	log.info("substring is: " + loadOutput);
            	switch (loadOutput.charAt(0)){
            	case 'A':
            		switch(loadOutput.charAt(1)){
            		case '1':
            			// LoadA1 Command
            			log.info("Recieved LoadA1 command from the robot.");
            			break;
            		case '2':
            			// LoadA2 Command
            			log.info("Recieved LoadA2 command from the robot.");
            			break;
            		case '3':
            			// LoadA3 Command
            			log.info("Recieved LoadA3 command from the robot.");
            			break;
            		}
            		break;
            		
            	case 'N':
            		switch(loadOutput.charAt(1)){
            		case '1':
            			// LoadN1 Command
            			log.info("Recieved LoadN1 command from the robot.");
            			break;
            		case '2':
            			// LoadN2 Command
            			log.info("Recieved LoadN2 command from the robot.");
            			break;
            		case '3':
            			// LoadN3 Command
            			log.info("Recieved LoadN3 command from the robot.");
            			break;
            		}
            		break;
            		
            	case 'D':
            		switch(loadOutput.charAt(1)){
            		case '1':
            			// LoadD1 Command
            			log.info("Recieved LoadD1 command from the robot.");
            			break;
            		case '2':
            			// LoadD2 Command
            			log.info("Recieved LoadD2 command from the robot.");
            			break;
            		case '3':
            			// LoadD3 Command
            			log.info("Recieved LoadD3 command from the robot.");
            			break;
            		case '4':
            			// LoadD4 Command
            			log.info("Recieved LoadD4 command from the robot.");
            			break;
            		}
            		break;
            	}
            	break;
            }

        }
        
        // Oh noes something went wrong!
        catch ( IOException e ) {
        	log.error("An IO Exception occured!");
        }             
    }
	
	/**
	 * Returns the last left front encoder value that was pushed up
	 * 
	 * If no values have been pushed up this method will simply return
	 * then minimum value of an integer. (Integer.MIN_VALUE)
	 * 
	 * @return int - last known value of the left front encoder
	 */
	public int getLastE1(){
		return _lastE1;
	}

	/**
	 * Returns the last left rear encoder value that was pushed up
	 * 
	 * If no values have been pushed up this method will simply return
	 * then minimum value of an integer. (Integer.MIN_VALUE)
	 * 
	 * @return int - last known value of the left rear encoder
	 */
	public int getLastE2(){
		return _lastE2;
	}
	
	/**
	 * Returns the last right front encoder value that was pushed up
	 * 
	 * If no values have been pushed up this method will simply return
	 * then minimum value of an integer. (Integer.MIN_VALUE)
	 * 
	 * @return int - last known value of the right front encoder
	 */
	public int getLastE3(){
		return _lastE3;
	}
	
	/**
	 * Returns the last right rear encoder value that was pushed up
	 * 
	 * If no values have been pushed up this method will simply return
	 * then minimum value of an integer. (Integer.MIN_VALUE)
	 * 
	 * @return int - last known value of the right rear encoder
	 */
	public int getLastE4(){
		return _lastE4;
	}
}
