package robOS2.serial;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Keeps track of the open connections to hardware devices. This class is also
 * used to open new connections to hardware devices. It also ensures that only
 * one connection is open at a time to any given device.
 * 
 * Copyright 2011 UB Robotics & The State University of New York at Buffalo
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public final class ConnectionManager {
	static Logger log = Logger.getLogger(ConnectionManager.class.getName());
	
	// Instance variable to keep track of what connections are open. This is a THREAD SAFE
	// implementation of a linked list, which is why it is a synchronizedList.
	private static List<Connection> _connections = Collections.synchronizedList(new LinkedList<Connection>());
	private static Config _cfg;
	
	/**
	 * Creates a new connection manager with the provided device configuration database.
	 * 
	 * @param cfg
	 */
	public ConnectionManager(Config cfg) {
		_cfg = cfg;
	}
	
	/**
	 * Method to create a new serial connection, and add it to the open connection database.
	 * This sets the initial baud rate and parity based on the XML Configuration file. If the
	 * baud rate or parity need to be changed that must be done manually.
	 * 
	 * @param name
	 * @return
	 */
	public static Connection openConnection(String name){
		//First search for the connection to make sure its not already open
		Connection conn = search(name);
		
		//Check to make sure a connection to the device isnt already open.
		if(conn != null){
			log.fatal("Device already has an open connection");
			return conn;
		} else {
			//Set the active device in the device configuration database
			_cfg.setSensor(name);
			int parity = _cfg.getParity();	//Grab the device's parity
			if(_cfg.getConnect()){			//Make sure we are actually supposed to connect
				log.debug("Connecting to: " + name);
				conn = new Connection(name); //Create a new connection
				switch(parity){
				//Connect with no parity
				case 0:
					try {
						conn.connectNoParity(_cfg.getPort(), 8, _cfg.getBaudRate());
					} catch (Exception e) {
						log.fatal("An error occured while connecting to " + name + " the stack "
								+ "is: " + e.getStackTrace());
					}
					break;
					
				//Connect with even parity
				case 1:
					try {
						conn.connectEvenParity(_cfg.getPort(), 8, _cfg.getBaudRate());
					} catch (Exception e) {
						log.fatal("An error occured while connecting to " + name + " the stack "
								+ "is: " + e.getStackTrace());
					}
					break;
				
				//Connect with odd parity
				case 2:
					try {
						conn.connectOddParity(_cfg.getPort(), 8, _cfg.getBaudRate());
					} catch (Exception e) {
						log.fatal("An error occured while connecting to " + name + " the stack "
								+ "is: " + e.getStackTrace());
					}
					break;
					
				//Connect with no parity, and issue warning about unsupported parity
				default:
					log.warn("Unsupported parity! Defaulting to no parity.");
					try {
						conn.connectNoParity(_cfg.getPort(), 8, _cfg.getBaudRate());
					} catch (Exception e) {
						log.fatal("An error occured while connecting to " + name + " the stack "
								+ "is: " + e.getStackTrace());
					}
					break;
				
				}
				_connections.add(conn); //Add the connection to the open connections database
				log.info("Connection " + name + " opened and added to database.");
			} else {
				log.warn("Not connecting to: " + name + " as per the XML configuration file");
				return null;
			}
			return conn;
		}
	}
	
	/**
	 * Searches the current connection database for a open connection with the provided name
	 * running.
	 * 
	 * @param name
	 * @return
	 */
	public static Connection getConnection(String name){
		log.debug("Searching for " + name);
		return ConnectionManager.search(name);
	}
	
	/**
	 * Searches for a connection identified by the provided name, disables the connection and
	 * then removes it from the open connections database.
	 * 
	 * @param name
	 */
	public void removeConnection(String name){
		Connection conn = ConnectionManager.search(name);
		conn.disconnect();
		_connections.remove(conn);
		log.info("Connection " + name + " closed & removed from database.");
	}
	
	private static Connection search(String name){
		Iterator<Connection> itr = _connections.iterator();
		Connection tempConn;
		while (itr.hasNext()){
			tempConn = itr.next();
			if(tempConn.getName().equalsIgnoreCase(name)){
				return tempConn;
			}
		}
		
		return null;
	}

}
