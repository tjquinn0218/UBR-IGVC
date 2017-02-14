package robOS2.hardware.novatel.propak3;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import robOS2.hardware.interfaces.listeners.IGPSListener;
import robOS2.hardware.interfaces.marker.ISensorListener;

public class ProPak3Listener implements IGPSListener, ISensorListener, SerialPortEventListener{
	static Logger log = Logger.getLogger(ProPak3Listener.class.getName());
	
	private ProPak3Packet _packet;
	
	InputStream _in;
	int _mode = 0;
	
	public ProPak3Listener(InputStream in) {
		_in = in;
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		log.debug("getting data...");
		byte[] origBuffer = new byte[2048];
		byte[] tmpBuffer = new byte [4096];
		int size = 0;
		try {
			//_in.
			size = arg0.toString().length();
			byte[] testArray = new byte[2048];
			
			_in.read(testArray);
			@SuppressWarnings("deprecation")
			String input = IOUtils.toString(testArray, "UTF-8");
			log.debug("Got: " + input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 0;
		
		for(int i = 0; i < size; i++) {
			byte b = tmpBuffer[i];
			if(b == 13 || b == 10) {
				byte[] buffer = new byte[index];
				System.arraycopy(arg0.toString().getBytes(), 0, buffer, 0, index);
				modeSet(new String(buffer));
				index = 0;
			}
			else {
				origBuffer[index] = b;
				index++;
			}
		}
	}
	
	public void processString(String s, int mode) {
		log.debug("Processing Data");
		if(!s.trim().equals("")) {
			switch (mode) {
				case 1: setPositionData(s);
				case 2:	setVelocityData(s);
			} //End switch
		}//End if
	}//End method
	
	private void modeSet(String s){
		if(s.trim().equals("")) {
			return;
		}
		if(s.contains("BESTPOS")){
			log.debug("Mode set to 1");
			_mode = 1;
		}else if(s.contains("BESTVEL")){
			log.debug("Mode set to 2");
			_mode = 2;
		}else{
			processString(s,_mode);
			_mode = 0;
		}
	}
	
	public void setPositionData(String data) {
		data = data.substring(1);
		Scanner sc = new Scanner(data);
		try {
			sc.next();
			sc.next();
			double lat = sc.nextDouble();
			double lon = sc.nextDouble();
			double hgt = sc.nextDouble();
			sc.nextDouble();
			sc.next();
			double latSig = sc.nextDouble();
			double lonSig = sc.nextDouble();
			double hgtSig = sc.nextDouble();
			sc.next();
			sc.nextDouble();
			sc.nextDouble();
			int sattracked = sc.nextInt();
			int satused = sc.nextInt();
			
			_packet.setLon(lon);
			_packet.setLonSig(lonSig);
			_packet.setLat(lat);
			_packet.setLatSig(latSig);
			_packet.setHgt(hgt);
			_packet.setHgtSig(hgtSig);
			_packet.setSatTracked(sattracked);
			_packet.setSatUsed(satused);
		} catch(Exception e) {
		}
		sc.close();
	}
	
	public void setVelocityData(String s) {
		Scanner sc = new Scanner(s.substring(1));
		try {
			sc.next();
			sc.next();
			sc.next();
			sc.next();
			double horspd = sc.nextDouble();
			double trkgnd = sc.nextDouble();
			double vertspd = sc.nextDouble();
			
			//Compute dx, dy & dz (velocities in all 3 directions)
			double dx = horspd * Math.cos(Math.toRadians(trkgnd));
			double dy = horspd * Math.sin(Math.toRadians(trkgnd));
			double dz = -vertspd;
			
			//Write the velocities to our data holder (ProPak3Packet.java)
			_packet.setDx(dx);
			_packet.setDy(dy);
			_packet.setDz(dz);
		}
		catch(Exception e) {}
		sc.close();
	}

}
