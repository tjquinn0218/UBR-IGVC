package robOS2.gps;

import org.apache.log4j.Logger;

/**
 * GPS Waypoint data-structure.
 * 
 * @author dbaratta
 */
public class Waypoint {
	static Logger log = Logger.getLogger(Waypoint.class.getName());
	private double _lat;
	private double _long;
	private String _name = "NO_NAME_PROVIDED";
	
	/**
	 * Default constructor. If this constructor is used <b>MAKE SURE</b> to use
	 * the setter methods for latitude and longitude or they will be NULL
	 */
	public Waypoint() {
		log.warn("Empty waypoint constructor was used. Make sure to use the " +
				"setter methods for critical information such as latitude " +
				"and longitude.");
	}
	
	/**
	 * Creates a new waypoint and also sets the latitude and longitude of
	 * the waypoint.
	 * 
	 * @param latitude - Latitude of the new waypoint
	 * @param longitude - Longitude of the new waypoint
	 */
	public Waypoint(double latitude, double longitude){
		log.debug("Creating a new waypoint with the following traits:\n" +
				"\tLatitude:\t" + latitude +
				"\n\tLongitude:\t" + longitude);
		
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	/**
	 * Creates a new waypoint and also sets the name, latitude and longitude
	 * of the waypoint.
	 * 
	 * @param name - Name of the new waypoint
	 * @param latitude - Latitude of the new waypoint
	 * @param longitude - Longitude of the new waypoint
	 */
	public Waypoint(String name, double latitude, double longitude){
		log.debug("Creating a new waypoint with the following traits:\n" +
				"\tName:\t\t" + name +
				"\n\tLatitude:\t" + latitude +
				"\n\tLongitude:\t" + longitude);
		
		this.setName(name);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	/**
	 * Method to set the desired latitude of the GPS waypoint.
	 * @param latitude
	 */
	public void setLatitude(double latitude){
		log.info("Setting Latitude to: " + latitude);
		_lat = latitude;
	}
	
	/**
	 * Method to set the desired longitude of the GPS waypoint.
	 * @param longitude
	 */
	public void setLongitude(double longitude){
		log.info("Setting Longitude to: " + longitude);
		_long = longitude;
	}
	
	/**
	 * Method to set the desired "name" of the GPS waypoint. This is not
	 * critical to the correct functioning of the waypoint, however it is
	 * handy for debug purposes.
	 * @param name
	 */
	public void setName(String name){
		log.info("Setting Name to: " + name);
		_name = name;
	}
	
	/**
	 * Returns the latitude of the GPS waypoint.
	 * @return
	 */
	public double getLatitude(){
		return _lat;
	}
	
	/**
	 * Returns the longitude of the GPS waypoint.
	 * @return
	 */
	public double getLongitude(){
		return _long;
	}
	
	/**
	 * Returns the name of the GPS waypoint. If no name has been provided
	 * "NO_NAME_PROVIDED" will be returned.
	 * @return
	 */
	public String getName(){
		return _name;
	}
}
