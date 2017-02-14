package robOS2.hardware.ubr;

import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.hardware.interfaces.drivers.IGenericMotor;
import robOS2.hardware.interfaces.drivers.IMechWheel;
import robOS2.hardware.interfaces.listeners.IFourMotorListener;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class UBRMotorController implements IFourMotorInterface, IUniversalHardwareDevice, IGenericMotor, IMechWheel{
	private Connection _serialConnection;
	static Logger log = Logger.getLogger(UBRMotorController.class.getName());
	private IFourMotorListener _listener;
	
	public UBRMotorController(Connection conn) {
		_serialConnection = conn;
		try {
			_listener = new UBRMotorControllerListener(_serialConnection.getInputStream());
			_serialConnection.attachListener(_listener);
		} catch (Exception e) {
			// The first connection attempt to the motor controller failed.
			// We are going to try waiting a half second (500 miiliseconds) and then
			// going to attempt a re-connect.
			log.error("First connection attempt to the motor controller has failed." +
					  " A reconnect will be attempted in a half a second.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				log.fatal("Thread can't sleep. Motor controller reconnect probably won't work.");
			}
//			_serialConnection = new Connection("Motor Driver");
			try {
//				_serialConnection.connectEvenParity(port, 7, 57600);
			} catch (Exception e1) {
				log.fatal("Can not connect to the motor controller!");
			}
		}
	}

	/**
	 * Method to update the speed of the left front motor ONLY!
	 * The synthax of the motor controller is:
	 * !M1<speed> for forward speed
	 * !m1<speed> for reverse speed
	 * 
	 * @param speed - Signed int for the desired speed of the motor. This is a
	 * value between 100 and -100.
	 */
	@Override
	public void updateLeftFront(int speed) {
		String message = "!";
		if(speed >= 0){
			// Check to make sure our speed isn't more than 100
			if (speed > 100){
				log.warn("Front Left Motor wanted a speed greator than 100. Speed was set to 100");
				speed = 100;
			}
			message = message + "M1" + speed + "\r";
		} else {
			// Check to make sure our speed is within our range.
			if (speed < -100){
				log.warn("Front Left Motor wanted a speed less than -100. Speed was set to -100");
				speed = -100;
			}
			speed = Math.abs(speed);
			message = message + "m1" + speed + "\r";
			log.debug("Sending " + message);
			_serialConnection.writeData(message);
		}
	}

	/**
	 * Method to update the speed of the left rear motor ONLY!
	 * The synthax of the motor controller is:
	 * !M2<speed> for forward speed
	 * !m2<speed> for reverse speed
	 * 
	 * @param speed - Signed int for the desired speed of the motor. This is a
	 * value between 100 and -100.
	 */
	@Override
	public void updateLeftRear(int speed) {
		String message = "!";
		if(speed >= 0){
			// Check to make sure our speed isn't more than 100
			if (speed > 100){
				log.warn("Left Rear Motor wanted a speed greator than 100. Speed was set to 100");
				speed = 100;
			}
			message = message + "M2" + speed + "\r";
		} else {
			// Check to make sure our speed is within our range.
			if (speed < -100){
				log.warn("Left Rear Motor wanted a speed less than -100. Speed was set to -100");
				speed = -100;
			}
			speed = Math.abs(speed);
			message = message + "m2" + speed + "\r";
			log.debug("Sending " + message);
			_serialConnection.writeData(message);
		}	
	}

	/**
	 * Method to update the speed of the right front motor ONLY!
	 * The synthax of the motor controller is:
	 * !M3<speed> for forward speed
	 * !m3<speed> for reverse speed
	 * 
	 * @param speed - Signed int for the desired speed of the motor. This is a
	 * value between 100 and -100.
	 */
	@Override
	public void updateRightFront(int speed) {
		String message = "!";
		if(speed >= 0){
			// Check to make sure our speed isn't more than 100
			if (speed > 100){
				log.warn("Front Right Motor wanted a speed greator than 100. Speed was set to 100");
				speed = 100;
			}
			message = message + "M3" + speed + "\r";
		} else {
			// Check to make sure our speed is within our range.
			if (speed < -100){
				log.warn("Front Right Motor wanted a speed less than -100. Speed was set to -100");
				speed = -100;
			}
			speed = Math.abs(speed);
			message = message + "m3" + speed + "\r";
			log.debug("Sending " + message);
			_serialConnection.writeData(message);
		}
	}

	/**
	 * Method to update the speed of the right rear motor ONLY!
	 * The synthax of the motor controller is:
	 * !M4<speed> for forward speed
	 * !m4<speed> for reverse speed
	 * 
	 * @param speed - Signed int for the desired speed of the motor. This is a
	 * value between 100 and -100.
	 */
	@Override
	public void updateRightRear(int speed) {
		String message = "!";
		if(speed >= 0){
			// Check to make sure our speed isn't more than 100
			if (speed > 100){
				log.warn("Right Rear Motor wanted a speed greator than 100. Speed was set to 100");
				speed = 100;
			}
			message = message + "M4" + speed + "\r";
		} else {
			// Check to make sure our speed is within our range.
			if (speed < -100){
				log.warn("Right Rear Motor wanted a speed less than -100. Speed was set to -100");
				speed = -100;
			}
			speed = Math.abs(speed);
			message = message + "m4" + speed + "\r";
			log.debug("Sending " + message);
			_serialConnection.writeData(message);
		}
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
		// TODO Ask Chris what command I need to send for velocity.
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
		// TODO Ask Chris what command I need to send for rotational velocity.
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
		log.debug("Sending: " + "!@" + update + "\r");
		_serialConnection.writeData("!@" + update + "\r");
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
		_serialConnection.writeData(command);
	}
	
	/**
	 * Returns the sensor listener thats monitoring replies from the motor
	 * controller.
	 * 
	 * @return
	 */
	public IFourMotorListener getListener(){
		return _listener;
	}

	@Override
	public void resetEStop() {
		// TODO Auto-generated method stub
		
	}

}
