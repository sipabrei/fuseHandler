package de.hszg.xml.fuse.routeHelper;

import java.io.IOException;
import java.io.StringReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLOrderProcessor implements Processor{

	private static Logger logger = LogManager.getLogger("XMLOrderProcessor");
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		Document xml = null;
		
		SAXBuilder builder = new SAXBuilder();
		
		
		try {
			logger.info("text");
			xml = builder.build(new StringReader(exchange.getIn().getBody(String.class)));
		} catch (IOException e) {
			// TODO Auto-generated catch block

			logger.info("e2");
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			logger.info("e1");
			e.printStackTrace();
		}
		
		XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
		
		String outputXML = xmlOut.outputString(xml);
		
		exchange.getOut().setBody(xml);
		
		logger.info(outputXML);
		
		
	}

	
	
}
