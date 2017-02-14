package robOS2.gui;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import robOS2.gui.config.LIDARViewerSettings;
import robOS2.mapping.lidar.LIDARMap;

public class LidarViewer implements Runnable{
	private static Logger log = Logger.getLogger(LidarViewer.class.getName());
	private final static String NAME = "LIDAR Viewer";
	private final static String VERSION = "1.0.0";
	
	public LidarViewer() {
		super();
	}
	
	public void lidarUpdate (){
		log.info("LIDAR GUI Initializing...");
		final int INTERVAL = 500;	//Set the refresh rate for half a second
		final Display display = new Display ();
		
		//Set the app name & version
		Display.setAppName(NAME);
		Display.setAppVersion(VERSION);
		
		//Create a area to draw the arc to display the LIDAR range on
		final Image image = new Image (display, LIDARViewerSettings.getX_DIM(), LIDARViewerSettings.getY_DIM());
		GC gc = new GC (image);
		gc.setBackground (display.getSystemColor (SWT.COLOR_GRAY));
		gc.fillRectangle (image.getBounds ());
		gc.dispose ();	//Maintance Stuff

		//Create the actual window
		Shell shell = new Shell (display);
		shell.setText(NAME);	//Setting the name in the title-bar
		//Setting the bounds for the GUI window so the entire arc can display properly
		shell.setBounds (0, 0, (LIDARViewerSettings.getX_DIM() + 16), (LIDARViewerSettings.getY_DIM() + 38));
		//Create the canvas we will actually use to draw and update the arc
		final Canvas canvas = new Canvas (shell, SWT.NONE);
		//Make it the window dimensions
		canvas.setBounds (0, 0, LIDARViewerSettings.getX_DIM(), LIDARViewerSettings.getY_DIM());
		canvas.addListener (SWT.Paint, new Listener () {
			public void handleEvent (Event event) {
				//Draw a blank black arc
				event.gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
				event.gc.drawImage (image, 0, 0);
				event.gc.fillArc(0, 0, LIDARViewerSettings.getX_DIM(), LIDARViewerSettings.getY_DIM()*2, 0, 180);
			}
		});
		
		//Update the canvas with new data from the LIDAR
		display.timerExec (INTERVAL, new Runnable () {
			public void run () {
				if (canvas.isDisposed ()){
					return;
				}
				
				GC gc = new GC (canvas);
				
				//Loop through the array of LIDAR data and write it to the screen.
				double lidarDistance;
				double lidarPercentage;
				int lidarMaxRange = LIDARMap.getMaxRange();
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
				gc.fillArc(0, 0, LIDARViewerSettings.getX_DIM(), LIDARViewerSettings.getY_DIM()*2, 0, 180);
				
				for(int i = 0; i < 180; i++){
					
					//Get the "raw" data from the LIDAR
					lidarDistance = LIDARMap.getDistanceAtStep(i*2);

					//Convert it into a percentage
					lidarPercentage = 1-((lidarMaxRange - lidarDistance)/lidarMaxRange);
					
					if(lidarPercentage <= 0.10){
						//Set color to RED
						gc.setBackground(new Color(display, 220, 20, 60));
					} else if (lidarPercentage <= 0.20){
						//Set color to DARK ORANGE
						gc.setBackground(new Color(display, 205, 55, 0));
					} else if (lidarPercentage <= 0.30){
						//Set color to ORANGE
						gc.setBackground(new Color(display, 255, 128, 0));
					} else if (lidarPercentage <= 0.40){
						//Set color to DARK YELLOW
						gc.setBackground(new Color(display, 205, 173, 0));
					} else if (lidarPercentage <= 0.50){
						//Set color to YELLOW
						gc.setBackground(new Color(display, 238, 238, 0));
					} else if (lidarPercentage <= 0.60){
						//Set color to BRIGHT YELLOW
						gc.setBackground(new Color(display, 255, 255, 0));
					} else if (lidarPercentage <= 0.70){
						//Set color to DARK GREEN
						gc.setBackground(new Color(display, 0, 100, 0));
					} else if (lidarPercentage <= 0.80){
						//Set color to MEDIUM GREEN
						gc.setBackground(new Color(display, 84, 139, 84));
					} else if (lidarPercentage <= 0.90){
						//Set color to GREEN
						gc.setBackground(new Color(display, 0, 128, 0));
					} else {
						//Set color to BRIGHT GREEN
						gc.setBackground(new Color(display, 0, 255, 0));
					}
					
					gc.fillArc((LIDARViewerSettings.getX_DIM() / 2) - ((int)((LIDARViewerSettings.getX_DIM() * lidarPercentage)/2)),
							LIDARViewerSettings.getY_DIM() - ((int)((LIDARViewerSettings.getX_DIM() * lidarPercentage)/2)),
								((int)(LIDARViewerSettings.getX_DIM() * lidarPercentage)),
								((int)(LIDARViewerSettings.getX_DIM() * lidarPercentage)),
								i,
								1);
				}
				
				display.timerExec (INTERVAL, this);
			}
		});
		shell.open ();
		while (!shell.isDisposed ()){
			if (!display.readAndDispatch ()) display.sleep ();
		}
		image.dispose ();
		display.dispose ();
	}


	@Override
	public void run() {
		this.lidarUpdate();
		
	}

}
