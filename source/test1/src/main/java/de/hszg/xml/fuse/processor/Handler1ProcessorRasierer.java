package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;

public class Handler1ProcessorRasierer extends Handler1ProcessorMain {
	private String xslUrl = "de/hszg/xml/fuse/xslt/RasiererProduct.xsl";
	

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		exchange.getOut().setBody(mainConvert(message, 
				xslUrl));

	}

}
