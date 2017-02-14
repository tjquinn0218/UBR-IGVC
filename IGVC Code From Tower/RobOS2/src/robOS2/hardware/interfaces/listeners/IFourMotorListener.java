package robOS2.hardware.interfaces.listeners;

import gnu.io.SerialPortEventListener;

public interface IFourMotorListener extends SerialPortEventListener{
	public int getLastE1();

	public int getLastE2();
	
	public int getLastE3();
	
	public int getLastE4();
}
