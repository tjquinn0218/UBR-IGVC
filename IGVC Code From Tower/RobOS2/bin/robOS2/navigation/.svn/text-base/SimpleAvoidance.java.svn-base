package robOS2.navigation;

import org.apache.log4j.Logger;

import robOS2.Main;
import robOS2.hardware.interfaces.drivers.IGenericMotor;
import robOS2.mapping.lidar.ILIDARMap;
import robOS2.mapping.lidar.LIDARMap;

/**
 * Simple algorithm which can be used for very simple path planning problems.
 * This may be a good controller to use for application demo's until we get
 * something more robust built and tested.
 * 
 * @author dbaratta
 */
public class SimpleAvoidance implements IPathPlanner, Runnable{
	private static Logger log = Logger.getLogger(SimpleAvoidance.class.getName());
	private boolean _isRunning = false;
	private IGenericMotor _genericMotorDriver = null;
	private int _scanRadius = LIDARMap.getScanRadius();
	private int _angleNearestObstacle = 0;
	private int _distanceNearestObstacle = 0;
	private int _thresholdDistance = 1000;	//Anything beyond this distance is "safe" and we don't worry about it.
											//This distance is defined in mm
	
	/**
	 * Create a new simple obstacle avoider which will make decisions on how to
	 * avoid objects by turning left or right to not run anything over.
	 */
	public SimpleAvoidance() {
		_genericMotorDriver = Main.getActiveMotorDriver();
	}
	
	/**
	 * Looks at the nearest obstacle to the LIDAR
	 */
	public void planPath(){
		//Update the angle to the nearest obstacle
		_angleNearestObstacle = LIDARMap.getAngleOfNearestObstacle();
		//Update the distance to the nearest obstacle
		_distanceNearestObstacle = LIDARMap.getDistanceOfNearestObstacle();
		
		if(_distanceNearestObstacle >= _thresholdDistance){
			//Make robot drive straight
		} else {
			
		}
	}
	
	@Override
	public void run() {
		log.debug("Starting the SimpleAvoidance Path Planner");
		_isRunning = true;
		while(_isRunning){
			this.planPath();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				log.fatal("An unexpected error has occured while attempting to sleep the thread!");
			}
		}
		log.debug("SimpleAvoidance Path Planner Exiting...");
	}
	
	public void stop(){
		_isRunning = false;
	}

	@Override
	public double getForwardVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRotationalVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
