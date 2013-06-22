package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;

public class Handler1ProcessorBarbie extends Handler1ProcessorMain {
	private String xslUrl = "de/hszg/xml/fuse/xslt/MainProduct.xsl";
	

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		exchange.getOut().setBody(mainConvert(message, 
				xslUrl));

	}

}