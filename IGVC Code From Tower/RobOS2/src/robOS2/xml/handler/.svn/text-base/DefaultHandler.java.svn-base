package robOS2.xml.handler;

import org.apache.log4j.*;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class DefaultHandler implements ContentHandler{
	static Logger log = Logger.getLogger(DefaultHandler.class.getName());
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		log.debug("Parsing in characters from a XML File.");
	}

	@Override
	public void endDocument() throws SAXException {
		log.info("End of XML Document reached.");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
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
