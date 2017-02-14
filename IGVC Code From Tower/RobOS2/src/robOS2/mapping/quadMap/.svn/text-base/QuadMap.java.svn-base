package robOS2.mapping.quadMap;

import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.lang.Math;

/**
 * Detects if supplied coordinates are with in a specific quadrant then divides
 * quadrant into small quadrants and performs test again repeats to a specified
 * level locations given as gps coordinates MUST run setMapSize first!
 * 
 * @author Sean Bicknell - seanbick@buffalo.edu
 * @version %I% %G%
 */
public class QuadMap implements Runnable{
	private int _level = 0;
	private int _maxLvl = 2;// max number of levels deepest division is maxLvl
	private double _maxInterval = 0.2;// defines the interval by which the x
									  // value is incremented for line to
									  // points
	@SuppressWarnings("unused")
	private double _mapSizeX = 0.0;
	@SuppressWarnings("unused")
	private double _mapSizeY = 0.0;
	private boolean _isRunning = false;
	static Logger log = Logger.getLogger(QuadMap.class.getName());

	private LinkedList<Quadrant> _children = new LinkedList<Quadrant>();// maintains list
																// of all nodes
	private Map _map;
	private Thread _thread = new Thread(this, "QuadMap");

	/*
	public QuadMap() {

		setMapSize(42.6794836, -83.1950433, 42.6790546, -83.1954670);

		try {
			File file = new File(
					"C:\\Users\\Owner\\Desktop\\software\\RobOS2\\src\\gps_waypoints.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element "
					+ doc.getDocumentElement().getNodeName());
			NodeList nodeLst = doc.getElementsByTagName("WAYPOINT");

			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					Element fstElmnt = (Element) fstNode;
					NodeList fstNmElmntLst = fstElmnt
							.getElementsByTagName("LATITUDE");
					Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
					NodeList fstNm = fstNmElmnt.getChildNodes();
					_x = Double.parseDouble(((Node) fstNm.item(0))
							.getNodeValue());
					System.out.println(_x);

					NodeList lstNmElmntLst = fstElmnt
							.getElementsByTagName("LONGITUDE");
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					_y = Double.parseDouble(((Node) lstNm.item(0))
							.getNodeValue());
					System.out.println(_y);

					quadCheck(_x, _y);
				}// end if

			}// end for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end QuadMap
	*/
	
	public QuadMap(double ULeftLat, double ULeftLong, double LRLat, double LRLong) {
		_map = new Map(ULeftLat, ULeftLong, LRLat, LRLong);
		this.setMapSize(ULeftLat, ULeftLong, LRLat, LRLong);
	}

