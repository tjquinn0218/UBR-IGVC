package robOS2.hardware.ubr;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.hardware.interfaces.drivers.IMechWheel;
import robOS2.hardware.interfaces.listeners.IFourMotorListener;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class UBRMotorControllerDirectDrive implements IFourMotorInterface, IUniversalHardwareDevice, IMechWheel{
	private Connection _leftSerialConnection;
	private Connection _rightSerialConnection;
	static Logger log = Logger.getLogger(UBRMotorControllerDirectDrive.class.getName());
	private static final double MECCONST = 0.20923298;
	private static final double STDCONST = 0.074515568;
    private int _velocity = 0;
    private int _rotation = 0;
	
	private static final String LEFT_COM_PORT = "COM4";
	private static final String RIGHT_COM_PORT = "COM3";
	
	public UBRMotorControllerDirectDrive() {
		try {
			_leftSerialConnection = new Connection("Left Roboteq");
				_leftSerialConnection.connectEvenParity(LEFT_COM_PORT, 7, 9600);
			_rightSerialConnection = new Connection("Right Roboteq");
				_rightSerialConnection.connectEvenParity(RIGHT_COM_PORT, 7, 9600);
		} catch (Exception e) {
			// The first connection attempt to the motor controller failed.
			log.error("First connection attempt to the motor controller has failed.");
		}
		
		//Attempt to reset the EStop on the controllers.
		this.resetEStop();
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void updateLeftFront(int speed) {
		log.fatal("NOT IMPLEMENTED");
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void updateLeftRear(int speed) {
		log.fatal("NOT IMPLEMENTED");
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void updateRightFront(int speed) {
		log.fatal("NOT IMPLEMENTED");
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void updateRightRear(int speed) {
		log.fatal("NOT IMPLEMENTED");
	}

	/**
	 * Method to update the forward velocity of the platform. This will update
	 * the speed of all 4 motors while keeping the rotation velocity set to
	 * what it was before this method was called.
	 * 
	 * @param velocity - Forward / Reverse velocity. Pass this in as a signed
	 * integer. Units to be determined.
	 */
	@Override
	public void setForwardVelocity(int velocity) {
		_velocity = velocity;
    	int flSpeed = (int)((-_velocity) - (_rotation * MECCONST));
    	int blSpeed = (int)((-_velocity) - (_rotation * STDCONST));
    	this.leftDirectDrive(flSpeed, blSpeed); 
    	
    	int frSpeed = (int)((_velocity) - (_rotation * MECCONST));
    	int brSpeed = (int)((_velocity) - (_rotation * STDCONST));
    	
    	this.rightDirectDrive(frSpeed, brSpeed); 
	}

	/**
	 * Method to update the rotational velocity of the platform. This will update
	 * the speed of all 4 motors while keeping the forward velocity set to
	 * what it was before this method was called.
	 * 
	 * @param velocity - Left / Right velocity. Pass this in as a signed
	 * integer. Units to be determined.
	 */
	@Override
	public void setRotationalVelocity(int velocity) {
		_rotation = velocity;
    	int flSpeed = (int)((-_velocity) - (_rotation * MECCONST));
    	int blSpeed = (int)((-_velocity) - (_rotation * STDCONST));
    	this.leftDirectDrive(flSpeed, blSpeed); 
    	
    	int frSpeed = (int)((_velocity) - (_rotation * MECCONST));
    	int brSpeed = (int)((_velocity) - (_rotation * STDCONST));
    	
    	this.rightDirectDrive(frSpeed, brSpeed); 
	}

	/**
	 * Sends a text update to the LCD display mounted on the robot. Please
	 * refer to the documentation of the platform for the maximum length
	 * the string can be, as this driver most likely won't be the limiting
	 * factor.
	 * 
	 * @param update - Text update for the display on the platform
	 */
	@Override
	public void updateRobotStatusScreen(String update) {
		log.fatal("NOT IMPLEMENTED");
	}
	
	/**
	 * Not implemented since the remote does not have a display on it
	 */
	@Deprecated
	@Override
	public void updateRemoteStatusScreen(String update) {
		log.error("This Motor Controller does not support updating the remote from the robot.");
	}

	/**
	 * Method to query the count on the left front encoder. If the encoder can
	 * not be read this method will return the minimum value for and integer
	 * --> Integer.MIN_VALUE
	 * 
	 * @return int - Current encoder count since this was last called
	 */
	@Override
	public int queryLeftFrontEncoder() {
		return Integer.MIN_VALUE;
	}

	/**
	 * Method to query the count on the left rear encoder. If the encoder can
	 * not be read this method will return the minimum value for and integer
	 * --> Integer.MIN_VALUE
	 * 
	 * @return int - Current encoder count since this was last called
	 */
	@Override
	public int queryLeftRearEncoder() {
		return Integer.MIN_VALUE;
	}

	/**
	 * Method to query the count on the right front encoder. If the encoder can
	 * not be read this method will return the minimum value for and integer
	 * --> Integer.MIN_VALUE
	 * 
	 * @return int - Current encoder count since this was last called
	 */
	@Override
	public int queryRightFrontEncoder() {
		return Integer.MIN_VALUE;
	}

	/**
	 * Method to query the count on the right rear encoder. If the encoder can
	 * not be read this method will return the minimum value for and integer
	 * --> Integer.MIN_VALUE
	 * 
	 * @return int - Current encoder count since this was last called
	 */
	@Override
	public int queryRightRearEncoder() {
		return Integer.MIN_VALUE;
	}
	
	/**
	 * Send down a raw command to the motor controller. This may be useful
	 * for temporary debug functions that do not warrant a full method in
	 * this driver class.
	 * 
	 * This command is not null-terminated by this driver!
	 * 
	 * @param command - Raw command for the platform
	 */
	public void sendCommand(String command){
		log.fatal("NOT IMPLEMENTED");
	}
	
	/**
	 * Returns the sensor listener thats monitoring replies from the motor
	 * controller.
	 * 
	 * @return
	 */
	public IFourMotorListener getListener(){
		log.fatal("NOT IMPLEMENTED");
		return null;
	}
	
	/**
	 * Send the EStop reset command to both controllers.
	 */
	public void resetEStop(){
		String resetCommand = "%rrrrrr\r";
		_leftSerialConnection.writeData(resetCommand);
		_rightSerialConnection.writeData(resetCommand);
	}
	
	
	private void leftDirectDrive(double front, double back) {
		String result = "";
		if(front >= 0){
			result = result + "!A";
		} else {
			result = result + "!a";
		}
		
		front = Math.abs(front);
		
		if(front < 16){
			result = result + "0";
		}
		
		result = result + Integer.toHexString((int)front);
		
		result = result + '\r';
		
		if(back >= 0){
			result = result + "!B";
		} else {
			result = result + "!b";
		}
		
		back = Math.abs(back);
		
		if(back < 16){
			result = result + "0";
		}
		
		result = result + Integer.toHexString((int)back);
		result = result + '\r';
		System.out.println("Result is (Left): " + result);
		_leftSerialConnection.writeData(result);
	}

	private void rightDirectDrive(double front, double back) {
		String result = "";
		if(front >= 0){
			result = result + "!A";
		} else {
			result = result + "!a";
		}
		
		front = Math.abs(front);
		
		if(front < 16){
			result = result + "0";
		}
		
		result = result + Integer.toHexString((int)front);
		result = result + '\r';
		
		if(back >= 0){
			result = result + "!B";
		} else {
			result = result + "!b";
		}
		
		back = Math.abs(back);
		
		if(back < 16){
			result = result + "0";
		}
		
		result = result + Integer.toHexString((int)back);
		result = result + '\r';
		System.out.println("Result is (Right): " + result);
		_rightSerialConnection.writeData(result);
	}

}
