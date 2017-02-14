package robOS2.hardware.interfaces.drivers;

/**
 * Interface which takes in a forward and rotational velocity. This interface
 * is to mark a ground-based vehicle's drive system.
 * 
 * @author dbaratta
 *
 */
public interface IGenericMotor {
	void setForwardVelocity(int velocity);
	
	void setRotationalVelocity(int velocity);
	
	void resetEStop();
	
	int queryLeftFrontEncoder();
	
	int queryLeftRearEncoder();
	
	int queryRightFrontEncoder();
	
	int queryRightRearEncoder();
}
