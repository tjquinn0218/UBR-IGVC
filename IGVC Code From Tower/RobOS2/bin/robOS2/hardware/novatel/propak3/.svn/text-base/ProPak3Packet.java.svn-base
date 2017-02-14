package robOS2.hardware.novatel.propak3;

import org.apache.log4j.Logger;

public class ProPak3Packet {
	static Logger log = Logger.getLogger(ProPak3Packet.class.getName());
	
	//Location Variables
	private static double _lon;
	private static double _lonSig;
	private static double _lat;
	private static double _latSig;
	private static double _hgt;
	private static double _hgtSig;
	private static int _satTracked;
	private static int _satUsed;
	
	//Velocity Variables
	private static double _dx;
	private static double _dy;
	private static double _dz;
	
	public ProPak3Packet() {
		log.info("ProPak3 Data Paket starting...");
	}
	
	public void setLon(double _lon) {
		log.debug("\t-->Setting Longitude");
		ProPak3Packet._lon = _lon;
	}
	
	public static double getLon() {
		return _lon;
	}
	
	public void setLonSig(double _lonSig) {
		log.debug("\t-->Setting Longitude Signal");
		ProPak3Packet._lonSig = _lonSig;
	}
	
	public static double getLonSig() {
		return _lonSig;
	}
	
	public void setLat(double _lat) {
		log.debug("\t-->Setting Latitude");
		ProPak3Packet._lat = _lat;
	}
	
	public static double getLat() {
		return _lat;
	}
	
	public void setLatSig(double _latSig) {
		log.debug("\t-->Setting Latitude Signal");
		ProPak3Packet._latSig = _latSig;
	}
	
	public static double getLatSig() {
		return _latSig;
	}
	
	public void setHgt(double _hgt) {
		log.debug("\t-->Setting Height");
		ProPak3Packet._hgt = _hgt;
	}
	
	public static double getHgt() {
		return _hgt;
	}
	
	public void setHgtSig(double _hgtSig) {
		log.debug("\t-->Setting Height Signal");
		ProPak3Packet._hgtSig = _hgtSig;
	}
	
	public static double getHgtSig() {
		return _hgtSig;
	}
	
	public void setSatTracked(int _satTracked) {
		log.debug("\t-->Setting Sat Tracked");
		ProPak3Packet._satTracked = _satTracked;
	}
	
	public static int getSatTracked() {
		return _satTracked;
	}
	
	public void setSatUsed(int _satUsed) {
		log.debug("\t-->Setting Sat Used");
		ProPak3Packet._satUsed = _satUsed;
	}
	
	public static int getSatUsed() {
		return _satUsed;
	}

	public void setDx(double _dx) {
		log.debug("\t-->Setting dx");
		ProPak3Packet._dx = _dx;
	}

	public static double getDx() {
		return _dx;
	}

	public void setDy(double _dy) {
		log.debug("\t-->Setting dy");
		ProPak3Packet._dy = _dy;
	}

	public static double getDy() {
		return _dy;
	}

	public void setDz(double _dz) {
		log.debug("\t-->Setting dz");
		ProPak3Packet._dz = _dz;
	}

	public static double getDz() {
		return _dz;
	}
	
	@Override
	public String toString() {
		return "-->USE toStringStatic() METHOD TO OBTAIN CURRENT DATA FROM GPS.";
	}
	
	public static String toStringStatic() {
		//Display a printout of all current data
		String output = "\nCurrent GPS Data:\n";
		output = output + "\tLatitude:\t" + _lat + "\t\tLatitude Signal:\t" + _latSig + "\n";
		output = output + "\tLongitude:\t" + _lon + "\t\tLongitude Signal:\t" + _lonSig + "\n";
		output = output + "\tHeight:\t\t" + _hgt + "\t\tHeight Signal:\t\t" + _hgtSig + "\n";
		output = output + "\t\tDirection" + "\t\tVelocity(m/s)\n";
		output = output + "\t\t\tx" + "\t\t\t" + _dx + "\n";
		output = output + "\t\t\ty" + "\t\t\t" + _dy + "\n";
		output = output + "\t\t\tz" + "\t\t\t" + _dz + "\n\n\n";
		return output;
	}
}
