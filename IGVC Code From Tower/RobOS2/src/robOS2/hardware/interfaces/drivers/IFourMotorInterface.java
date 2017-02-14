package robOS2.hardware.interfaces.drivers;

public interface IFourMotorInterface {
	
	void updateLeftFront(int speed);
	
	void updateLeftRear(int speed);
	
	void updateRightFront(int speed);
	
	void updateRightRear(int speed);
	
	void setForwardVelocity(int velocity);
	
	void setRotationalVelocity(int velocity);
	
	void updateRobotStatusScreen(String update);
	
	void updateRemoteStatusScreen(String update);
	
	int queryLeftFrontEncoder();
	
	int queryLeftRearEncoder();
	
	int queryRightFrontEncoder();
	
	int queryRightRearEncoder();
	
	void resetEStop();

}
