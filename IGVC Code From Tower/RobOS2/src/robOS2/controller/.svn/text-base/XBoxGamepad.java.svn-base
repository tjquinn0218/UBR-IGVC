package robOS2.controller;

import java.io.IOException;
import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.IFourMotorInterface;
import robOS2.hardware.ubr.UBRMotorControllerDirectDrive;
import com.centralnexus.input.Joystick;
import com.centralnexus.input.JoystickListener;

public class XBoxGamepad {
	static Logger log = Logger.getLogger(XBoxGamepad.class.getName());
	private static Joystick _js;
	private boolean _turboMode = false;
	private IFourMotorInterface _motorController;
	private final static int SCALE_CONST = 45;
	
	/**
	 * Creates a new game-pad interface for controlling a platform. Right now this is
	 * hard-coded in for Big Blue with the direct drive to the RoboTeq controllers.
	 */
	public XBoxGamepad() {
		log.debug("Creating a new XBox Gamepad controller.");
		try {
			_motorController = new UBRMotorControllerDirectDrive();
			
			_js = Joystick.createInstance();
			_js.addJoystickListener(new XBoxGamepadListener());
			while(true){
				
			}
		} catch (IOException e) {
			log.fatal("Could not find a avaiable controller to attach to.");
		} catch (Exception e) {
			log.fatal("An unexpected error has occured.");
		}
	}
	
	private class XBoxGamepadListener implements JoystickListener{

		@Override
		public void joystickAxisChanged(Joystick arg0) {
			log.debug("AXIS CHANGE");
			log.debug("\tY: " + _js.getY());
			log.debug("\tZ: " + _js.getZ());
			
			if(_turboMode){
				_motorController.setForwardVelocity((int)-(_js.getY() * 100));
				_motorController.setRotationalVelocity((int)(_js.getZ() * 100));
			} else {
				_motorController.setForwardVelocity((int)-(_js.getY() * SCALE_CONST));
				_motorController.setRotationalVelocity((int)(_js.getZ() * (SCALE_CONST * 1.5)));	
			}
		}

		/**
		 * Monitors what buttons are pressed on the game-pad
		 */
		@Override
		public void joystickButtonChanged(Joystick arg0) {
			if((_js.getButtons() & Joystick.BUTTON8) > 0){
				_motorController.resetEStop();
				log.debug("Right Trigger Pulled");
			} else {
				log.debug("Right Trigger Released");
			}
			
			if((_js.getButtons() & Joystick.BUTTON7) > 0){
				_turboMode = true;
				log.debug("Turbo Mode Activated");
			} else {
				_turboMode = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new XBoxGamepad();
	}
}
