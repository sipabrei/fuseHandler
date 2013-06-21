package de.hszg.xml.fuse.processor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.w3c.dom.Document;

public class Handler1ContentSeperator implements Processor {

	private static Logger logger = LogManager.getLogger("Handler1ContentSeperator");
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		String message = exchange.getIn().getBody(String.class);

		Message outMessage = exchange.getOut();
		
		String group = getXPathContent(message, "/ns1:result/ns1:maingroup/@name", exchange);
		String subGroup = getXPathContent(message, "/ns1:result/ns1:maingroup/ns1:subgroup/@name", exchange);
		String id = getXPathContent(message, "/ns1:result/ns1:maingroup/ns1:subgroup/ns1:product/@id", exchange);
		String description = getXPathContent(message, "/ns1:result/ns1:maingroup/ns1:subgroup/ns1:product/ns1:description", exchange);

		logger.info(group + " : " + subGroup + " : " + id);

		outMessage.setHeader("group", group);
		outMessage.setHeader("subGroup", subGroup);
		outMessage.setHeader("id", id);
		outMessage.setHeader("description", description);
		
	}
	
	private String getXPathContent(String message, String xPath, Exchange exchange){

		
/*		ByteArrayInputStream in = new ByteArrayInputStream( message.getBytes() );  
		Document document = builder.parse( in );
		        
		System.out.println( document.getFirstChild().getNodeName() );
		        
		XPath x = XPathFactory.newInstance().newXPath();
		return res = x.evaluate( "/LocalConfiguration/gui/splash/@show/text()", document );*/
		
		XPathFactory fac = new net.sf.saxon.xpath.XPathFactoryImpl();

		// create a builder to evaluate the xpath using the saxon factory
		XPathBuilder builder = XPathBuilder.xpath(xPath).factory(fac);
		
		builder.namespace("ns1", "http://xml.netbeans.org/schema/response_search");
		
		// evaluate as a String result
		return builder.evaluate(exchange.getContext(), message);
	}

}
