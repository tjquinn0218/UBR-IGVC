package robOS2.navigation;

/**
 * Marker interface for local path planners.
 * 
 * @author dbaratta
 */
public interface IPathPlanner {
	
	/**
	 * Returns the last known *correct* Forward Velocity of the platform
	 * @return
	 */
	public double getForwardVelocity();
	
	/**
	 * Returns the last known *correct* Rotational Velocity of the platform
	 * @return
	 */
	public double getRotationalVelocity();

}
