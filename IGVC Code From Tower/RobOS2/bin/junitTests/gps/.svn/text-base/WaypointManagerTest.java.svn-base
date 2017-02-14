/**
 * 
 */
package junitTests.gps;

import static org.junit.Assert.*;
import org.junit.Test;
import robOS2.gps.Waypoint;
import robOS2.gps.WaypointManager;

/**
 * @author dbaratta
 *
 */
public class WaypointManagerTest {

	@Test
	public void waypointManagerTest(){
		WaypointManager.addWaypoint("TEST_1", -78.38728773, -73.234782983);
		
		Waypoint waypoint2 = new Waypoint("TEST_2", -69.43782383, -69.438923977);
		WaypointManager.addExistingWaypoint(waypoint2);
		
		Waypoint waypoint3 = new Waypoint(-44.243378293, -46.3432788423);
		WaypointManager.addExistingWaypoint(waypoint3);
		
		WaypointManager.addWaypoint("TEST_4", 72.32198923, 77.234788293);
		
		Waypoint tstWP1 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #1 Failed.",
				(tstWP1.getName().equals("TEST_1")) &&
				(tstWP1.getLatitude() == -78.38728773) &&
				(tstWP1.getLongitude() == -73.234782983));
		
		Waypoint tstWP2 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #2 Failed.",
				(tstWP2.getName().equals("TEST_2")) &&
				(tstWP2.getLatitude() == -69.43782383) &&
				(tstWP2.getLongitude() == -69.438923977));
		
		Waypoint tstWP3 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #3 Failed.",
				(tstWP3.getName().equals("NO_NAME_PROVIDED")) &&
				(tstWP3.getLatitude() == -44.243378293) &&
				(tstWP3.getLongitude() == -46.3432788423));
		
		Waypoint tstWP4 = WaypointManager.popNextWaypoint();
		assertTrue("Waypoint #4 Failed.",
				(tstWP4.getName().equals("TEST_4")) &&
				(tstWP4.getLatitude() == 72.32198923) &&
				(tstWP4.getLongitude() == 77.234788293));
	}

}