	/**
	 * Check to see which quad coords are in, instantiates new copy of
	 * Quadrant() class and assigns it xy coordinates for location of its center
	 * as well as assigning a level.
	 * 
	 * @param x - x coordinate of the point to be inserted
	 * @param y - y coordinate of the point to be inserted
	 */
	public void quadCheck(double x, double y) {
		if (_level == 0) {
			if (x > ((_map.getLRLon() - _map.getULLon()) / 2) + _map.getULLon()
					&& y < ((_map.getULLat() - _map.getLRLat()) / 2)
							+ _map.getLRLat())// checks if in Bottom Right Quad
			{
				Quadrant BRQuad0 = new Quadrant(_map.getLRLon()
						- ((_map.getLRLon() - _map.getULLon()) / 4),
						((_map.getULLat() - _map.getLRLat()) / 4)
								+ _map.getLRLat(), _level);
				log.debug("Bottom Right");
				log.debug("Bottom Right X " + BRQuad0.getX());
				log.debug("Bottom Right Y " + BRQuad0.getY());
				log.debug("Bottom Right Level " + BRQuad0.getDiv());

				_level++;
				addChild(BRQuad0, x, y);
			}// end if
			if (x < ((_map.getLRLon() - _map.getULLon()) / 2) + _map.getULLon()
					&& y < ((_map.getULLat() - _map.getLRLat()) / 2)
							+ _map.getLRLat())// checks if in Bottom Left Quad
			{
				Quadrant BLQuad0 = new Quadrant(_map.getULLon()
						+ ((_map.getLRLon() - _map.getULLon()) / 4),
						((_map.getULLat() - _map.getLRLat()) / 4)
								+ _map.getLRLat(), _level);
				log.debug("Bottom Left");
				/*
				 * System.out.println("Bottom Left X " + BLQuad0.getX());
				 * System.out.println("Bottom Left Y " + BLQuad0.getY());
				 */
				log.debug("Bottom Left Level " + BLQuad0.getDiv());

				_level++;
				addChild(BLQuad0, x, y);
			}// end if
			if (x > ((_map.getLRLon() - _map.getULLon()) / 2) + _map.getULLon()
					&& y > ((_map.getULLat() - _map.getLRLat()) / 2)
							+ _map.getLRLat())// checks if in Upper Right Quad
			{
				Quadrant URQuad0 = new Quadrant(_map.getLRLon()
						- ((_map.getLRLon() - _map.getULLon()) / 4),
						_map.getULLat()
								- ((_map.getULLat() - _map.getLRLat()) / 4),
						_level);
				log.debug("Upper Right");
				/*
				 * System.out.println("Upper Right X " + URQuad0.getX());
				 * System.out.println("Upper Right Y " + URQuad0.getY());
				 */
				log.debug("Upper Right Level " + URQuad0.getDiv());

				_level++;
				addChild(URQuad0, x, y);
			}
			if (x < ((_map.getLRLon() - _map.getULLon()) / 2) + _map.getULLon()
					&& y > ((_map.getULLat() - _map.getLRLat()) / 2)
							+ _map.getLRLat())// check if in Upper Left Quad
			{
				Quadrant ULQuad0 = new Quadrant(_map.getULLon()
						+ ((_map.getLRLon() - _map.getULLon()) / 4),
						_map.getULLat()
								- ((_map.getULLat() - _map.getLRLat()) / 4),
						_level);
				log.debug("Upper Left");
				/*
				 * System.out.println("Upper Left X " + ULQuad0.getX());
				 * System.out.println("Upper Left Y " + ULQuad0.getY());
				 * System.out.println("Upper Left Level " + ULQuad0.getDiv());
				 */
				_level++;
				addChild(ULQuad0, x, y);
			} // end ifs
		}// end if
	}// end quadCheck()

	/**
	 * Adds child node to previous node based on location of x , y coords in
	 * relation to previous node.
	 * 
	 * 
	 * @param quad - Quadrant object from the checkQuad method
	 * @param x - X coordinate of point - passed from checkQuad method
	 * @param y - Y coordinate of point - passed from checkQuad method
	 */

