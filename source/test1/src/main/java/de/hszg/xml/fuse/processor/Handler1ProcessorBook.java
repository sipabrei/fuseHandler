package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;

public class Handler1ProcessorBook extends Handler1ProcessorMain {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.setOut(exchange.getIn());
		DeferredElementNSImpl body = (DeferredElementNSImpl) exchange.getIn().getBody();
		
		System.out.println("Buch: " + body.getTextContent());
	}

}
