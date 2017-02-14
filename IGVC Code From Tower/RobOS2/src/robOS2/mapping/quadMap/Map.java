package robOS2.mapping.quadMap;
public class Map {

	double ULLat = 0.0;
	double ULLon = 0.0;
	double LRLat = 0.0;
	double LRLon = 0.0;
	double mapSizeX = 0.0;
	double mapSizeY = 0.0;

	public Map(double upperLeftLat, double upperLeftLon, double lowerRightLat,
			double lowerRightLon) {
		ULLat = upperLeftLat;
		ULLon = upperLeftLon;
		LRLat = lowerRightLat;
		LRLon = lowerRightLon;
	}// end constructor

	public double getMapX() {
		return mapSizeX;
	}

	public double getMapY() {
		return mapSizeY;
	}

	public double getULLat() {
		return ULLat;
	}

	public double getULLon() {
		return ULLon;
	}

	public double getLRLat() {
		return LRLat;
	}

	public double getLRLon() {
		return LRLon;
	}

}// end class