	public void addChild(Quadrant quad, double x, double y) {
		double n = 0.0;
		double sizeX = 0.0;
		double sizeY = 0.0;
		n = (double) quad.getDiv() + 1;
		sizeX = (_map.getMapX() / (Math.pow(2.0, n)) / 2);// determines the
															// distance from the
															// center of the
															// quad to the edge
															// This width is
															// split in half due
															// to half the
															// values being neg.
		sizeY = (_map.getMapY() / (Math.pow(2.0, n)) / 2);// determines the
															// distance from the
															// center of the
															// quad to the edge
		/*
		 * define upper left corner (arctan(sizeX/sizeY) + 90) define lower
		 * right corner (arctan(sizeX/sizeY) + 90) + 180 +90 to get bearing
		 * distance from center to any corner = squareroot (sizeX^2 + sizeY^2)
		 * North = 0 degrees to directional baring... 0 = 90 , 90 = 0 , 180 =
		 * 270 , 270 = 180 East = 90 West = 270 South = 180
		 * 
		 * Upper Left latx 0 Upper Left lony 1 Lower right latx 2 Lower right
		 * lony 3
		 */
		double[] cornersArray = new double[4];
		cornersArray = corners(sizeX, sizeY, quad.getX(), quad.getY());

		if (x <= cornersArray[2] && x > quad.getX() && y >= cornersArray[3]
				&& y < quad.getY())// BottomRight
		{
			Quadrant BRQuad = new Quadrant(sizeX / 2 + quad.getX(), quad.getY()
					- sizeY / 2, _level);
			log.debug("Bottom Right X " + BRQuad.getX() + " Y "
					+ BRQuad.getY());
			log.debug("Child Level " + BRQuad.getDiv());

			_level++;

			if (_level < _maxLvl) {
				addChild(BRQuad, x, y);
			}// end if
			else {
				_children.add(BRQuad);
				log.debug("Bottom Right");
				log.debug("Child X " + BRQuad.getX());
				log.debug("Child Y " + BRQuad.getY());
				log.debug("Child Level " + BRQuad.getDiv());
				_level = 0;
			}// end else
		}// end if
		if (x <= cornersArray[2] && x > quad.getX() && y <= cornersArray[1]
				&& y > quad.getY())// UpperRight
		{
			Quadrant URQuad = new Quadrant((sizeX / 2) + quad.getX(),
					(sizeY / 2) + quad.getY(), _level);
			log.debug("Upper Right");
			log.debug("Child X " + URQuad.getX());
			log.debug("Child Y " + URQuad.getY());
			log.debug("Child Level " + URQuad.getDiv());

			_level++;

			if (_level < _maxLvl) {
				addChild(URQuad, x, y);
			}// end if
			else if (_level >= _maxLvl) {
				_children.add(URQuad);
				log.debug("Upper Right");
				log.debug("Child X " + URQuad.getX());
				log.debug("Child Y " + URQuad.getY());
				log.debug("Child Level " + URQuad.getDiv());
				_level = 0;
			}// end else
		}// end if
		if (x >= cornersArray[0] && x < quad.getX() && y <= cornersArray[1]
				&& y > quad.getY())// UpperLeft
		{
			Quadrant ULQuad = new Quadrant(quad.getX() - (sizeX / 2),
					quad.getY() + (sizeY / 2), _level);
			log.debug("Upper Left Pos");
			log.debug("Child X " + ULQuad.getX());
			log.debug("Child Y " + ULQuad.getY());
			log.debug("Child Level " + ULQuad.getDiv());

			_level++;

			if (_level < _maxLvl) {
				addChild(ULQuad, x, y);
			}// end if
			else if (_level >= _maxLvl) {
				_children.add(ULQuad);
				_level = 0;
				log.debug("Upper Left Final");
				log.debug("Child X " + ULQuad.getX());
				log.debug("Child Y " + ULQuad.getY());
				log.debug("Child Level " + ULQuad.getDiv());
			}// end else
		}// end if
		if (x >= cornersArray[0] && x < quad.getX() && y >= cornersArray[3]
				&& y < quad.getY())// BottomLeft
		{
			Quadrant BLQuad = new Quadrant(quad.getX() - (sizeX / 2),
					quad.getY() - (sizeY / 2), _level);
			log.debug("Bottom Left");
			log.debug("Child X " + BLQuad.getX());
			log.debug("Child Y " + BLQuad.getY());
			log.debug("Child Level " + BLQuad.getDiv());

			_level++;

			if (_level < _maxLvl) {
				addChild(BLQuad, x, y);
			}// end if
			else if (_level >= _maxLvl) {
				_children.add(BLQuad);
				log.debug("Bottom Left");
				log.debug("Child X " + BLQuad.getX());
				log.debug("Child Y " + BLQuad.getY());
				log.debug("Child Level " + BLQuad.getDiv());

				_level = 0;
			}// end else
		}// end if
	}// end addChild()

	/**
	 * Looks for nodes at deepest level, returns instance of quadrant class that
	 * represents that node, allowing access to the x , y coords of the center
	 * of the quadrant and the level.
	 * 
	 * @return returns Quadrant object, at the deepest level
	 */

	@SuppressWarnings("unused")
	public Quadrant query() {
		int i;
		Quadrant childQuad;
		if (_children.size() > 0) {
			for (i = 0; i < _children.size(); i++) {
				childQuad = _children.get(i);

				log.debug(childQuad.getX());
				log.debug(childQuad.getY());
				log.debug(childQuad.getDiv());
				return childQuad;

			}// end for
		}// end if
		return null;
	}// query()

	/**
	 * requires an x , y coordinate, checks all of the high level quadrants to
	 * see if point falls inside its bounds
	 * 
	 * @param x - X Coordinate of point to be searched
	 * @param y - Y Coordinate of point to be searched
	 * @return <code> true </code> if point found, <code> false </code> if point
	 * 		   is not found
	 */
	public boolean search(double x, double y) {
		double xArea = 0.00000;
		double yArea = 0.00000;
		double n = 0;
		double[] cornersA = new double[4];
		n = (double) _maxLvl;
		Quadrant childQuad;

		xArea = (_map.getMapX() / Math.pow(2.0, n));
		yArea = (_map.getMapY() / Math.pow(2.0, n));
		cornersA = corners(xArea, yArea, x, y);
		if (_children.size() > 0) {
			int i = 0;
			childQuad = _children.get(i);
			if (x >= cornersA[0] && x <= cornersA[3]) {
				log.debug("Point with in quad with center "
						+ childQuad.getX() + " , " + childQuad.getY()
						+ " meters");
				log.debug(xArea + " X " + yArea);
				return true;
			}// end if
		}// end if
		return false;
	}// end search

