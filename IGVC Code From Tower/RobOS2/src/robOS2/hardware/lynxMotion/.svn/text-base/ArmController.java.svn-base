package robOS2.hardware.lynxMotion;

import org.apache.log4j.Logger;

import robOS2.controller.XBoxArmController;
import robOS2.serial.Connection;


public class ArmController {
	
	static Logger log = Logger.getLogger(XBoxArmController.class.getName());
	/**
	 * Array for channel positions
	 */
	private int _channelPos[];
	/**
	 * Number of channels
	 */
	private static final int CHANNELS = 5;
	/**
	 * Com port data
	 */
	private Connection _comPort;
	private static final String COM_PORT = "COM7";
	private static final int BAUD_RATE = 115200;
	private static final int DATA_BITS = 8; //?
	
	public ArmController(int homePosition) {
		_comPort = new Connection("ArmCom");
		try {
			_comPort.connectNoParity(COM_PORT, DATA_BITS, BAUD_RATE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_channelPos = new int[CHANNELS];
		for(int i = 0; i < CHANNELS; i++) {
			_channelPos[i] = homePosition;
			this.sendPosition(i, 1000);
		}

	}
	
	public boolean setPosition(int channel, int position, int time) {
		if(channel < CHANNELS && _channelPos[channel] != position) {
			//int time = Math.abs(_channelPos[channel] - position) * TIME_CONSTANT;
			_channelPos[channel] = position;
			this.sendPosition(channel, time);
			return true;
		}
		return false;
	}
	public int getPosition(int channel) {
		if(channel < CHANNELS) {
			return _channelPos[channel];
		}
		return 1600; //just to be safe
	}
	
	private void sendPosition(int channel, int time) {
		//send to com port
		String command = "#" + channel + " P" + _channelPos[channel] + " T" + time + "\r";
		_comPort.writeData(command);
		
		log.debug("Sent command: " + command + "   to the com port.");
	}
}
 