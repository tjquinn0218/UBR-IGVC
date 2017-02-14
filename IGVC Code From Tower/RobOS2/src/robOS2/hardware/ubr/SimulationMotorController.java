package robOS2.hardware.ubr;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.IFourMotorInterface;

public class SimulationMotorController implements IFourMotorInterface{
	private static Logger log = Logger.getLogger(SimulationMotorController.class.getName());

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateLeftFront(int speed) {}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateLeftRear(int speed) {}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateRightFront(int speed) {}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateRightRear(int speed) {}

	@Override
	public void setForwardVelocity(int velocity) {
		log.info("Recieved forward velocity of: " + velocity + " m/s");
	}

	@Override
	public void setRotationalVelocity(int velocity) {
		log.info("Recieved roataional velocity of: " + velocity + " m/s");
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateRobotStatusScreen(String update) {}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void updateRemoteStatusScreen(String update) {}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public int queryLeftFrontEncoder() {
		return 0;
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public int queryLeftRearEncoder() {
		return 0;
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public int queryRightFrontEncoder() {
		return 0;
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public int queryRightRearEncoder() {
		return 0;
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Deprecated
	@Override
	public void resetEStop() {}
}
