package robOS2.utility;

/**
 * Maintains identification information for the current system based on
 * an input XML file.
 * 
 * @author dbaratta
 */
public class SystemInformation {
	private static String PLATFORM_NAME = "NO_ID";
	private static String SOFTWARE_VERSION = "NO_VERSION";
	
	
	/**
	 * Sets the current platform name. (e.g. Big Blue)
	 * @param name
	 */
	public static void setPlatformName(String name){
		PLATFORM_NAME = name;
	}
	
	/**
	 * Returns the current platform name. If no name has been set
	 * NO_ID will be returned.
	 * @return
	 */
	public static String getPlatformName(){
		return PLATFORM_NAME;
	}
	
	/**
	 * Sets the current software version running.
	 * @param version
	 */
	public static void setSoftwareVersion(String version){
		SOFTWARE_VERSION = version;
	}
	
	/**
	 * Returns the current software version. If no version has been set
	 * NO_VERSION will be returned. 
	 * @return
	 */
	public static String getSoftwareVersion(){
		return SOFTWARE_VERSION;
	}
}
