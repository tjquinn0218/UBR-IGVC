package robOS2.hardware.interfaces.drivers;

/**
 * Standardized interface for receiving data from a digital compass unit.
 * 
 * Copyright 2011 UB Robotics & The State University of New York at Buffalo
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public interface ICompass {
	
	/**
	 * Returns the current pitch reading of the platform
	 * @return platform pitch. If this is not implemented Double.Max() will be returned.
	 */
	public double getPitch() ;
	
	/**
	 * Returns the current roll reading of the platform
	 * @return platform roll. If this is not implemented Double.Max() will be returned.
	 */
	public double getRoll();
	
	/**
	 * Returns the current temp. of the compass, not necessarily the
	 * outside environment. 
	 * @return Returns the current compass temp. If this is not implemented Double.Max() will be returned.
	 */
	public double getTemperature();
	
	/**
	 * Returns the current heading (in degrees) of the platform.
	 * @return Current heading in degrees. If this is not implemented Double.Max() will be returned.
	 */
	public double getHeading();
	
	/**
	 * Returns true if the compass is currently setup to operate in "True North"
	 * mode instead of magnetic north.
	 * @return True if the compass is in True North mode
	 */
	public boolean trueNorth();
	
	/**
	 * Returns the x-component of the magnetic field in uT
	 * @return x-magnetometer reading. If this is not implemented Double.Max() will be returned.
	 */
	public double getXMagnetometer();
	
	/**
	 * Returns the y-component of the magnetic field in uT
	 * @return y-magnetometer reading. If this is not implemented Double.Max() will be returned.
	 */
	public double getYMagnetometer();
	
	/**
	 * Returns the z-component of the magnetic field in uT
	 * @return z-magnetometer reading. If this is not implemented Double.Max() will be returned.
	 */
	public double getZMagnetometer();
	
}
