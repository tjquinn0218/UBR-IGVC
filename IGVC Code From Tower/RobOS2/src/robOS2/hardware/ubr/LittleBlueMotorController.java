package robOS2.hardware.ubr;

import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.hardware.interfaces.drivers.IMechWheel;
import robOS2.hardware.interfaces.listeners.IFourMotorListener;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class LittleBlueMotorController implements IFourMotorInterface, IUniversalHardwareDevice, IMechWheel{
	private Connection _serialConnection;
	static Logger log = Logger.getLogger(LittleBlueMotorController.class.getName());
	private IFourMotorListener _listener;
	private int _fwdVelocity = 0;
	private int _rotVelocity = 0;
	
	public LittleBlueMotorController(Connection conn) {
		_serialConnection = conn;
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
		_fwdVelocity = velocity;
		
		String message = "!";
		
		if (_fwdVelocity >= 0){
			message = message + "V";
		} else {
			message = message + "v";
		}
		
		String tempVel = Integer.toString(Math.abs(velocity));
		if(tempVel.length() == 1){
			tempVel = "00" + tempVel;
		} else if(tempVel.length() == 2){
			tempVel = "0" + tempVel;
		}
		
		message = message + tempVel;
		
		if (_rotVelocity >= 0){
			message = message + "R";
		} else {
			message = message + "r";
		}
		
		String tempRot = Integer.toString(Math.abs(_rotVelocity));
		if(tempRot.length() == 1){
			tempRot = "00" + tempRot;
		} else if(tempRot.length() == 2){
			tempRot = "0" + tempRot;
		}
		
		message = message + tempRot;
		
		message = message + "\n";
		
		log.debug("WRITING: " + message);
		_serialConnection.writeData(message);
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
		_rotVelocity = velocity;
		
		String message = "!";
		
		if (_fwdVelocity >= 0){
			message = message + "V";
		} else {
			message = message + "v";
		}
		
		String tempVel = Integer.toString(Math.abs(_fwdVelocity));
		if(tempVel.length() == 1){
			tempVel = "00" + tempVel;
		} else if(tempVel.length() == 2){
			tempVel = "0" + tempVel;
		}
		
		message = message + tempVel;
		
		if (_rotVelocity >= 0){
			message = message + "R";
		} else {
			message = message + "r";
		}
		
		String tempRot = Integer.toString(Math.abs(_rotVelocity));
		if(tempRot.length() == 1){
			tempRot = "00" + tempRot;
		} else if(tempRot.length() == 2){
			tempRot = "0" + tempRot;
		}
		
		message = message + tempRot;
		
		message = message + "\n";
		
		_serialConnection.writeData(message);
	}
	
	public void updateVelocities(int velocity, int rot){
		_fwdVelocity = velocity;
		_rotVelocity = rot;
		
		String message = "!";
		
		if (_fwdVelocity >= 0){
			message = message + "V";
		} else {
			message = message + "v";
		}
		
		int absVelocity = Math.abs(velocity);
		
		if(absVelocity < 10){
			message = message + "00" + absVelocity;
		} else if (absVelocity < 100) {
			message = message + "0" + absVelocity;
		} else {
			message = message + absVelocity;
		}
				
		if (_rotVelocity >= 0){
			message = message + "R";
		} else {
			message = message + "r";
		}
		
		
		absVelocity = Math.abs(_rotVelocity);
		if(absVelocity < 10){
			message = message + "00" + absVelocity;
		} else if (absVelocity < 100) {
			message = message + "0" + absVelocity;
		} else {
			message = message + absVelocity;
		}
		
		message = message + "\n";
		
		_serialConnection.writeData(message);
	}

	/**
	 * Not implemented since the robot does not have a display on it
	 */
	@Deprecated
	@Override
	public void updateRobotStatusScreen(String update) {
		log.error("This robot does not support updating the remote from the robot.");
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
