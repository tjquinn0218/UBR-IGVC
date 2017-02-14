package robOS2.mapping.lidar;

import org.apache.log4j.Logger;

import robOS2.mapping.IMapConfig;
import robOS2.utility.Math;

public class LIDARMap implements IMapConfig{
	static Logger log = Logger.getLogger(LIDARMap.class.getName());
	private static int _totalSize = (int)(LIDAR_TOTAL_RANGE * Math.Inverse(LIDAR_STEP_SIZE));
	private static double[] _map = new double[_totalSize];
	private static int _maxRange = -1;
	
	/**
	 * Clears the LIDAR Map
	 */
	public static void Clear(){
		_map = new double[_totalSize];
	}
	
	/**
	 * Returns the last known distance from the lidar at the requested angle.
	 * 
	 * @param angle
	 * @return
	 */
	public static double getDistanceAtAngle(double angle){
		return _map[convertAngle(angle)];
	}
	
	/**
	 * Sets the clear distance from LIDAR data.
	 * 
	 * @param angle
	 * @param distance
	 */
	public static void setDistanceAtAngle(double angle, double distance){
		_map[convertAngle(angle)] = distance;
	}
	
	/**
	 * Sets the distance at a known array index to the provided distance.
	 * 
	 * @param index
	 * @param distance
	 */
	public static void setDistanceAtIndex(int index, double distance){
		if(index >= _totalSize){
			log.error("The provided LIDAR index was above the capacity of the array."
					+ " The provided data is NOT being added!");
			return;
		}
		_map[index] = distance;
	}
	
	/**
	 * Converts the angle in degrees to its corresponding array position for 
	 * position updates.
	 * 
	 * @param angle
	 * @return
	 */
	private static int convertAngle(double angle){
		return (int)(angle / LIDAR_STEP_SIZE);
	}
	
	/**
	 * Returns the total size of the array holding the distance information
	 * from the LIDAR unit.
	 * 
	 * <b>NOTE:</b> As this array is indexed from 0 you MUST subtract 1 from
	 * its size to get the maximum step you can refer to in other calls.
	 * 
	 * @return
	 */
	public static int getTotalSteps(){
		return _totalSize;
	}
	
	/**
	 * Returns the resolution of the LIDAR unit currently attached to the platform.
	 * This will be returned as a decimal value (e.g. 0.5 for half-degree res.).
	 * 
	 * @return
	 */
	public static double getResolution(){
		return LIDAR_STEP_SIZE;
	}
	
	/**
	 * Returns the scan radius which the LIDAR map is setup for.
	 * (e.g. 240 for 240 degrees)
	 * 
	 * @return
	 */
	public static int getScanRadius(){
		return LIDAR_TOTAL_RANGE;
	}
	
	/**
	 * Returns the distance recorded by the LIDAR at a specific step.
	 * This will return a -1 if you request a step outside of the array.
	 * 
	 * @param step
	 * @return
	 */
	public static double getDistanceAtStep(int step){
		if(step >= _totalSize){
			log.warn("User requested a distance from the lidar outside the" +
					 " total map range for the lidar! Returning -1!");
			return -1;
		} else {
			return _map[step];
		}
	}
	
	/**
	 * Sets the maximum supported range of the LIDAR in the map.
	 * @param maxRange
	 */
	public static void setMaxRange(int maxRange){
		_maxRange = maxRange;
		log.info("Maximum lidar range set to: " + _maxRange);
	}
	
	/**
	 * Returns the maximum supported range of the LIDAR in the map.
	 * If there has been no maximum range set -1 will be returned.
	 * @return
	 */
	public static int getMaxRange(){
		return _maxRange;
	}
	
	public static int getAngleOfNearestObstacle(){
		//TODO Implement Me!!!
		return 0;
	}
	
	public static int getDistanceOfNearestObstacle(){
		//TODO Implement Me!!!
		return 0;
	}

}
