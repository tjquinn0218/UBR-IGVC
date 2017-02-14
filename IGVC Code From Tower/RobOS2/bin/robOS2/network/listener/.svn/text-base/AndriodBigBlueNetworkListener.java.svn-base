package robOS2.network.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.log4j.Logger;

import robOS2.hardware.ubr.UBRMotorControllerDirectDrive;

public class AndriodBigBlueNetworkListener implements INetworkListener{
	private static Logger log = Logger.getLogger(AndriodBigBlueNetworkListener.class.getName());
	
	public AndriodBigBlueNetworkListener(Socket s) {
		try {
			//UBRMotorControllerDirectDrive mc = new UBRMotorControllerDirectDrive();
			String input = "";
			int fwd = 0;
			int rot = 0;
		
			BufferedReader socketRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while(s.isConnected()){
				input = socketRead.readLine();
				if(input.startsWith("fvel")){
					fwd = Integer.parseInt(input.substring(4));
					log.debug("Forward Vel: " + fwd);
				} else if(input.startsWith("rvel")){
					rot = Integer.parseInt(input.substring(4));
					log.debug("Rotational Vel: " + rot);
				} else if(input.startsWith("AndroidClient")){
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
