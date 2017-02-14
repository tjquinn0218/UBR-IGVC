package robOS2.serial;

import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

public class Config {
	static Logger log = Logger.getLogger(Config.class.getName());
	
	private LinkedList<Device> _devices = new LinkedList<Device>();
	private Device _currentDevice;
	
	public Config() {
		log.info("New device configuration database created.");
		this.addSensor();
	}
	
	/**
	 * Adds a sensor to the sensor configuration database
	 */
	public void addSensor(){
		log.info("--> Adding a new device to the device configuration database");
		_currentDevice = new Device();
		_devices.add(_currentDevice);
	}
	
	/**
	 * Selects a sensor for the sensor configuration database. Run this to search
	 * for the sensor you want to access, then call methods on it.
	 * 
	 * @param name
	 */
	public void setSensor(String name){
		Iterator<Device> itr = _devices.iterator();
		try{
			while(itr.hasNext()){
				_currentDevice = itr.next();
				if(_currentDevice.getName().equalsIgnoreCase(name)){
					log.info("--> Active device in database set to: " + name);
					return;
				}
			}
		} catch (NullPointerException e){
			log.warn("No devices are in the database!");
		}
		
		log.warn("--> " + name + " could not be found in the device database!");
	}
	
	/**
	 * Sets the name of the sensor in the sensor configuration database
	 * 
	 * @param name
	 */
	public void setName(String name){
		_currentDevice.setName(name);
		log.debug("--> Device name set to: " + name);
	}
	
	/**
	 * Sets the sensor port in the sensor configuration database
	 * 
	 * @param port
	 */
	public void setPort(String port){
		_currentDevice.setPort(port);
		log.debug("--> Device port set to: " + port);
	}
	
	/**
	 * Sets the sensor baud rate in the sensor configuration database
	 * 
	 * @param baud
	 */
	public void setBaud(int baud){
		_currentDevice.setBaudRate(baud);
		log.debug("--> Device baud rate set to: " + baud);
	}
	
	/**
	 * Sets the parity in the sensor configuration database
	 * 
	 * @param parity
	 */
	public void setParity(int parity){
		_currentDevice.setParity(parity);
		log.debug("--> Device parity set to: " + parity);
	}
	
	public void setConnect(boolean connect){
		_currentDevice.setConnect(connect);
		log.debug("--> Device connection flag set to: " + connect);
	}
	
	/**
	 * Returns the name of the active sensor in the database
	 * 
	 * @return
	 */
	public String getName(){
		return _currentDevice.getName();
	}
	
	/**
	 * Returns the port of the active sensor in the database
	 * 
	 * @return
	 */
	public String getPort(){
		return _currentDevice.getPort();
	}
	
	/**
	 * Returns the baud rate of the active sensor in the database
	 * 
	 * @return
	 */
	public int getBaudRate(){
		return _currentDevice.getBaudRate();
	}
	
	/**
	 * Returns the parity of the active sensor in the database
	 * 
	 * @return
	 */
	public int getParity(){
		return _currentDevice.getParity();
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
		return _currentDevice.getConnect();
	}
	
	/**
	 * Returns a persistent reference to the current active device.
	 * 
	 * @return
	 */
	public Device getDevice(){
		return _currentDevice;
	}
}
