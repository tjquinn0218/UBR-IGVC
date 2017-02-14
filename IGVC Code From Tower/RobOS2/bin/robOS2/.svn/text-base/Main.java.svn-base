package robOS2;

import java.io.IOException;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import robOS2.hardware.hokuyo.URG04LX;
import robOS2.hardware.interfaces.drivers.ICompass;
import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.hardware.interfaces.drivers.IGPS;
import robOS2.hardware.interfaces.drivers.IGenericMotor;
import robOS2.hardware.interfaces.drivers.ILIDAR;
import robOS2.hardware.interfaces.drivers.IMechWheel;
import robOS2.hardware.novatel.propak3.ProPak3Driver;
import robOS2.hardware.pni.tcm26.TCM26Driver;
import robOS2.hardware.sick.PLS112Driver;
import robOS2.hardware.ubr.UBRMotorController;
import robOS2.network.SystemID;
import robOS2.serial.Config;
import robOS2.serial.ConnectionManager;
import robOS2.xml.GPSParser;
import robOS2.xml.HardwareParser;


/*
 * \mainpage Welcome to the RobOS2 Documentation
 * RobOS2 is a custom developed autonomous robotic software suite for the
 * intelligent ground vehicle competition. This software is developed
 * mostly in the Java programming language.
 * 
 * \section install_sec Install Instructions
 */



/**
 * Main launcher for the command line version of RobOS2
 * 
 * Copyright 2011 UB Robotics & The State University of New York at Buffalo
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public class Main {
	static Logger log = Logger.getLogger(Main.class.getName());
	private Config _config;
	private ConnectionManager _connMgr;
	private static IGenericMotor GENERIC_MOTOR_DRIVER;
	private static ILIDAR GENERIC_LIDAR_DRIVER;
	private static ICompass GENERIC_COMPASS_DRIVER;
	private static IGPS GENERIC_GPS_DRIVER;

	/**
	 * Loads all the present XML Configuration files into their respective databases.
	 */
	public void loadXML(){
		log.info("Loading XML Configuration Files.");
		
		//Start with loading the hardware XML configuration file
		log.info("--> Loading the hardware XML configuration file");
		_config = new Config();
		HardwareParser hardwareParser = new HardwareParser(_config);
		try {
			hardwareParser.parse("C:\\Users\\dbaratta\\workspace\\RobOS2\\src\\hardware_config.xml");
		} catch (IOException e) {
			log.fatal("An I/O Exception has occured while parsing in the hardware" +
					  " configuration file. Is the path to the file correct?");
		} catch (SAXException e) {
			log.fatal("A XML exception has occured while parsing in the hardware" +
					  " configuration file. Is the synthax of the file correct?");
		}
		log.info("--> Loading of the hardware XML configuration file is complete.");
		
		//Next parse in the GPS Waypoint's from the GPS XML configuration file
		log.info("--> Loading the GPS XML configuration file");
		GPSParser gpsParser = new GPSParser();
		try {
			gpsParser.parse("C:\\Users\\dbaratta\\workspace\\RobOS2\\src\\gps_waypoints.xml");
		} catch (IOException e) {
			log.fatal("An I/O Exception has occured while parsing in the GPS" +
					  " configuration file. Is the path to the file correct?");
		} catch (SAXException e) {
			log.fatal("A XML exception has occured while parsing in the GPS" +
					  " configuration file. Is the synthax of the file correct?");
		}
		log.info("--> Loading of the GPS XML configuration file is complete.");
	}
	
	public void initHardware(){
		log.info("Initializing hardware devices");
		
		//Create a new ConnectionManager
		_connMgr = new ConnectionManager(_config);
		
		//Try to connect to the MOTOR_DRIVER first
		if(ConnectionManager.openConnection("MOTOR_DRIVER") != null){
			GENERIC_MOTOR_DRIVER = new UBRMotorController(ConnectionManager.getConnection("MOTOR_DRIVER"));
		}
		
		//Try to connect to the LIDAR
		if(ConnectionManager.openConnection("LIDAR") != null){
			GENERIC_LIDAR_DRIVER = new PLS112Driver();
		}
		
		//Try to connect to the Hokuyo
		if(ConnectionManager.openConnection("Hokuyo") != null){
			GENERIC_LIDAR_DRIVER = new URG04LX(ConnectionManager.getConnection("Hokuyo"));
		}
		
		//Try to connect to the COMPASS
		if(ConnectionManager.openConnection("COMPASS") != null){
			GENERIC_COMPASS_DRIVER = new TCM26Driver(ConnectionManager.getConnection("COMPASS"));
		}
		
		//Try to connect to the GPS
		if(ConnectionManager.openConnection("GPS") != null){
			GENERIC_GPS_DRIVER = new ProPak3Driver(ConnectionManager.getConnection("GPS"));
		}
		
		log.info("All hardware devices are initialized.");
	}
	
	public void initNetwork(){
		try {
			log.info("Network Configuration Information:\n" +
					 "\t\t\tHostname:\t" + SystemID.getSystemHostname() + 
					 "\n\t\t\tIP Address:\t" + SystemID.getSystemIPAddress() +
					 "\n\t\t\tPlatform Name:\t" + SystemID.getPlatformName());
		} catch (UnknownHostException e) {
			log.warn("An error has occured in the network initialization");
		}
	}
	
	public static ICompass getActiveCompass(){
		return GENERIC_COMPASS_DRIVER;
	}
	
	public static IGPS getActiveGPS(){
		return GENERIC_GPS_DRIVER;
	}
	
	public static ILIDAR getActiveLIDAR(){
		return GENERIC_LIDAR_DRIVER;
	}
	
	public static IGenericMotor getActiveMotorDriver(){
		return GENERIC_MOTOR_DRIVER;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.loadXML();
		main.initHardware();
		main.initNetwork();
	}
}
