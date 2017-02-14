package robOS2.hardware.pni.tcm26;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.ICompass;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class TCM26Driver implements IUniversalHardwareDevice, ICompass{
	static Logger log = Logger.getLogger(TCM26Driver.class.getName());
	private Connection _serial;
	private TCM26Listener _listener;
	
	public TCM26Driver(Connection conn) {
		_serial = conn;
		try {
			_listener = new TCM26Listener(_serial.getInputStream());
			
			_serial.attachListener(_listener);
			
			_serial.writeData("go");
			
			while(true){
			log.debug(_listener.getXMagnetometer());
			}
		} catch (Exception e) {
			log.fatal("Could not connect to the PNI Compass.");
		}
	}
	
	public double getXMagnetometer(){
		return _listener.getXMagnetometer();
	}

	@Override
	public double getPitch() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRoll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeading() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean trueNorth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getYMagnetometer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getZMagnetometer() {
		// TODO Auto-generated method stub
		return 0;
	}
}
