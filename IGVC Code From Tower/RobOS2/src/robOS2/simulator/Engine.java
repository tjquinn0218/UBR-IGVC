package robOS2.simulator;

import org.apache.log4j.Logger;

import robOS2.navigation.IPathPlanner;

/**
 * Support class to simulate the movement of a robotic platform. This is done
 * by simulating sensor data & platform movement.
 * 
 * @author <a href="mailto:dbaratta@buffalo.edu">Dominic Baratta</a>
 */
public class Engine implements Runnable{
	static Logger log = Logger.getLogger(Engine.class.getName());
	private boolean _isRunning = false;
	private Thread _thread = new Thread(this, "simulator");
	private Double _forwardVelocity = 0.0;				//Default to 0 m/s (0 mph)
	private Double _rotationalVelocity = 0.0; 			//Default to 0 m/s (0 mph)
	private Double _maxForwardVelocity = 5.0;			//5 m/s
	private Double _maxRotationalVelocity = 5.0;		//5 m/s
	private int _resolution = 10;						//In cm
	private IPathPlanner _planner;
	
	private int _mapLocationIndex = 0;
	
	public Engine(IPathPlanner planner) {
		_planner = planner;
	}
	
	/**
	 * Starts the simulation engine on it's own thread. This also includes a
	 * check to see if the engine is already running. If it is nothing is thrown
	 * however a warning is issued to the logger that the simulator is already
	 * running.
	 */
	public void start(){
		if(!_isRunning){
			_isRunning = true;
			try{
				if(!_thread.isAlive()){
					_thread.start();
					log.info("Simulation engine started.");
				} else {
					_thread.run();
				}
			} catch (IllegalThreadStateException e){
				//_isRunning set to true again. Do nothing.
				this.run();
			} catch (Exception e){
				log.fatal("Error in the simulator engine.");
			}
		} else {
			log.warn("Simulation engine already running.");
		}
	}
	
	public void setVelocity(double velocity){
		_forwardVelocity = velocity;
		log.info("--> Simulator velocity set to: " + velocity);
	}
	
	public void setRotationalVelocity(double velocity){
		_rotationalVelocity = velocity;
	}
	
	public double getVelocity(){
		return _forwardVelocity;
	}
	
	public double getRotationalVelocity(){
		return _rotationalVelocity;
	}
	
	/**
	 * Set's the SIMULATOR map resolution.
	 * @param resolution
	 */
	public void setResolution(int resolution){
		_resolution = resolution;
	}
	
	/**
	 * Returns the SIMULATOR's map resolution
	 * @return
	 */
	public int getResolution(){
		return _resolution;
	}
	
	/**
	 * Updates the current position of the robot on the obstacle map
	 */
	private void updateMapPosition(){
		//Update the map location index
		_mapLocationIndex++;
		log.debug("\tNew Map Location Index: " + _mapLocationIndex);
		
		//Grab new velocity and rotation data
		_forwardVelocity  = _planner.getForwardVelocity();
		_rotationalVelocity = _planner.getRotationalVelocity();
		log.debug("\tForward Velocity: " + _forwardVelocity + "\t\tRotational Velocity: " + _rotationalVelocity);
		
		log.debug("Sending new velocity data to the motor-controller");
		int forwardPercent = this.calculateSimForwardVelocity();
		int rotationPercent = this.calculateSimRotationalVelocity();
		log.info("SIMULATOR VELOCITYS >> FORWARD: " + forwardPercent + "%\t\tROTATIONAL: " + rotationPercent + "%");
	}
	
	/**
	 * Returns the current drive angle of the platform based on the last update from the motor controller
	 * Output is in m/s
	 * @return
	 */
	public double calculateDriveAngle(){
		return Math.atan((_forwardVelocity / _rotationalVelocity));
	}
	
	/**
	 * Returns the current forward velocity of the platform based on the last update from the motor controller
	 * Output is in m/s
	 * @return
	 */
	public double calculateDriveSpeed(){
		return Math.sqrt(Math.pow(_forwardVelocity, 2) + Math.pow(_rotationalVelocity, 2));
	}
	
	/**
	 * Calculates the "forward velocity percentage" based off of the current platform velocity, as well
	 * as the predefined maximum speed as defined at the top of this file. 
	 * @return
	 */
	public int calculateSimForwardVelocity(){
		int percentage = (int)((_forwardVelocity / _maxForwardVelocity) * 100);
		if(percentage > 100){
			return 100;
		} else if (percentage < -100){
			return -100;
		} else {
			return percentage;
		}
	}
	
	/**
	 * Calculates the "forward velocity percentage" based off of the current platform velocity, as well
	 * as the predefined maximum speed as defined at the top of this file. 
	 * @return
	 */
	public int calculateSimRotationalVelocity(){
		int percentage = (int)((_rotationalVelocity / _maxRotationalVelocity) * 100);
		if(percentage > 100){
			return 100;
		} else if (percentage < -100){
			return -100;
		} else {
			return percentage;
		}
	}
	
	/**
	 * Stops the simulation engine, as well as the thread that it is running on
	 * This checks if the engine is running first before it trys to stop it. If
	 * it is not running no error is thrown, however a warning that the engine
	 * was already stopped is issued to the logger.
	 */
	public void stop(){
		if(_isRunning){
			_isRunning = false;
			
			log.info("Simulation engine stopped.");
		} else {
			log.warn("Simulation engine already stopped.");
		}
	}

	/**
	 * Starts the simulation engine thread
	 */
	@Override
	public void run() {
		
		log.info("Simulation thread started.");
		while(_isRunning){
			//do some crap
			this.updateMapPosition();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
