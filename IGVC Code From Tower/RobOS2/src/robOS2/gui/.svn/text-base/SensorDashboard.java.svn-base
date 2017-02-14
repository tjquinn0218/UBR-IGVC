package robOS2.gui;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class SensorDashboard implements Runnable{
	
	
	public SensorDashboard() {
		super();
	}
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(SensorDashboard.class.getName());
	private final static int MAIN_WINDOW_X_BOUND = 1000;
	private final static int MAIN_WINDOW_Y_BOUND = 400;
	@SuppressWarnings("unused")
	private final static String NAME = "Sensor Dashboard";
	@SuppressWarnings("unused")
	private final static String VERSION = "0.1.0";
	static String value;
	final Display display = new Display ();
	public static void main (String [] args)
	{
		final int INTERVAL = 250;
		final Display display = new Display ();
		final Image image = new Image (display, 750, 750);
		GC gc1 = new GC (image);
		gc1.setBackground (display.getSystemColor (SWT.COLOR_GRAY));
		gc1.fillRectangle (image.getBounds ());
		gc1.dispose ();

		
		Shell shell = new Shell(display);
		shell.setBounds( 0 , 0, 1012 , 438 );
		final Canvas canvas = new Canvas (shell, SWT.NONE);
		canvas.setBounds (10, 10, 120, 125);
		canvas.addListener (SWT.Paint, new Listener () {
			public void handleEvent (Event event) {
				event.gc.drawImage (image, 0, 0);
				event.gc.drawString("Heading", 15 , 10, true);
				event.gc.drawString (Double.toString((Math.random()*360)), 10, 25, true);
				event.gc.drawString("Latitude", 15 , 45, true);
				event.gc.drawString (Double.toString((Math.random()*150)), 10, 60, true);
				event.gc.drawString("Longititude", 15 , 80, true);
				event.gc.drawString (Double.toString((Math.random()*130)), 10, 95, true);
			}
		});
		display.timerExec (INTERVAL, new Runnable () {
			public void run () {
				if (canvas.isDisposed ()) return;
				canvas.redraw (); // <-- bad, damages more than is needed
				GC gc = new GC (canvas);
				Point extent = gc.stringExtent (value + '0');
				gc.dispose ();
				canvas.redraw (10, 10, extent.x, extent.y, false);
				display.timerExec (INTERVAL, this);
			}
		});
		
		
		//latLabel
		shell.setText("RobOS2 Sensor Dashboard");
		
		
		
	
		final Image image1 = new Image (display, MAIN_WINDOW_X_BOUND, MAIN_WINDOW_Y_BOUND);
		GC gc = new GC (image1);
		gc.setBackground (display.getSystemColor (SWT.COLOR_GRAY));
		gc.fillRectangle (image1.getBounds ());
		gc.dispose ();	//Maintance Stuff

		
		//Create the canvas we will actually use to draw and update the arc
		final Canvas canvas1 = new Canvas (shell, SWT.NONE);
		//Make it the window dimensions
		canvas1.setBounds (0, 0, MAIN_WINDOW_X_BOUND, MAIN_WINDOW_Y_BOUND);
		canvas1.addListener (SWT.Paint, new Listener () {
			public void handleEvent (Event event) {
				//Draw a blank black arc
				event.gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
				event.gc.drawImage (image1, 0, 0);
				event.gc.fillArc(100 , 0, 800 , MAIN_WINDOW_Y_BOUND*2, 0, 180);
			}
		});
		
		//Update the canvas with new data from the LIDAR
		display.timerExec (INTERVAL, new Runnable () {
			public void run () {
				if (canvas1.isDisposed ()){
					return;
				}
				
				GC gc = new GC (canvas1);
				
				//Loop through the array of LIDAR data and write it to the screen.
				double lidarDistance;
				double lidarPercentage;
				int lidarMaxRange = 300; //LIDARMap.getMaxRange();
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
				gc.fillArc(100, 0, 800 , MAIN_WINDOW_Y_BOUND*2, 0, 180);
				
				for(int i = 0; i < 181; i++){
					
					//Get the "raw" data from the LIDAR
					lidarDistance = Math.random()* 300;//LIDARMap.getDistanceAtStep(i*2);

					//Convert it into a percentage
					lidarPercentage = 1-((lidarMaxRange - lidarDistance)/lidarMaxRange);
					
					if(lidarPercentage <= 0.10){
						//Set color to RED
						gc.setForeground(new Color(display, 220, 20, 60));
					} else if (lidarPercentage <= 0.20){
						//Set color to DARK ORANGE
						gc.setForeground(new Color(display, 205, 55, 0));
					} else if (lidarPercentage <= 0.30){
						//Set color to ORANGE
						gc.setForeground(new Color(display, 255, 128, 0));
					} else if (lidarPercentage <= 0.40){
						//Set color to DARK YELLOW
						gc.setForeground(new Color(display, 205, 173, 0));
					} else if (lidarPercentage <= 0.50){
						//Set color to YELLOW
						gc.setForeground(new Color(display, 238, 238, 0));
					} else if (lidarPercentage <= 0.60){
						//Set color to BRIGHT YELLOW
						gc.setForeground(new Color(display, 255, 255, 0));
					} else if (lidarPercentage <= 0.70){
						//Set color to DARK GREEN
						gc.setForeground(new Color(display, 0, 100, 0));
					} else if (lidarPercentage <= 0.80){
						//Set color to MEDIUM GREEN
						gc.setForeground(new Color(display, 84, 139, 84));
					} else if (lidarPercentage <= 0.90){
						//Set color to GREEN
						gc.setForeground(new Color(display, 0, 128, 0));
					} else {
						//Set color to BRIGHT GREEN
						gc.setForeground(new Color(display, 0, 255, 0));
					}
					//gc.setForeground(new Color(display , (int)(10 * lidarPercentage) , (int)(255 * lidarPercentage) , (int)(100 * lidarPercentage)));
					double xCord = 500 + (Math.cos(Math.toRadians(i))*(lidarPercentage * 400));
					double yCord = 400 - (Math.sin(Math.toRadians(i))*(lidarPercentage * 400));
					gc.setLineWidth(3);
					gc.drawLine( 500 , 400 , (int)(xCord) , (int)(yCord));
					
					}
				
				display.timerExec (INTERVAL, this);
			}
		});
		shell.open ();
		while (!shell.isDisposed ()){
			if (!display.readAndDispatch ()) display.sleep ();
		}
		image1.dispose ();
		display.dispose ();
	}
	
	@Override
	public void run() {
		//Needed for the interface only
	}
}

