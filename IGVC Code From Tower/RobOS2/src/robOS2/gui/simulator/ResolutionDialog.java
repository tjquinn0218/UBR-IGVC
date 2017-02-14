package robOS2.gui.simulator;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import robOS2.simulator.Engine;

public class ResolutionDialog {
	static Logger log = Logger.getLogger(VelocityDialog.class.getName());
	
	public ResolutionDialog(Shell parentShell, final Engine engine) {
		//Create a new dialog box & bind it to the parent shell
		final Shell dialog = new Shell (parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setText("Simulator Resolution");
		dialog.setLayout (new RowLayout ());
		
		Label currVel = new Label(dialog, SWT.NONE);
		currVel.setText("Current Resolution: " + engine.getResolution() + " cm    ");
		
		//Create a label stating what we are looking for
		Label label = new Label(dialog, SWT.NONE);
		label.setText("Desired Resolution: ");
		
		//Text input area
		final Text text = new Text(dialog, SWT.BORDER);
		
		//Don't forget the units!!!
		Label ms = new Label(dialog, SWT.NONE);
		ms.setText("cm");
		
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
						int res = Integer.parseInt(text.getText());
						engine.setResolution(res);
					} catch (Exception e){
						log.error("Could Not Set the Resolution. Please try and set it again");
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
