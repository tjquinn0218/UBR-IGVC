package robOS2.serial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.TooManyListenersException;
import org.apache.log4j.Logger;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Connection {
	private InputStream _is;
	private OutputStream _os;
	private SerialPort _sp;
	private String _name;
	private SerialPortEventListener _listener;
	
	
	static Logger log = Logger.getLogger(Connection.class.getName());
	
	/**
	 * Initializes a new connection to a serial port.
	 */
	public Connection(String name) {
		super();
		
		_name = name;
	}
	
	public String getName(){
		return _name;
	}
	
	/**
	 * Connects to the serial port with the specified settings with NO parity
	 * bits
	 * 
	 * @param port - Name of the serial port (e.g. COM1)
	 * @param dataBits
	 * @param baudRate
	 * @throws Exception
	 */
	public void connectNoParity(String port, int dataBits, int baudRate) throws Exception{
		log.info("Connecting to: " + port + " at: " + baudRate +"kbps with no parity."); 
		this.connect(port, dataBits, baudRate, SerialPort.PARITY_NONE);
	}
	
	/**
	 * Connects to the serial port with the specified settings with EVEN parity
	 * bits
	 * 
	 * @param port - Name of the serial port (e.g. COM1)
	 * @param dataBits
	 * @param baudRate
	 * @throws Exception
	 */
	public void connectEvenParity(String port, int dataBits, int baudRate) throws Exception{
		log.info("Connecting to: " + port + " at: " + baudRate +"kbps with even parity.");
		this.connect(port, dataBits, baudRate, SerialPort.PARITY_EVEN);
	}
	
	/**
	 * Connects to the serial port with the specified settings with ODD parity
	 * bits
	 * 
	 * @param port - Name of the serial port (e.g. COM1)
	 * @param dataBits
	 * @param baudRate
	 * @throws Exception
	 */
	public void connectOddParity(String port, int dataBits, int baudRate) throws Exception{
		log.info("Connecting to: " + port + " at: " + baudRate +"kbps with odd parity.");
		this.connect(port, dataBits, baudRate, SerialPort.PARITY_ODD);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public void attachListener(SerialPortEventListener listener){
		_listener = listener;
		try {
			log.debug("Adding a listener to the serial port to process data.");
			_sp.addEventListener(_listener);
			_sp.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			log.fatal("Too many serial port listeners are attached! Dropping all listeners, and" +
					  " attempting to add the listener again.");
			
			// Drop all listeners, and add the requested listener again.
			_sp.removeEventListener();
			try {
				log.debug("Second attempt at adding the serial port listener.");
				_sp.addEventListener(_listener);
				_sp.notifyOnDataAvailable(true);
			} catch (TooManyListenersException e1) {
				log.fatal("Could not attach the serial port listener.");
			}
		}
	}
	
	public SerialPortEventListener getListener(){
		return _listener;
	}
	
	/**
	 * 
	 */
	public void disconnect(){
		_sp.close();
	}
	
	/**
	 * 
	 * @return
	 */
	public InputStream getInputStream(){
		return _is;
	}
	
	/**
	 * 
	 * @param port
	 * @param dataBits
	 * @param baudRate
	 * @param parity
	 * @throws Exception
	 */
	private void connect(String port, int dataBits, int baudRate, int parity) throws Exception{
		CommPortIdentifier id = CommPortIdentifier.getPortIdentifier(port);
		// Make sure nothing else "owns" the port
		if(id.isCurrentlyOwned()){
			log.fatal(port + " is already owned by another process! Connection failed.");
		} else {
			// we are good to go
			CommPort commPort = id.open(this.getClass().getName(), 2000);
			
			// Make sure the comm port really is a serial port
			if (commPort instanceof SerialPort){
				_sp = (SerialPort)commPort;
				_sp.setSerialPortParams(baudRate, dataBits, SerialPort.STOPBITS_1, parity);
				
				_is = _sp.getInputStream();
				_os = _sp.getOutputStream();
				
				(new Thread(new SerialWriter(_os))).start();
				
				//_sp.addEventListener(new SerialReader(_is));
				//_sp.notifyOnDataAvailable(true);
				log.info("Connection at: " + port + " was successful");
			} else {
				log.error(port + " is not a serial port.");
			}
		}
	}
	
	/**
	 * 
	 * @param data
	 */
	public void writeData(String data){
		try {
			_os.write(data.getBytes());
		} catch (IOException e) {
			log.fatal("Could not write to the serial port!");
		}
	}
	
	public void writeData(byte data[]){
		try {
			_os.write(data);
		} catch (IOException e) {
			log.fatal("Could not write to the serial port!");
		}
	}
	/**
	 * Added for turtlebot
	 * @param data
	 */
	public void writeData(int data) {
		try {
			_os.write(data);
		} catch (IOException e) {
			log.fatal("Could not write to the serial port!");
		}
	}
	
	public void writeData(byte data) {
		try {
			_os.write(data);
		} catch (IOException e) {
			log.fatal("Could not write to the serial port!");
		}
	}
	
	public void printLnData(String data){
		new PrintStream(_os).println(data);
	}
	
	
    /**
     * Handles the input coming from the serial port. A new line character
     * is treated as the end of a block.
     */
    public static class SerialReader implements SerialPortEventListener {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        
        public SerialReader ( InputStream in ) {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0) {
            int data;
          
            try {
                int len = 0;
                while ( ( data = in.read()) > -1 ) {
                    if ( data == '\n' ) {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                System.out.print(new String(buffer,0,len));
            }
            catch ( IOException e ) {
                e.printStackTrace();
                System.exit(-1);
            }             
        }

    }

    /**
     * 
     * @author dbaratta
     *
     */
    public static class SerialWriter implements Runnable {
        OutputStream out;
        
        /**
         * 
         * @param out
         */
        public SerialWriter ( OutputStream out ) {
            this.out = out;
        }
        
        /**
         * 
         */
        public void run () {
            try {                
                int c = 0;
                while ( ( c = System.in.read()) > -1 ) {
                    this.out.write(c);
                }                
            }
            catch ( IOException e ){
                e.printStackTrace();
                System.exit(-1);
            }            
        }
    }

	public OutputStream getOutputStream() {
		return _os;
	}



}
