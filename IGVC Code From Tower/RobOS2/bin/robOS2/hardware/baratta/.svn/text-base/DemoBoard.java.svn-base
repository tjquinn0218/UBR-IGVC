package robOS2.hardware.baratta;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class DemoBoard implements IUniversalHardwareDevice{
	static Logger log = Logger.getLogger(DemoBoard.class.getName());
	
	private Connection _sc;
	
	public DemoBoard(Connection conn) {
		_sc = conn;
		log.info("Demo Board connected");
		
		_sc.writeData("!@Powered by RobOS2\n");
		log.debug("Connected to the demo board");
	}
	
	public void updateDisplay(String text){
		log.debug("Updaing the display with: " + text);
		_sc.writeData("!@" + text + "\n");
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void driveMotorForward(){
		log.debug("Driving the servo in the forward direction");
		_sc.writeData("!MF\n");
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void driveMotorReverse(){
		log.debug("Driving the servo in the reverse direction.");
		_sc.writeData("!MR\n");
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stopMotor(){
		log.debug("Stopping the servo");
		_sc.writeData("!MS\n");
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