	/**
	 * searches deepest nodes from the linked list for a point specified if it
	 * is found, removes from the linked list and sets it to null causing it to
	 * be picked up by garbage collection.
	 * 
	 * @param x - X coordinate of point to be removed
	 * @param y - Y coordinate of point to be removed
	 * @return <code> true </code> if point found and removed,<code> false </code> if point unfound
	 */
	public boolean remove(double x, double y) {
		Quadrant removeQuad;
		double xArea = 0.00000;
		double yArea = 0.00000;
		double n = 0;
		n = (double) _maxLvl;
		double[] cornersA = new double[4];

		xArea = (_map.getMapX() / Math.pow(2.0, n));
		yArea = (_map.getMapY() / Math.pow(2.0, n));

		if (_children.size() > 0) {
			int i = 0;
			removeQuad = _children.get(i);
			cornersA = corners(xArea, yArea, removeQuad.getX(),
					removeQuad.getY());
			if (x >= cornersA[0] && x <= cornersA[3]) {
				removeQuad = _children.removeLast(); // removes deepest level
													// quad
				log.debug("Last Quad " + removeQuad.getX());
				log.debug(removeQuad.getY());
				log.debug(removeQuad.getDiv());
				removeQuad = null; // sets quad to null
				Quadrant lastQuad;
				lastQuad = _children.get(_children.size() - 1);
				log.debug("Last Quad" + lastQuad.getX());
				log.debug(lastQuad.getY());
				log.debug(lastQuad.getDiv());
				return true;
			}// end if
		}// end if
		return false;
	}// end remove()

	/**
	 * requires a starting point and an end point defined by x , y coordinates
	 * determines the equation of the line and generates points on that line
	 * returns nothing
	 * 
	 * @param xLineStart - X coordinate of the start of the line
	 * @param yLineStart - Y coordinate of the start of the line
	 * @param xLineEnd - X coordinate of the end of the line
	 * @param yLineEnd - Y coordinate of the end of the line
	 */

	public void addLine(double xLineStart, double yLineStart, double xLineEnd,
			double yLineEnd) {
		double dx = 0.0;
		double dy = 0.0;
		double baring = 0.0;
		double x = xLineStart;
		double[] points = new double[2];

		dx = xLineEnd - xLineStart;
		dy = yLineEnd - yLineStart;
		baring = Math.atan(dx / dy);

		points = destination(xLineStart, yLineStart, baring, _maxInterval);

		while (x >= xLineStart && x < xLineEnd) {
			points = destination(points[0], points[1], baring, _maxInterval);
			log.debug(points[0] + " , " + points[1]);
			x = points[0];
			quadCheck(points[0], points[1]);
		}// end while
	}// end addLine

	/**
	 * Requires the x , y coordinates of the upper left and lower right of a
	 * rectangular area searchs specified area for quadrants with center point
	 * inside search area. returns a multi-dimensional array of x and y values
	 * for each point found in the search area.
	 * 
	 * @param upperLeftX - the X coordinate of the upper left corner of the search area
	 * @param upperLeftY - the Y coordinate of the upper left corner of the search area
	 * @param lowerRightX - the X coordinate of the lower right corner of the search area
	 * @param lowerRightY - the Y coordinate of the lower right corner of the search area
	 * @return a multi-dimensional array of doubles the first index 0 is x or 1
	 *         is y values second index is count
	 */

	public double[][] areaSearch(double upperLeftX, double upperLeftY,
			double lowerRightX, double lowerRightY) {
		Quadrant childQuad;
		int i = 0;
		int resultCount = 0;
		for (i = 0; i < _children.size(); i++)// this loop determines the number
												// of results
		{
			childQuad = _children.get(i);

			if (childQuad.getX() <= upperLeftX
					&& childQuad.getY() >= lowerRightX
					&& childQuad.getY() <= upperLeftY
					&& childQuad.getY() >= lowerRightY) {
				resultCount++;
			}// end if
		}// end for loop

		double[][] results;
		results = new double[2][resultCount];// array of x , y values of size of
												// number of results
		for (i = 0; i < _children.size(); i++) {
			childQuad = _children.get(i);

			if (childQuad.getX() <= upperLeftX
					&& childQuad.getY() >= lowerRightX
					&& childQuad.getY() <= upperLeftY
					&& childQuad.getY() >= lowerRightY) {
				results[0][i] = childQuad.getX();
				results[1][i] = childQuad.getY();
			}// end if
		}// end for loop
		return results;
	}// end areaSearch


