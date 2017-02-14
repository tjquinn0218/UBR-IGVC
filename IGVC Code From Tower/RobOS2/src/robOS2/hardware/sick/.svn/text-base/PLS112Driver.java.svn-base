package robOS2.hardware.sick;

import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.drivers.ILIDAR;
import robOS2.hardware.interfaces.listeners.ILIDARListener;
import robOS2.hardware.interfaces.marker.IUniversalHardwareDevice;
import robOS2.mapping.lidar.ILIDARMap;
import robOS2.serial.Connection;
import robOS2.utility.SICKHelper;

public class PLS112Driver implements IUniversalHardwareDevice, ILIDAR{
	static Logger log = Logger.getLogger(PLS112Driver.class.getName());
	
	private Connection _conn;
	
	public PLS112Driver() {
		_conn = new Connection("SICK");

		
		try {
			_conn.connectEvenParity("COM15", 8, 9600);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.toSetupMode();
		this.toSetupMode();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {}
		
		this.to56000Baud();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			this.to56000Baud();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		_conn.disconnect();
		try {
			_conn.connectEvenParity("COM15", 8, 57600);
		} catch (Exception e2) {
			log.fatal("Could not connect to the sick");
		}
		
		this.toRequestOnlyMode();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {}
		
		log.debug("in request only mode");
		ILIDARListener listener;
		listener = new PLS112Listener(_conn.getInputStream());
	    _conn.attachListener(listener);
		
	    boolean request = true;
	    int failCount = 0;
	    
		for(;;){
			if(request){
				log.debug("Querying Sick");
				this.query();
				listener.reset();
				request = false;
			} else {
				failCount++;
				if(failCount > 3){
					request = true;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public IUniversalHardwareDevice getDriver(){
		return this;
	}
	
	public void constantBaud() {
		int[] data = {0x02, 0x00, 0x02, 0x00, 0x66, 0x01, 0x9D, 0x4E};
		_conn.writeData(SICKHelper.intToByteArray(data));
	}
	
	public void query() {
		int[] data = {0x02, 0x00, 0x02, 0x00, 0x30, 0x01, 0x31, 0x18};
		_conn.writeData(SICKHelper.intToByteArray(data));
	}
	
	public void to56000Baud() {
		int[] data = {0x02, 0x00, 0x02, 0x00, 0x20, 0x43, 0x53, 0x08};
		_conn.writeData(SICKHelper.intToByteArray(data));
	}
	
	public void toRequestOnlyMode() {
		int[] data = {0x02, 0x00, 0x02, 0x00, 0x20, 0x25, 0x35, 0x08};
		_conn.writeData(SICKHelper.intToByteArray(data));
	}
	
	public void toSetupMode() {
		int[] data = {0x02, 0x00, 0x0A, 0x00, 0x20, 0x00, 0x53, 0x49, 0x43, 0x4B, 0x5F, 0x50, 0x4C, 0x53, 0xCC, 0xFC};
		_conn.writeData(SICKHelper.intToByteArray(data));
	}

	/**
	 * Returns the maximum supported range of the LIDAR.
	 * e.g. 5000 for 5000mm
	 * 
	 * This method returns -1 if there is no max range defined.
	 */
	@Override
	public int getMaxRange() {
		// TODO FIX ME!!!!
		return -1;
	}

	@Override
	public double getAngleToNearestObsticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDistanceToNearestObsticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScanRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScanSteps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILIDARMap getLIDARMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVendor() {
		return "SICK";
	}

	@Override
	public String getProtocol() {
		return "1.0";
	}

}
