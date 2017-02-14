package junitTests.gps;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.xml.sax.SAXException;

import robOS2.gps.Waypoint;
import robOS2.gps.WaypointManager;
import robOS2.xml.GPSParser;

public class XMLWaypointManagerTest {
	static Logger log = Logger.getLogger(XMLWaypointManagerTest.class.getName());
	
	@Test
	public void xmlWaypointMangerTest(){
		GPSParser gpsParser = new GPSParser();
		try {
			gpsParser.parse("src/junitTests/gps/XMLTestWaypoints.xml");
		} catch (IOException e) {
			log.fatal("Could not open the test XML file for parsing.");
		} catch (SAXException e) {
			log.fatal("An unexpected error has occured.\n" + e.toString());
		}
		
		Waypoint tstWP1 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #1 Failed.",
				(tstWP1.getName().equals("OAKLAND")) &&
				(tstWP1.getLatitude() == 42.6792200) &&
				(tstWP1.getLongitude() == -83.1954670));
		
		Waypoint tstWP2 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #2 Failed.",
				(tstWP2.getName().equals("QINETIQ")) &&
				(tstWP2.getLatitude() == 42.6794836) &&
				(tstWP2.getLongitude() == -83.1954630));
		
		Waypoint tstWP3 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #3 Failed.",
				(tstWP3.getName().equals("AUVSI")) &&
				(tstWP3.getLatitude() == 42.6794355) &&
				(tstWP3.getLongitude() == -83.1950568));
		
		Waypoint tstWP4 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #4 Failed.",
				(tstWP4.getName().equals("PNI")) &&
				(tstWP4.getLatitude() == 42.6794780) &&
				(tstWP4.getLongitude() == -83.1952400));
	}
}
