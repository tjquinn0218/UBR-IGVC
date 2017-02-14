package robOS2.hardware.simulation;

import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.simulator.Engine;

/**
 * Simple motor driver to be used during simulation runs in RobOS2
 * 
 * @author <a href = "mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public class SimulationController implements IFourMotorInterface{
	private static Logger log = Logger.getLogger(SimulationController.class.getName());
	private Engine _simEngine;
	private int _velocity = 0;;
	private int _rotationalVelocity = 0;
	
	public SimulationController() {
		
	}
	
	
	/**
	 * 
	 */
	@Override
	public void updateLeftFront(int speed) {
		log.info("Left Front Motor Speed Set To:\t" + speed);
	}

	/**
	 * 
	 */
	@Override
	public void updateLeftRear(int speed) {
		log.info("Left Rear Motor Speed Set To:\t" + speed);
	}

	/**
	 * 
	 */
	@Override
	public void updateRightFront(int speed) {
		log.info("Right Front Motor Speed Set To:\t" + speed);
	}

	/**
	 * 
	 */
	@Override
	public void updateRightRear(int speed) {
		log.info("Right Rear Motor Speed Set To:\t" + speed);
	}

	/**
	 * Updates the current foward velocity of the platform in the simulation engine
	 */
	@Override
	public void setForwardVelocity(int velocity) {
		_velocity = velocity;
		_simEngine.setVelocity(_velocity);
	}

	/**
	 * Updates the current rotational velocity of the platform in the simulation engine
	 */
	@Override
	public void setRotationalVelocity(int velocity) {
		_rotationalVelocity = velocity;
		_simEngine.setRotationalVelocity(_rotationalVelocity);
	}

	/**
	 * 
	 */
	@Override
	public void updateRobotStatusScreen(String update) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public void updateRemoteStatusScreen(String update) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public int queryLeftFrontEncoder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public int queryLeftRearEncoder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public int queryRightFrontEncoder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public int queryRightRearEncoder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public void resetEStop() {
		// TODO Auto-generated method stub
		
	}

}
