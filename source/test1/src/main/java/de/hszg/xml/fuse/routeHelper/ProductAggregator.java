package de.hszg.xml.fuse.routeHelper;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ProductAggregator implements AggregationStrategy {


	private static Logger logger = LogManager.getLogger("ProductAggregator");
	
	
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		String oldMessage;
		
		if(oldExchange == null)
			oldMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
					"<products></products>";
		else
			oldMessage = oldExchange.getIn().getBody(String.class);
		String newMessage = newExchange.getIn().getBody(String.class);
		
		if(newMessage.indexOf('[')==0)
			return oldExchange;
		
		SAXBuilder builder = new SAXBuilder();
		Document oldDoc = null;
		Document newDoc = null;
		
		try {
			oldDoc = builder.build(new StringReader(oldMessage));
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(oldDoc.getRootElement().getName().equals("product")){
			Document tempDoc = new Document( new Element("products") );
			tempDoc.getRootElement().addContent(oldDoc.getRootElement());
			oldDoc = tempDoc;
		}

		logger.debug(oldMessage);
		
//		newMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + newMessage;

		logger.debug("neu:" + newMessage);
		try {
			newDoc = builder.build(new StringReader(newMessage));
		} catch (Exception e) {
			logger.info(newMessage);
			e.printStackTrace();
			System.exit(1);
		}
		
		if(newDoc.getRootElement().getName().equals("products")){
			for(Object elemObj : newDoc.getRootElement().getChildren()){
				Element elem = (Element) ((Element) elemObj).clone();
				elem.detach();
				oldDoc.getRootElement().addContent(elem);
			}
		} else
			oldDoc.getRootElement().addContent(newDoc.getRootElement().detach());
		
		XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
		
		String outputXML = xmlOut.outputString(oldDoc);
		
		newExchange.getOut().setBody(outputXML);
		
		return newExchange;
	}

}
