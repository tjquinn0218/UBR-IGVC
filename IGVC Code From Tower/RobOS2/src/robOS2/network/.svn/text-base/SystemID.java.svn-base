package robOS2.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import robOS2.utility.SystemInformation;

/**
 * Network class for providing unique system identification credential's to
 * remote clients. This can also be used in the local software instead of over
 * the network.
 * 
 * @author dbaratta
 */
public class SystemID {
	
	/**
	 * Returns the CURRENT "local" IP address of the system.  This does not use
	 * a IP look-up service to provide a public address, unless one was
	 * assigned to you by your ISP.
	 * @return - Current platform IP address
	 * @throws UnknownHostException
	 */
	public static String getSystemIPAddress() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	/**
	 * Returns the current system host-name. This should not change as frequently
	 * as the IP address. Also, this is not a DNS name, so refer to this machine
	 * by its IP address for remote operations. 
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getSystemHostname() throws UnknownHostException {
		return InetAddress.getLocalHost().getCanonicalHostName();
	}
	
	/**
	 * Returns the name of the currently registered platform. (e.g. Big Blue)
	 * @return
	 */
	public static String getPlatformName(){
		return SystemInformation.getPlatformName();
	}
	
	/**
	 * Returns the current version number of RobOS2 that is running.
	 * @return
	 */
	public static String getSoftwareVersion(){
		return SystemInformation.getSoftwareVersion();
	}
}
