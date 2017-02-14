package robOS2.gui;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import robOS2.gui.simulator.ResolutionDialog;
import robOS2.gui.simulator.VelocityDialog;
import robOS2.navigation.SimpleAvoidance;
import robOS2.simulator.Engine;
import robOS2.simulator.InputParser;

public class Simulator {
	static Logger log = Logger.getLogger(Simulator.class.getName());
	
	//Simulator name and version
	private String _name = "RobOS2 Simulator";
	private String _version = "0.1.0";
	
	//Persistent link to the engine
	Engine _engine = new Engine(new SimpleAvoidance());

	public Simulator() {
		
		//Create the window and the shell process to run the window
		final Display display = new Display();
		final Shell shell = new Shell(display);
		
		//Set the application name and version for the process
		Display.setAppName(_name);
		Display.setAppVersion(_version);
		
		//Set the app title bar
		shell.setText(_name);
		
		//Change the background color to black
		shell.setBackground(new Color(display, new RGB(0, 0, 0)));
		shell.setBounds(0, 0, 600, 600);

		//Add a new "robot" to the simulator. Start this off centered in the
		//display, as that is probably how it will start in the "real world"
		shell.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent event) {
				event.gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
				
				int centerX = shell.getClientArea().width / 2;
				int centerY = shell.getClientArea().height / 2;
				
				int robotWidth = 26;
				int robotHeight = 40;
				
				event.gc.fillRectangle(centerX - (robotWidth / 2),
									   centerY + (robotHeight / 2),
									   robotWidth,
									   robotHeight);
			}
		});
		
		//Create a new ToolBar with start and stop buttons
		ToolBar bar = new ToolBar (shell, SWT.NONE);
		for (int i = 0; i < 5; i++) {
			ToolItem item = new ToolItem (bar, SWT.PUSH);
			if (i == 0){
				item.setText("Start");
				item.addListener(SWT.Selection, new Listener() {
					
					@Override
					public void handleEvent(Event arg0) {
						_engine.start();
					}
				});
			} else if (i == 1){
				item.setText("Stop");
				item.addListener(SWT.Selection, new Listener() {
					
					@Override
					public void handleEvent(Event arg0) {
						_engine.stop();
					}
				});
			} else if (i == 2){
				item.setText("Open Config");
				item.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent arg0) {
						log.debug("widget selected");
						FileDialog fd = new FileDialog(shell, SWT.NULL);
						String[] filters = {"*.cfg"};
						fd.setFilterExtensions(filters);
						String path = fd.open();
						log.info("--> Path is: " + path);
						new InputParser(path);
					};
					
				});
			} else if (i == 3){
				item.setText("Velocity");
				item.addListener(SWT.Selection, new Listener() {
					//Open a dialog box to allow the user to enter a velocity
					@Override
					public void handleEvent(Event arg0) {
						new VelocityDialog(shell, _engine);
					}
				});
			} else if (i == 4){
				item.setText("Resolution");
				item.addListener(SWT.Selection, new Listener() {
					//Open a dialog box to allow the user to set the resolution of the map
					@Override
					public void handleEvent(Event arg0) {
						new ResolutionDialog(shell, _engine);
					}
				});
			}
		}
		bar.setBounds(0, 0, display.getBounds().width, 27);

		shell.open();
		
		while (!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
	
}
