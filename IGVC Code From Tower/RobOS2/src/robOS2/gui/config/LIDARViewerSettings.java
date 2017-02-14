package robOS2.gui.config;

public class LIDARViewerSettings {
	private static int X_DIM;
	private static int Y_DIM;
	private static int SCAN_RADIUS;
	private static double RESOLUTION;
	private static int REFRESH_RATE;
	
	public static void setX_DIM(int xDim) {
		X_DIM = xDim;
	}
	
	
	public static int getX_DIM() {
		return X_DIM;
	}
	
	
	public static void setY_DIM(int yDim) {
		Y_DIM = yDim;
	}
	
	
	public static int getY_DIM() {
		return Y_DIM;
	}
	
	
	public static void setSCAN_RADIUS(int scanRadus) {
		SCAN_RADIUS = scanRadus;
	}
	
	
	public static int getSCAN_RADIUS() {
		return SCAN_RADIUS;
	}
	
	
	public static void setRESOLUTION(double resolution) {
		RESOLUTION = resolution;
	}
	
	
	public static double getRESOLUTION() {
		return RESOLUTION;
	}


	public static void setREFRESH_RATE(int refreshRate) {
		REFRESH_RATE = refreshRate;
	}


	public static int getREFRESH_RATE() {
		return REFRESH_RATE;
	}
	
	
}
