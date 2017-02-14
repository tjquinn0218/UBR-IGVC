package robOS2.network.listener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class VisionListener implements Runnable, INetworkListener{
	static Logger log = Logger.getLogger(VisionListener.class.getName());
	private InputStreamReader _is;
	private boolean _isRunning = false;
	private char[] _buffer = new char[1024];
	
	public VisionListener(InputStream inputStream) {
		_is = new InputStreamReader(inputStream);
		log.debug("Vision Listener is attached to an input stream.");
	}

	public void processInput(){
		try {
			_is.read(_buffer);
			log.info("got some data");
		} catch (IOException e) {
			log.error("An IO Exception has occured on the socket's input stream.");
		}
	}
	
	@Override
	public void run() {
		_isRunning = true;
		
		log.info("Vision listener is started.");
		
		while(_isRunning){
			this.processInput();
		}
		
		log.info("Vision Listener is shutting down.");
	}
	
	public void stop(){
		_isRunning = false;
	}

}
