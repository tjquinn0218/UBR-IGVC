package robOS2.hardware.hokuyo;

import org.apache.log4j.Logger;

import robOS2.hardware.interfaces.drivers.ILIDAR;
import robOS2.hardware.interfaces.listeners.ILIDARListener;
import robOS2.mapping.lidar.ILIDARMap;
import robOS2.serial.Connection;

public class URG04LX implements ILIDAR{
	private Connection _conn;
	static Logger log = Logger.getLogger(URG04LX.class.getName());
	private ILIDARListener _listener;
	
	/**
	 * Create a new connection to the Hokuyo LIDAR and start it scanning for
	 * obstacles
	 */
	public URG04LX(Connection conn) {
		log.debug("Connecting to the URG-04-LX (Hokuyo)");
		_conn = conn;
		log.info("Connected to the URG-04-LX (Hokuyo)");
		
		_listener = new URG04LXListener(_conn.getInputStream());
		_conn.attachListener(_listener);
		log.info("Listener is attached.");
		
		this.getVendor();
		
		this.startScan(0, 100, 0, 0);
	}

	/**
	 * Returns the maximum range of the obstacle the sensor is capable of
	 * detecting.
	 */
	@Override
	public int getMaxRange() {
		return 4000;
	}

	/**
	 * Returns the angle of the closest obstacle to the sensor
	 */
	@Override
	public double getAngleToNearestObsticle() {
		return 0;
	}

	/**
	 * Returns the distance of the closest obstacle to the sensor
	 */
	@Override
	public int getDistanceToNearestObsticle() {
		return 0;
	}

	/**
	 * Returns the maximum scan radius of the sensor.
	 */
	@Override
	public int getScanRadius() {
		return 240;
	}

	/**
	 * Returns how many datapoint's are in a sensor scan. This is the scan
	 * radius times the sensor resolution
	 */
	@Override
	public int getScanSteps() {
		return 0;
	}

	/**
	 * Returns the map of obstacles detected by the LIDAR
	 */
	@Override
	public ILIDARMap getLIDARMap() {
		return null;
	}
	
	/**
	 * 
	 * @param startAngle
	 * @param endAngle
	 * @param clusterCount
	 * @param numberScans
	 */
	public void startScan(int startAngle, int endAngle, int clusterCount, int numberScans){
		String sAngle = Integer.toString(startAngle);	//String version of start angle
		String eAngle = Integer.toString(endAngle);	//String version of end angle
		String cCount = Integer.toString(clusterCount);	//String version of cluster count
		String nScans = Integer.toString(numberScans);	//String version of number scans
		
		while(sAngle.length() < 4){
			sAngle = "0" + sAngle;
		}
		
		while(eAngle.length() < 4){
			eAngle = "0" + eAngle;
		}
		
		while(cCount.length() < 2){
			cCount = "0" + cCount;
		}
		
		while(nScans.length() < 2){
			nScans = "0" + nScans;
		}
		
		_conn.writeData("MS" + sAngle + eAngle + cCount + "0" + nScans + "\n");
		
		//_conn.writeData("MS0000010000001" + "\n");
	}
	
	/**
	 * Returns other information about the sensor
	 * (e.g. software version, status, etc)
	 * @return
	 */
	public String getSensorInformation(){
		return null;
	}

	/**
	 * Returns the vendor of the sensor
	 */
	@Override
	public String getVendor() {
		_conn.writeData("VV\n");
		return null;
	}

	/**
	 * Returns the version of the manufacturers protocol which the sensor is using
	 */
	@Override
	public String getProtocol() {
		
		return null;
	}
}
