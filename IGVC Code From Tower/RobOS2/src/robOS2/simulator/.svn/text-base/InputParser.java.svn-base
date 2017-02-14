package robOS2.simulator;

import java.io.File;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Parses in a simple text configuration file used for simulator configuration.
 * This file contains obstacles that our platform must avoid.
 * 
 * @author dbaratta
 *
 */
public class InputParser {
	static Logger log = Logger.getLogger(InputParser.class.getName());
	
	private Scanner _inFile;
	
	public InputParser(String filePath) {
		log.info("Opening simulator configuration file at: " + filePath);
		
		try {
			File file = new File(filePath);
			_inFile = new Scanner(file);
			
			log.info("--> Parsing file.");
			this.parse();
			log.info("--> Parsing completed.");
		} catch (Exception e) {
			log.error("There was an error parsing the configuration file.");
		}
	}
	
	private void parse(){
		String nextInput;
		Scanner stringScanner;
		@SuppressWarnings("unused")
		int x;
		@SuppressWarnings("unused")
		int y; 
		while(_inFile.hasNextLine()){
			nextInput = _inFile.nextLine();
			if(nextInput.startsWith("#")){
				//Comment in input file, simply ignore and move on
				log.info("comment");
			} else {
				//Useful configuration info, assume its an obstacle and add it
				//to the map.
				log.info("data");
				stringScanner = new Scanner(nextInput);
				x = stringScanner.nextInt();
				y = stringScanner.nextInt();
			}
			//_inFile.nextLine();
		}
	}

}
