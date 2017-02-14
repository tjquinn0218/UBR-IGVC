package robOS2.serial;

public class Device {
	private String _name;
	private String _port;
	private int _baudRate;
	private int _parity;
	private boolean _connect = true;

	/**
	 * Sets the name of hardware device, which is used when searching for the
	 * device when you would like to use it.
	 * 
	 * @param name
	 */
	public void setName(String name){
		_name = name;
	}
	
	/**
	 * Sets the port that the device is attached to on the system.
	 * e.g. "COM6"
	 * 
	 * @param port
	 */
	public void setPort(String port){
		_port = port;
	}
	
	/**
	 * Sets the baud rate that is used to talk to the device. Please refer to
	 * the device documentation for the correct baud rate.
	 * 
	 * @param baudRate
	 */
	public void setBaudRate(int baudRate){
		_baudRate = baudRate;
	}
	
	/**
	 * Sets the parity that is used when talking to the device. 
	 * 
	 * @param parity
	 */
	public void setParity(int parity){
		_parity = parity;
	}
	
	/**
	 * Returns the name of the hardware device that is stored in the database
	 * 
	 * @return
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Returns the port the device is communicating on.
	 * 
	 * @return
	 */
	public String getPort(){
		return _port;
	}
	
	/**
	 * Returns the baud rate being used for communication to the device
	 * 
	 * @return
	 */
	public int getBaudRate(){
		return _baudRate;
	}
	
	/**
	 * Returns the parity being used to communicate to the device
	 * 
	 * @return
	 */
	public int getParity(){
		return _parity;
	}
	
	/**
	 * Sets a flag if we should actually connect to this device or not. If this
	 * value is set to TRUE then the device will be connected to when asked.
	 * However, if this value is set to FALSE then the device won't be connected
	 * to no matter how many times it is asked.
	 * @param connect
	 */
	public void setConnect(boolean connect){
		_connect = connect;
	}
	
	/**
	 * Returns TRUE if we should actually connect to the device. If this returns
	 * FALSE no connection should be made to the device.
	 * 
	 * This value defaults to TRUE
	 * 
	 * @return
	 */
	public boolean getConnect(){
		return _connect;
	}
}
