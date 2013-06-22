package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.xerces.dom.DeferredElementNSImpl;

public class Handler1ProcessorPlueschtier extends Handler1ProcessorMain {
	private String xslUrl = "de/hszg/xml/fuse/xslt/PlueschtiereProduct.xsl";
	

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		exchange.getOut().setBody(mainConvert(message, 
				xslUrl));

	}

}
