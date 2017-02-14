package robOS2.hardware.sick;

import org.apache.log4j.Logger;

import robOS2.mapping.lidar.LIDARMap;

public class PLS112Processor {
	static Logger log = Logger.getLogger(PLS112Processor.class.getName());
	
	public PLS112Processor() {
		log.debug("PLS 112 Processor Started");
	}

	public void process(byte[] packet) {
		SICKData data = new SICKData(packet);
		if(data.getLength() == 732){
			log.debug("Writing data to array.");
			for(int i = 0; i < 321; i++){
				LIDARMap.setDistanceAtIndex(i, data.getData(i));
			}
			log.debug("Data wrote to array");
		} else {
			log.debug("Skipped writing data to array since size != 726. Length is: "
					  + data.getLength());
		}
	}

}
