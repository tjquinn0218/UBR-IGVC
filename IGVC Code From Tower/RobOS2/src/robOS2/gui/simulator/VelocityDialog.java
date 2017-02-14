package robOS2.gui.simulator;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import robOS2.simulator.Engine;

/**
 * Velocity Dialog box to allow the user to set a constant velocity
 * for use by the simulator engine.
 * 
 * @author dbaratta
 *
 */
public class VelocityDialog {
	static Logger log = Logger.getLogger(VelocityDialog.class.getName());
	
	public VelocityDialog(Shell parentShell, final Engine engine) {
		//Create a new dialog box & bind it to the parent shell
		final Shell dialog = new Shell (parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("Velocity");
		dialog.setLayout (new RowLayout ());
		
		Label currVel = new Label(dialog, SWT.NONE);
		currVel.setText("Current Velocity: " + engine.getVelocity() + " m/s    ");
		
		//Create a label stating what we are looking for
		Label label = new Label(dialog, SWT.NONE);
		label.setText("Desired Velocity: ");
		
		//Text input area
		final Text text = new Text(dialog, SWT.BORDER);
		
		//Don't forget the units!!!
		Label ms = new Label(dialog, SWT.NONE);
		ms.setText("m/s");
		
		//OK & Cancel Buttons
		final Button ok = new Button (dialog, SWT.PUSH);
		ok.setText ("OK");
		Button cancel = new Button (dialog, SWT.PUSH);
		cancel.setText ("Cancel");
		
		//Button Listener
		Listener listener =new Listener () {
			public void handleEvent (Event event) {
				if(event.widget == ok){
					//OK button clicked. Commit new velocity and close dialog.
					try{
						double vel = Double.parseDouble(text.getText());
						engine.setVelocity(vel);
					} catch (Exception e){
						log.error("Could Not Set the Velocity. Please try and set it again");
					}
				}
				
				//Close the dialog box
				dialog.close ();
			}
		};
		
		//Add the listeners
		ok.addListener (SWT.Selection, listener);
		cancel.addListener (SWT.Selection, listener);
		
		//Make the dialog the correct size and open it
		dialog.pack ();
		dialog.open ();

	}
}
