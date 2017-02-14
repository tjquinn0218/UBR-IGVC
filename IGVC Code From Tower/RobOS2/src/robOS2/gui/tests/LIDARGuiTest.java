package robOS2.gui.tests;

import java.io.IOException;

import org.xml.sax.SAXException;

import robOS2.gui.LidarViewer;
import robOS2.mapping.IMapConfig;
import robOS2.mapping.lidar.LIDARMap;
import robOS2.utility.Math;
import robOS2.xml.Parser;
import robOS2.xml.handler.GUIHandler;

public class LIDARGuiTest implements IMapConfig{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		
		Parser parser = new Parser(new GUIHandler());
		try {
			parser.parse("C:\\Users\\dbaratta\\workspace\\RobOS2\\src\\gui_config.xml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int size = (int)(LIDAR_TOTAL_RANGE * Math.Inverse(LIDAR_STEP_SIZE));
		for(int i = 0; i < size; i++){
			LIDARMap.setDistanceAtIndex(i, java.lang.Math.random()*800);
		}
		LIDARMap.setMaxRange(800);
		LidarViewer viewer = new LidarViewer();
		Thread lidarViewerThread = new Thread(viewer, "LIDAR Viewer");
		lidarViewerThread.start();
		
		while(true){
			for(int i = 0; i < size; i++){
				LIDARMap.setDistanceAtIndex(i, java.lang.Math.random()*800);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		viewer.run();
	}

}
