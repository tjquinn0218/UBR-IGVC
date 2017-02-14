package robOS2.hardware.interfaces.drivers;

import robOS2.mapping.lidar.ILIDARMap;

/**
 * Standardized interface for receiving data from a global positioning system.
 * 
 * Copyright 2011 UB Robotics & The State University of New York at Buffalo
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public interface ILIDAR {
	
	/**
	 * Returns the maximum distance the LIDAR is configured to detect obstacles at in
	 * centimeters (e.g. 5000 for 5 meters.)
	 * @return Maximum obstacle detection distance
	 */
	public int getMaxRange();
	
	/**
	 * Returns the measured angle to the object that is nearest to the LIDAR unit.
	 * 
	 * NOTE: This value is relative to the scan radius of the LIDAR, not the
	 * Cartesian cord. system. If you have a LIDAR with a scan radius of 180 degrees
	 * the angles will need to be interpreted differently than if you have a LIDAR
	 * with a scan radius of 270 degrees.
	 * @return Measured angle to the nearest object
	 */
	public double getAngleToNearestObsticle();
	
	/**
	 * Returns the measured distance to the nearest object in centimeters.
	 * e.g. 1750 would be returned for a object thats 1.750 meters away. 
	 * @return Distance to the nearest object in centimeters
	 */
	public int getDistanceToNearestObsticle();
	
	/**
	 * Returns the current scan radius of the unit in degrees.
	 * e.g. 180 for 180 degrees or 270 for 270 degrees. 
	 * @return
	 */
	public int getScanRadius();
	
	/**
	 * Returns the number of data-points sampled by the LIDAR.
	 * e.g. if the LIDAR unit has 0.5 degree resolution and a scan radius of
	 * 180 degrees 360 would be returned.
	 * @return Number of data points sampled in a scan
	 */
	public int getScanSteps();
	
	/**
	 * Returns a "map" of the last known objects picked up by the LIDAR. This
	 * map has been pre-configured based on the XML setup file that was provided
	 * when RobOS2 was started.
	 * @return Representation of the last known obstacles to the LIDAR.
	 */
	public ILIDARMap getLIDARMap();
	
	/**
	 * <b>OPTIONAL</b> This method is an optional part of this interface. If
	 * this method is not implemented by the particular sensor a empty string
	 * will be returned. 
	 * @return
	 */
	public String getVendor();
	
	/**
	 * <b>OPTIONAL</b> This method is an optional part of this interface. If
	 * this method is not implemented by the particular sensor a empty string
	 * will be returned.
	 * @return
	 */
	public String getProtocol();
}
