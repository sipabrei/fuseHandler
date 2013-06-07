package de.mariospitze.fuse.tests.test1;

import java.util.Date;

import javax.xml.xpath.XPathFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.xml.XPathBuilder;

public class SearchReader implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String message = exchange.getIn().getBody(String.class);
		
		XPathFactory fac = new net.sf.saxon.xpath.XPathFactoryImpl();

		// create a builder to evaluate the xpath using the saxon factory
		XPathBuilder builder = XPathBuilder.xpath("/search/term/text()").factory(fac);

		// evaluate as a String result
		String searchTerm = builder.evaluate(exchange.getContext(), message);
		
		exchange.getOut().setHeader("term", searchTerm);
		exchange.getOut().setHeader("date", new Date().toGMTString());

	}

}
