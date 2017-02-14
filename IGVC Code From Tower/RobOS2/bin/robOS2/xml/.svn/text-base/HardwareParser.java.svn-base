package robOS2.xml;

import java.io.IOException;
import org.apache.log4j.*;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import robOS2.serial.Config;
import robOS2.xml.handler.HardwareHandler;

public class HardwareParser implements XMLReader{ 
	static Logger log = Logger.getLogger(XMLReader.class.getName());
	
	private ContentHandler _handler;
	private XMLReader _reader;
	
	public HardwareParser(Config cfg) {
		_handler = new HardwareHandler(cfg);
		log.debug("Created a new XML Paraser with the " + _handler.toString() + " content handler.");
		try {
			_reader = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_reader.setContentHandler(_handler);
	}

	@Override
	public ContentHandler getContentHandler() {
		return _handler;
	}

	@Deprecated
	@Override
	public DTDHandler getDTDHandler() {
		return null;
	}

	@Deprecated
	@Override
	public EntityResolver getEntityResolver() {
		return null;
	}

	@Override
	public ErrorHandler getErrorHandler() {
		log.warn("No Error handler is defined for the parser!");
		return null;
	}

	@Deprecated
	@Override
	public boolean getFeature(String name) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		return false;
	}

	@Deprecated
	@Override
	public Object getProperty(String name) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		return null;
	}

	@Override
	public void parse(InputSource input) throws IOException, SAXException {
		_reader.parse(input);
	}

	@Override
	public void parse(String systemId) throws IOException, SAXException {
		_reader.parse(systemId);
	}

	@Override
	public void setContentHandler(ContentHandler handler) {
		log.info("Changing the XML Content Handler to: " + handler.toString());
		_handler = handler;
	}

	@Deprecated
	@Override
	public void setDTDHandler(DTDHandler handler) {
	}

	@Deprecated
	@Override
	public void setEntityResolver(EntityResolver resolver) {
	}

	@Deprecated
	@Override
	public void setErrorHandler(ErrorHandler handler) {
	}

	@Deprecated
	@Override
	public void setFeature(String name, boolean value)
			throws SAXNotRecognizedException, SAXNotSupportedException {
	}

	@Deprecated
	@Override
	public void setProperty(String name, Object value)
			throws SAXNotRecognizedException, SAXNotSupportedException {
	}

}
