package junitTests.lidar;

import static org.junit.Assert.*;
import org.junit.Test;

import robOS2.mapping.IMapConfig;
import robOS2.mapping.lidar.LIDARMap;


public class LidarMap implements IMapConfig{
	private LIDARMap _map;
	private int _mapSize = 0;
	private double[] _dataArray = new double[LIDARMap.getTotalSteps()];

	/**
	 * Attempts to create a new LIDAR map and checks to make sure
	 * it is not null.
	 */
	@Test
	public void newLidarMap(){
		_map = new LIDARMap();
		assertFalse("LIDAR Map was not created", (_map == null));
	}
	
	/**
	 * Tests to make sure the correct size of the map was returned.
	 * <b>NOTE:</b> if the size of the LIDAR map is updated this test case MUST
	 * also be updated.
	 */
	@Test
	public void getSizeOfMap(){
		_mapSize = LIDARMap.getTotalSteps();
		assertFalse("Map size is incorrect", _mapSize != 360);
	}
	
	/**
	 * Tests to make sure the maximum supported range by the LIDAR is NOT zero.
	 * This test also populates the "local" data array which is used in later
	 * tests for making sure the LIDAR array works as planned.
	 */
	@Test
	public void getMaxRange(){
		int maxRange = LIDARMap.getMaxRange();
		assertFalse("Could not fetch max range!", maxRange == 0);
		
		for(int i = 0; i < _mapSize; i++){
			_dataArray[i] = Math.random()*maxRange;
		}
	}
	
	/**
	 * Adds predetermined "local" data to the LIDAR map. This data is cached so it
	 * can be checked in later steps.
	 */
	@Test
	public void addDataToMap(){
		try{
			for (int i = 0; i < LIDARMap.getTotalSteps(); i++){
				LIDARMap.setDistanceAtIndex(i, _dataArray[i]);
			}
		} catch (Exception e){
			assertFalse("An error has occured while adding data to the map.", true);
		}
	}
	
	/**
	 * Checks the data which was added to the LIDAR map in the addDataToMap test-case
	 * to be sure it matches the data which was cached locally. This test uses the
	 * getDistanceAtStep method of LIDARMap.
	 */
	@Test
	public void verifyMapData(){
		for (int i = 0; i < LIDARMap.getTotalSteps(); i++){
			assertFalse("Map data does not match!", LIDARMap.getDistanceAtStep(i) != _dataArray[i]);
		}
	}
	
	/**
	 * Checks the data which was added to the LIDAR map in the addDataToMap test-case
	 * to be sure it matches the data which was cached locally. This test uses the
	 * getDistanceAtAngle method of LIDARMap.
	 */
	@Test
	public void verifyMapDataByAngle(){
		for (int i = 0; i < LIDARMap.getTotalSteps(); i++){
			assertFalse("Map data does not match!", LIDARMap.getDistanceAtAngle(i * LIDAR_STEP_SIZE) != _dataArray[i]);
		}
	}
}
