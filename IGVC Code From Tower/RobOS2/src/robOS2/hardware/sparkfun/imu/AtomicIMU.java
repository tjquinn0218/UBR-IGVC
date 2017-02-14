package robOS2.hardware.sparkfun.imu;

import gnu.io.SerialPortEventListener;
import robOS2.serial.Connection;
import robOS2.serial.ConnectionManager;

public class AtomicIMU {
	private Connection _conn;
	private SerialPortEventListener _listener;
	
	public AtomicIMU() {
		_conn = ConnectionManager.openConnection("IMU");
		this.startUp();
		
		_listener = new AtomicIMUListener();
		_conn.attachListener(_listener);
	}
	
	private void startUp(){
		if (_conn != null){
			//Setting accelerometers to 1.5g sensitivity
			_conn.writeData("%");
			
			//Setting sampling rate to 50hz
			_conn.writeData(")");
			
			//Starting data transfer
			_conn.writeData("#");
		}
	}
	
	public void stop(){
		_conn.writeData(" ");
	}
}