	/*
	 * Vincenty Inverse Solution of Geodesics on the Ellipsoid (c) Chris Veness
	 * 2002-2010                                                                                             
	 *
	 * from: Vincenty inverse formula - T Vincenty, "Direct and Inverse
	 * Solutions of Geodesics on the
	 * 
	 * Ellipsoid with application of nested equations", Survey Review, vol XXII
	 * no 176, 1975
	 *
	 * http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf *
	 */

	/**
	 * Calculates geodetic distance between two points specified by
	 * latitude/doubleitude using Vincenty inverse formula for ellipsoids
	 * 
	 * @param {Double} lat1, lon1: first point in decimal degrees
	 * @param {Double} lat2, lon2: second point in decimal degrees
	 * @return {Double} distance in metres between points
	 */

	public double dist(double lat1, double lon1, double lat2, double lon2) {
		//WGS-84 ellipsoid params
		double a = 6378137, b = 6356752.314245, f = 1 / 298.257223563; 
		
		double L = Math.toRadians(lon2 - lon1);
		double U1 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat1)));
		double U2 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat2)));
		double sinU1 = Math.sin(U1), cosU1 = Math.cos(U1);
		double sinU2 = Math.sin(U2), cosU2 = Math.cos(U2);
		double cosSqAlpha = 0.0;
		double sinSigma = 0.0;
		double cos2SigmaM = 0.0;
		double cosSigma = 0.0;
		double sigma = 0.0;
		double lambda = L, lambdaP, iterLimit = 100;
		do {
			double sinLambda = Math.sin(lambda), cosLambda = Math.cos(lambda);
			sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda)
					+ (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda)
					* (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
			if (sinSigma == 0) {
				return 0; // co-incident points
			}
			cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
			sigma = Math.atan2(sinSigma, cosSigma);
			double sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
			cosSqAlpha = 1 - sinAlpha * sinAlpha;
			cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
			if (Double.isNaN(cos2SigmaM)) {
				cos2SigmaM = 0; // equatorial line: cosSqAlpha=0 (§6)
			}
			double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
			lambdaP = lambda;
			lambda = L
					+ (1 - C)
					* f
					* sinAlpha
					* (sigma + C
							* sinSigma
							* (cos2SigmaM + C * cosSigma
									* (-1 + 2 * cos2SigmaM * cos2SigmaM)));
		} while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0);// end
																		// do/while

		if (iterLimit == 0) {
			return Double.NaN; // formula failed to converge
		}
		double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
		double A = 1 + uSq / 16384
				* (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
		double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
		double deltaSigma = B
				* sinSigma
				* (cos2SigmaM + B
						/ 4
						* (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B
								/ 6 * cos2SigmaM
								* (-3 + 4 * sinSigma * sinSigma)
								* (-3 + 4 * cos2SigmaM * cos2SigmaM)));
		double s = b * A * (sigma - deltaSigma);

		return s;

	}// end dist

	/**
	 * Calculate destination point given start point lat/long (numeric degrees),
	 * bearing (numeric degrees) & distance (in m).
	 * 
	 * from: Vincenty direct formula - T Vincenty, "Direct and Inverse Solutions
	 * of Geodesics on the Ellipsoid with application of nested equations",
	 * Survey Review, vol XXII no 176, 1975
	 * http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf
	 */
	public double[] destination(double lat1, double lon1, double brng,
			double dist) {
		double a = 6378137, b = 6356752.3142, f = 1 / 298.257223563; // WGS-84
																		// ellipsiod
		double s = dist;
		double alpha1 = Math.toRadians(brng);
		double sinAlpha1 = Math.sin(alpha1);
		double cosAlpha1 = Math.cos(alpha1);

		double tanU1 = (1 - f) * Math.tan(Math.toRadians(lat1));
		double cosU1 = 1 / Math.sqrt((1 + tanU1 * tanU1)), sinU1 = tanU1
				* cosU1;
		double sigma1 = Math.atan2(tanU1, cosAlpha1);
		double sinAlpha = cosU1 * sinAlpha1;
		double cosSqAlpha = 1 - sinAlpha * sinAlpha;
		double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
		double A = 1 + uSq / 16384
				* (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
		double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
		double sinSigma = 0.0;
		double cosSigma = 0.0;
		double cos2SigmaM = 0.0;
		double deltaSigma = 0.0;

		double sigma = s / (b * A), sigmaP = 2 * Math.PI;
		while (Math.abs(sigma - sigmaP) > 1e-12) {
			cos2SigmaM = Math.cos(2 * sigma1 + sigma);
			sinSigma = Math.sin(sigma);
			cosSigma = Math.cos(sigma);
			deltaSigma = B
					* sinSigma
					* (cos2SigmaM + B
							/ 4
							* (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B
									/ 6
									* cos2SigmaM
									* (-3 + 4 * sinSigma * sinSigma)
									* (-3 + 4 * cos2SigmaM * cos2SigmaM)));
			sigmaP = sigma;
			sigma = s / (b * A) + deltaSigma;
		}

		double tmp = sinU1 * sinSigma - cosU1 * cosSigma * cosAlpha1;
		double lat2 = Math.atan2(sinU1 * cosSigma + cosU1 * sinSigma
				* cosAlpha1,
				(1 - f) * Math.sqrt(sinAlpha * sinAlpha + tmp * tmp));
		double lambda = Math.atan2(sinSigma * sinAlpha1, cosU1 * cosSigma
				- sinU1 * sinSigma * cosAlpha1);
		double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
		double L = lambda
				- (1 - C)
				* f
				* sinAlpha
				* (sigma + C
						* sinSigma
						* (cos2SigmaM + C * cosSigma
								* (-1 + 2 * cos2SigmaM * cos2SigmaM)));

		//@SuppressWarnings("unused")
		//double revAz = Math.atan2(sinAlpha, -tmp); // final bearing
		double[] Coords = new double[2];
		Coords[0] = Math.toDegrees(lat2);
		Coords[1] = Math.toDegrees(lon1 + L);
		return Coords;
	}// end destination

	/**
	 * Determines the size of the overall map given the coordinates for the
	 * upper left corner and the coordinates for the lower right corner and sets
	 * the mapSizeX and mapSizeY variables.
	 * 
	 * @param maxLat - Latitude of the upper left corner
	 * @param maxLon - Longitude of the upper left corner
	 * @param minLat - Latitude of the lower right corner
	 * @param minLon - Longitude of the lower right corner
	 */
	public void setMapSize(double maxLat, double maxLon, double minLat,
			double minLon) {

		_mapSizeX = dist(maxLat, maxLon, maxLat, minLon);
		_mapSizeY = dist(maxLat, maxLon, minLat, maxLon);

	}// end mapSizeSet

	/**
	 * Determines the coordinates of the upper left corner and lower right
	 * corner of a box of a given x and y size
	 * 
	 * @param x - the size in the x direction of the box
	 * @param y - the size in the y direction of the box
	 * @param lat - the latitude of the center of the box
	 * @param lon - the longitude of the center of the box
	 * @return a array of doubles of the coordinates for the upper left corner
	 *         and lower right corner of of the box in the order upper left
	 *         latitude, upper left longitude , lower right latitude, lower
	 *         right longitude
	 */
	public double[] corners(double x, double y, double lat, double lon) {
		double baring = 0.0;
		double dist = 0.0;

		double[] cornersA = new double[4];
		double[] coordsA = new double[2];

		dist = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));

		baring = Math.atan(x / y);
		baring = (Math.toDegrees(baring) + 90);
		coordsA = destination(lat, lon, baring, dist);
		cornersA[0] = coordsA[0];// upper left lat
		cornersA[1] = coordsA[1];// upper left lon

		baring = baring + 180;
		coordsA = destination(lat, lon, baring, dist);
		cornersA[2] = coordsA[0];// lower right lat
		cornersA[3] = coordsA[1];// lower right lon

		return cornersA;
	}// end corners

	@Override
	public void run() {
		log.debug("Starting...");
		while (_isRunning == true){
			//Do nothing, simple keep-alive loop.
			log.debug("thread is alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		_isRunning = true;
		_thread.run();
		log.info("Quad Map Started.");
	}
	
	public void stop(){
		_isRunning = false;
		log.info("Quad Map Stopped");
	}

}// end QuadMap class