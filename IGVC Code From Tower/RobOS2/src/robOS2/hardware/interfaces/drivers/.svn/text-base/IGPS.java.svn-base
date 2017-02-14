package robOS2.hardware.interfaces.drivers;

/**
 * Standardized interface for receiving data from a global positioning system.
 * 
 * Copyright 2011 UB Robotics & The State University of New York at Buffalo
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public interface IGPS {

	/**
	 * Returns the last known latitude reading of the unit. If the unit has been
	 * off or without signal for a period of time this reading may not be correct.
	 * @return Last known latitude reading
	 */
	public double getLatitude();
	
	/**
	 * Returns the last known longitude reading of the unit. If the unit has been
	 * off or without signal for a period of time this reading may not be correct.
	 * @return Last known longitude reading
	 */
	public double getLongitude();
	
	/**
	 * Returns the current temperature of the GPS unit. If this feature is not implemented
	 * Double.Max() will be returned.
	 * @return Current temperature of the GPS unit
	 */
	public double getTemperature();
	
	/**
	 * Returns the current velocity of the platform in m/s
	 * @return Current velocity in meters per second
	 */
	public double getVelocity();
	
	
	/**
	 * Returns the current altitude of the GPS unit in (feet?)
	 * @return Current altitude of the GPS unit
	 */
	public double getAltitude();
	
	/**
	 * Returns how many satellites the unit is currently connected to.
	 * If this feature is not implemented Integer.Max() will be returned.
	 * @return Number of connected satellites
	 */
	public int getNumberOfSatsConnected();
	
	/**
	 * Returns the last known estimated error in cm of the GPS signals. If the
	 * unit has been off or without signal for a period of time this reading may
	 * not be correct. If this feature is not implemented Integer.Max() will
	 * be returned.
	 * @return Last known estimated error
	 */
	public int getEstimatedError();
	
}
