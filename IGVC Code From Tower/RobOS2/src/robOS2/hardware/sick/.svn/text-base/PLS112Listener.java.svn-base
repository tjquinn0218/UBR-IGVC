package robOS2.hardware.sick;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import gnu.io.SerialPortEvent;
import robOS2.hardware.interfaces.listeners.ILIDARListener;
import robOS2.utility.SICKHelper;

public class PLS112Listener implements ILIDARListener{
	static Logger log = Logger.getLogger(PLS112Listener.class.getName());
	private InputStream _in;
	private byte[] _total = new byte[4096];
	private int _totalIndex = 0;
	private int _startIndex = 0;
	private int _size = -1;
	private boolean _foundStart = false;
	private PLS112Processor _processor = new PLS112Processor();
	
	public PLS112Listener(InputStream in) {
		_in = in;
	}
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {
        int len = 0;
        byte[] buffer = new byte[4096];
		// Read in the data until a new line character is seen
        try {
        	len = _in.read(buffer);

		} catch (IOException e) {
			e.printStackTrace();
		}
        
		for(int i = 0; i < len; i++) {
			_total[_totalIndex] = buffer[i];
			_totalIndex++;
		}
		len = 0;
		buffer = new byte[4096];
		this.checkForPacket();
	}
	
	public void checkForPacket(){
		//log.debug("checking for packet");
		while(_size == -1 && _startIndex < _totalIndex && _total[_startIndex] != 2) {
			_startIndex++;
			//log.debug("in while");
		} //end while loop
		
		if(_total[_startIndex] == 2) {
			//log.debug("in first if");
			//log.debug("found start of sick packet...");
			_foundStart = true; 
			try {
				if(_total[_startIndex - 2] == 2) {
					//log.debug("in second if");
					_startIndex -= 2;	
				} //end _total[_startIndex - 2] == 2 if
			} catch(Exception e) {
				//log.debug("in catch");
			}
		} //end _toatl[_startIndex] == 2 if statement
		
		if(_foundStart) {
			if(_size == -1 && _totalIndex > _startIndex + 10) {
				log.debug("in third if");
				_size = SICKHelper.getSICKData(_total[_startIndex + 2], _total[_startIndex + 3]);
			}
			else if(_size != -1 /*&& _totalIndex >= _startIndex + _size + 6*/) {
				log.debug("in else if");
				int packetSize = _size + 6;
				byte[] packet = new byte[_size + 6];
				System.arraycopy(_total, _startIndex, packet, 0, packetSize);
				_total = new byte[4096];
				_totalIndex = 0;
				_startIndex = 0;
				_size = -1;
				_foundStart = false;
				
				log.debug("Processing SICK Data");
				_processor.process(packet);
			} //end else-if
		} //end found start if
		//this.reset();
	} //end check for packet

	
	public void reset(){
		_total = new byte[4096];
		_totalIndex = 0;
		_startIndex = 0;
		_size = -1;
		_foundStart = false;
	}
}
