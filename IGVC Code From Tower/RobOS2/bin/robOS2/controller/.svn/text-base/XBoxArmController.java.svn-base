package robOS2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import org.apache.log4j.Logger;
import robOS2.hardware.lynxMotion.ArmController;
import com.centralnexus.input.Joystick;
import com.centralnexus.input.JoystickListener;

public class XBoxArmController {

	static Logger log = Logger.getLogger(XBoxArmController.class.getName());
	private static Joystick _js;

	private final static int BASE = 0;
	private final static int SHOULDER = 1;
	private final static int ELBOW = 2;
	private final static int WRIST = 3;
	private final static int GRIPPER = 4;
	
	private static final int TIME_CONSTANT = 5;
	private final static int SCALE_CONST = 200;
	private final static int HOME_POSITION = 1600;
	
	private final static int MIN_POSITION = 800;
	
	private final static int MAX_POSITION = 2400;
	
	private Timer _timer;
	private TimerListener _tListener;
	
	private ArmController _armController;
	
	
	private boolean accelleration = true;
	private final static int TIMER_DELAY = 25; //In milliseconds
	/**
	 *  Acceleration is made to move at 100 max per second.
	 *  So it'll move .getAXIS()*100 PER second
	 */
	
	public XBoxArmController() {
		log.debug("Creating a new XBox Gamepad controller.");
		
		_armController = new ArmController(HOME_POSITION);
		try {
			_js = Joystick.createInstance();
			_js.addJoystickListener(new XBoxArmControllerListener());
			
		} catch (IOException e) {
			log.fatal("Could not find a avaiable controller to attach to.");
		} catch (Exception e) {
			log.fatal("An unexpected error has occured.");
		}

		//100ms delay timer
		_tListener = new TimerListener();
		_timer = new Timer(TIMER_DELAY, _tListener);
		if(accelleration) _timer.start();
		while(true) {
			
		}
				
	}
	
	private class XBoxArmControllerListener implements JoystickListener {

		@Override
		public void joystickAxisChanged(Joystick arg0) {
			log.debug("AXIS CHANGE");
			log.debug("\tY: " + _js.getY());
			log.debug("\tZ: " + _js.getZ());
			log.debug("\tZ: " + _js.getX());
			log.debug("\tZ: " + _js.getV());
			
			if(!accelleration) {
				int basePos = HOME_POSITION + (int)(_js.getX() * SCALE_CONST);
				int shoulderPos = HOME_POSITION + (int)(_js.getY() * SCALE_CONST);
				int elbowPos = HOME_POSITION + (int)(_js.getR() * SCALE_CONST);
				int wristPos = HOME_POSITION + (int)(_js.getZ() * SCALE_CONST);
				
				int baseTime =Math.abs( Math.abs(_armController.getPosition(BASE)) - Math.abs(basePos) ) * TIME_CONSTANT;
				int shoulderTime = Math.abs(Math.abs(_armController.getPosition(SHOULDER)) - Math.abs(shoulderPos)) * TIME_CONSTANT;
				int elbowTime = Math.abs( Math.abs(_armController.getPosition(ELBOW)) - Math.abs(elbowPos)) * TIME_CONSTANT;
				int wristTime = Math.abs(Math.abs(_armController.getPosition(WRIST)) - Math.abs(wristPos)) * TIME_CONSTANT;
				
				
				_armController.setPosition(BASE, basePos, baseTime);
				_armController.setPosition(SHOULDER, shoulderPos, shoulderTime);
				_armController.setPosition(ELBOW, elbowPos, elbowTime);
				_armController.setPosition(WRIST, wristPos, wristTime);
			} else {			
				//this.timerControl();
				//_tListener.actionPerformed(null);
			}
			
		}

		@Override
		public void joystickButtonChanged(Joystick arg0) {
			if(!accelleration) {
				if((_js.getButtons() & Joystick.BUTTON8) > 0) {
					log.debug("Button8 hit (Right trigger)");
					_armController.setPosition(GRIPPER, (_armController.getPosition(GRIPPER) - 100), 0 );
				}
				if((_js.getButtons() & Joystick.BUTTON7) > 0) {
					log.debug("Button7 hit (Left trigger)");
					_armController.setPosition(GRIPPER, (_armController.getPosition(GRIPPER) + 100), 0 );
				}
			}
		}
	}
	
	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int multiplier = 15;
			
			int baseAdd = (int) (_js.getX()*multiplier);
			int shoulderAdd = (int) (_js.getY()*multiplier);
			int elbowAdd = (int) (_js.getR()*multiplier);
 			int wristAdd = (int) (_js.getZ()*multiplier);
 			int gripperAdd = ( (_js.getButtons() & Joystick.BUTTON8) * 1 ) + ( (_js.getButtons() & Joystick.BUTTON7) * -1);
 			
		
 			// Get the new position by adding what we would like to change the arm's postion by
 			// to the old "total"
 			int baseTot = _armController.getPosition(BASE) + baseAdd;
 			int shoulderTot = _armController.getPosition(SHOULDER) + shoulderAdd;
 			int elbowTot = _armController.getPosition(ELBOW) + elbowAdd;
 			int wristTot = _armController.getPosition(WRIST) + wristAdd;
 			int gripperTot = _armController.getPosition(GRIPPER) + gripperAdd;
 			
 			// Perform bounds checking on ALL the parameters
 			if(baseTot > MAX_POSITION){
 				baseTot = MAX_POSITION;
 			} else if(baseTot < MIN_POSITION){
 				baseTot = MIN_POSITION;
 			}
 			
 			if(shoulderTot > MAX_POSITION){
 				shoulderTot = MAX_POSITION;
 			} else if(shoulderTot < MIN_POSITION){
 				shoulderTot = MIN_POSITION;
 			}
 			
 			if(elbowTot > MAX_POSITION){
 				elbowTot = MAX_POSITION;
 			} else if(elbowTot < MIN_POSITION){
 				elbowTot = MIN_POSITION;
 			}
 			
 			if(wristTot > MAX_POSITION){
 				wristTot = MAX_POSITION;
 			} else if(wristTot < MIN_POSITION){
 				wristTot = MIN_POSITION;
 			}
 			
 			if(gripperTot > MAX_POSITION){
 				gripperTot = MAX_POSITION;
 			} else if(gripperTot < MIN_POSITION){
 				gripperTot = MIN_POSITION;
 			}
 			
 			_armController.setPosition(BASE, baseTot, TIMER_DELAY);
 			_armController.setPosition(SHOULDER, shoulderTot, TIMER_DELAY);
 			_armController.setPosition(ELBOW, elbowTot, TIMER_DELAY);
 			_armController.setPosition(WRIST, wristTot, TIMER_DELAY);
			_armController.setPosition(GRIPPER, gripperTot, TIMER_DELAY);
 			
		}
	}
	
	public static void main(String[] args) {
		new XBoxArmController();
	}
}
