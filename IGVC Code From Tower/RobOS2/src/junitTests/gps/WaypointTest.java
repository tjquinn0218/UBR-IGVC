/**
 * Unit Tests for the GPS module of RobOS2
 */
package junitTests.gps;

import static org.junit.Assert.*;
import org.junit.Test;
import robOS2.gps.Waypoint;

/**
 * Waypoint JUnit Test for RobOS2. This test will create a new waypoint using
 * all 3 of the constructors for a waypoint and verify that all attributes
 * of the waypoint were set correctly.
 * 
 * @author dbaratta
 */
public class WaypointTest {
	private String _name = "TEST POINT";
	private double _latitude = -76.3492881;
	private double _longitude = -75.1988910203;
	
	@Test
	public void defaultConstructorTest(){
		Waypoint waypoint = new Waypoint();
		waypoint.setName(_name);
		waypoint.setLatitude(_latitude);
		waypoint.setLongitude(_longitude);
		
		assertTrue("Waypoint name was not set correctly.",
				(_name.equals(waypoint.getName())));
		assertTrue("Waypoint latitude was not set correctly.",
				(_latitude == waypoint.getLatitude()));
		assertTrue("Waypoint longitude was not set correctly.",
				(_longitude == waypoint.getLongitude()));
	}
	
	@Test
	public void latLongConstructor(){
		Waypoint waypoint = new Waypoint(_latitude, _longitude);
		
		assertTrue("Waypoint name was not set correctly.",
				(waypoint.getName().equals("NO_NAME_PROVIDED")));
		assertTrue("Waypoint latitude was not set correctly.",
				(_latitude == waypoint.getLatitude()));
		assertTrue("Waypoint longitude was not set correctly.",
				(_longitude == waypoint.getLongitude()));
	}
	
	@Test
	public void nameLatLongConstructor(){
		Waypoint waypoint = new Waypoint(_name, _latitude, _longitude);
		
		assertTrue("Waypoint name was not set correctly.",
				(_name.equals(waypoint.getName())));
		assertTrue("Waypoint latitude was not set correctly.",
				(_latitude == waypoint.getLatitude()));
		assertTrue("Waypoint longitude was not set correctly.",
				(_longitude == waypoint.getLongitude()));
	}

}
