package robOS2.gps;

import java.util.LinkedList;
import org.apache.log4j.Logger;

/**
 * Maintains a listing of waypoint's which are still left to "visit".
 * This is implemented as a linked list and provides most of the standard
 * functions that you would expect.
 * 
 * @author dbaratta
 */
public class WaypointManager {
	static Logger log = Logger.getLogger(WaypointManager.class.getName());
	private static LinkedList<Waypoint> _waypoints = new LinkedList<Waypoint>();
	
	/**
	 * Creates & adds a waypoint to the list to be visited.
	 * 
	 * @param name - Name of the waypoint (e.g. TARDEC)
	 * @param latitude - Latitude of the waypoint
	 * @param longitude  - Longitude of the waypoint
	 */
	public static void addWaypoint(String name, double latitude, double longitude){
		_waypoints.add(new Waypoint(name, latitude, longitude));
		
		log.info("New waypoint added to the Waypoint Manager.");
	}
	
	/**
	 * Adds a pre-existing waypoint to the list of waypoint's to be visited.
	 * 
	 * @param wpt
	 */
	public static void addExistingWaypoint(Waypoint wpt){
		_waypoints.add(wpt);
		
		log.info("Waypoint " + wpt.getName() + " added to the queue.");
	}
	
	/**
	 * Returns the next waypoint that we need to visit. This also removes the
	 * waypoint from the queue to be visited.
	 * 
	 * @return
	 */
	public static Waypoint popNextWaypoint(){
		return _waypoints.pop();
	}
	
	/**
	 * Returns the next waypoint that we need to visit. However, this leaves
	 * the waypoint on the queue to be visited.
	 * 
	 * @return
	 */
	public static Waypoint peekNextWaypoint(){
		return _waypoints.peek();
	}
	
	/**
	 * Removes ALL waypoint's from the queue to be visited. NOTE: If you have
	 * another class that has already polled and cached a waypoint this will
	 * NOT remove that waypoint from your class.
	 */
	public static void clearWaypoints(){
		_waypoints.clear();
	}
	
	/**
	 * Returns the entire list of waypoints as a linked list
	 * @return
	 */
	public static LinkedList<Waypoint> getList(){
		return _waypoints;
	}
}
