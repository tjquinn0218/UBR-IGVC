package robOS2.xml.handler;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import robOS2.serial.Config;

public class HardwareHandler implements ContentHandler{
	static Logger log = Logger.getLogger(HardwareHandler.class.getName());
	private Config _cfg;
	private String _output;
	
	public HardwareHandler(Config cfg) {
		_cfg = cfg;
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
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//log.debug("Found " + qName);
		if(qName.equalsIgnoreCase("NAME")){
			_cfg.setName(_output);
			log.debug("\tNAME: " + _cfg.getName());
		} else if(qName.equalsIgnoreCase("PORT")){
			_cfg.setPort(_output);
			log.debug("\tPORT: " + _cfg.getPort());
		} else if(qName.equalsIgnoreCase("BAUD")){
			_cfg.setBaud(Integer.parseInt(_output));
			log.debug("\tBAUD: " + _cfg.getBaudRate());
		} else if(qName.equalsIgnoreCase("PARITY")){
			_cfg.setParity(Integer.parseInt(_output));
			log.debug("\tPARITY: " + _cfg.getParity());
		} else if(qName.equalsIgnoreCase("CONNECT")){
			if(_output.equalsIgnoreCase("TRUE")){
				_cfg.setConnect(true);
			} else if (_output.equalsIgnoreCase("FALSE")){
				_cfg.setConnect(false);
			} else {
				log.warn("Unsupported value for CONNECT given in the XML config file." +
						 " The device is defaulting to connecting.");
			}
		} else if(qName.equalsIgnoreCase("SENSOR")){
			_cfg.addSensor();
			log.debug("New sensor added to database");
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
