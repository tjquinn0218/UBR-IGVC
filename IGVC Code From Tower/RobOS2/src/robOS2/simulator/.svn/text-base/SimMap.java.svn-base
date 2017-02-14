package robOS2.simulator;

public class SimMap{
	private int _width = 0;
	private int _height = 0;
	private int _currentX = 0;
	private int _currentY = 0;
	
	/**
	 * Creates a new simulator map with the given dimensions. The dimensions are in meters.
	 * The map's current x and current y positions will be set to the middle of the array.
	 * @param width
	 * @param height
	 */
	public SimMap(int width, int height) {
		_width = width;
		_height = height;
		_currentX = _width / 2;
		_currentY = _height / 2;
	}
	
	/**
	 * Creates a new simulator map with the given dimensions. The dimensions are in meters.
	 * The map's current x and current y positions will be set to the provided arguments 
	 * (startX and startY are in increments of 10 centimeters).
	 * @param width
	 * @param height
	 * @param startX
	 * @param startY
	 */
	public SimMap(int width, int height, int startX, int startY){
		_width = width;
		_height = height;
		_currentX = startX;
		_currentY = startY;
	}
	
	
	public int getCurrentXPosition(){
		return _currentX;
	}
	
	public int getCurrentYPosition(){
		return _currentY;
	}
	
	/**
	 * Adds the update factor to the current map position
	 * @param updateFactor
	 */
	public void updateCurrentX(int updateFactor){
		_currentX = _currentX + updateFactor;
	}
	
	/**
	 * Adds the update factor to the current map position
	 * @param updateFactor
	 */
	public void updateCurrentY(int updateFactor){
		_currentY = _currentY  + updateFactor;
	}
}
