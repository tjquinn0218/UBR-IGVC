package robOS2.mapping.gridMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GridMap<T>{
	private T _type;
	private int _height;
	private int _width;
	private double _resolution;
	private Map<Integer, Map<Integer, T>> _xMap;
	private Map<Integer, T> _yMap;
	
	/**
	 * Creates a new grid-based map. This is implemented with a hash map
	 * and is useful in keeping track of where we are in the world.
	 * 
	 * <b><i>This class IS thread-safe</i></b>
	 * 
	 * @param height - In meters
	 * @param width - In meters
	 * @param resolution - In centimeters
	 */
	public GridMap (int height, int width, double resolution) {
		_height = height;
		_width = width;
		_resolution = resolution;
		
		setXMap(Collections.synchronizedMap(new HashMap<Integer, Map<Integer, T>>()));
		setYMap(Collections.synchronizedMap(new HashMap<Integer, T>()));
	}
	
	public void addObject(double xPosition, double yPosition){
		
	}
	
	/**
	 * Returns the "height" of the map in meters
	 * @return
	 */
	public int getHeight(){
		return _height;
	}
	
	/**
	 * Returns the width of map in meters
	 * @return
	 */
	public int getWidth(){
		return _width;
	}
	
	/**
	 * Returns the resolution of the map in centimeters
	 * @return
	 */
	public double getResolution(){
		return _resolution;
	}

	public void setYMap(Map<Integer, T> _yMap) {
		this._yMap = _yMap;
	}

	public Map<Integer, T> getYMap() {
		return _yMap;
	}

	public void setXMap(Map<Integer, Map<Integer, T>> _xMap) {
		this._xMap = _xMap;
	}

	public Map<Integer, Map<Integer, T>> getXMap() {
		return _xMap;
	}

	public void setType(T _type) {
		this._type = _type;
	}

	public T getType() {
		return _type;
	}
}
