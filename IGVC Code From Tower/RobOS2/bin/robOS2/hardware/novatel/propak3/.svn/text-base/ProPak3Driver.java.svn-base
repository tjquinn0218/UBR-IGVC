package robOS2.hardware.novatel.propak3;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.IGPS;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.serial.Connection;

public class ProPak3Driver implements IUniversalHardwareDevice, IGPS{
	static Logger log = Logger.getLogger(ProPak3Driver.class.getName());
	private Connection _serial;
	private ProPak3Listener _listener;
	
	public ProPak3Driver(Connection conn) {
		_serial = conn;
		//_outStream = new PrintStream(_serial.getOutputStream());
		try{
			_listener = new ProPak3Listener(_serial.getInputStream());
			_serial.attachListener(_listener);
			
			log.debug("-->NovAtel GPS Starting...");

			_serial.printLnData("unlogall");
			wait(10);
			_serial.printLnData("log bestpos ontime 0.2\r");
	    	wait(10);
	    	_serial.printLnData("log bestvel ontime 0.2 0.1\r");
	    	wait(10);
			
			log.debug("-->NovAtel GPS Started...");
		} catch (Exception e){
			
		}
	}

	@Override
	public double getLatitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLongitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAltitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfSatsConnected() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEstimatedError() {
		// TODO Auto-generated method stub
		return 0;
	}

}
