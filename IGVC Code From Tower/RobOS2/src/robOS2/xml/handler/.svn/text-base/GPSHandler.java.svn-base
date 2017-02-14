package robOS2.xml.handler;

import org.apache.log4j.*;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import robOS2.gps.Waypoint;
import robOS2.gps.WaypointManager;

public class GPSHandler implements ContentHandler{
	static Logger log = Logger.getLogger(GPSHandler.class.getName());
	private String _output;
	private Waypoint _wpt;
	
	public GPSHandler() {
		_wpt = new Waypoint();
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		_output = "";
		for (int i = start; i < start + length; i++) {
		    switch (ch[i]) {
		    	case '\\':
		    		//Garbage data we don't care about...
		       		break;
		    
		    	case '"':
		    		//Garbage data we don't care about...
		    		break;
		    	
		    	case '\n':
		    		//Garbage data we don't care about...
		    		break;
		    		
		    	case '\r':
		    		//Garbage data we don't care about...
		    		break;
		    
		    	case '\t':
		    		//Garbage data we don't care about...
		    		break;
		    
		    	default:
		    		//Data is the real deal, get the characters and make them into a
		    		//string that can be output'd to the screen / variable
		    		_output = _output + ch[i];
		    		break;
		    }
		}
	}

	@Override
	public void endDocument() throws SAXException {
		log.info("End of XML Document reached.");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("WAYPOINT")){
			WaypointManager.addExistingWaypoint(_wpt);
			_wpt = new Waypoint();
		} else if (qName.equalsIgnoreCase("NAME")){
			_wpt.setName(_output);
		} else if (qName.equalsIgnoreCase("LATITUDE")){
			_wpt.setLatitude(Double.parseDouble(_output));
		} else if (qName.equalsIgnoreCase("LONGITUDE")){
			_wpt.setLongitude(Double.parseDouble(_output));
		} else if(qName.equalsIgnoreCase("RobOS2_Config")){
			//End of config file, do nothing for now.
		} else{
			log.error("A unsupported parameter was in the GPS XML configuration file.");
		}
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	@Override
	public void setDocumentLocator(Locator locator) {
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
	}

	@Override
	public void startDocument() throws SAXException {
		log.info("Parsing a new XML Document.");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
	}

}
