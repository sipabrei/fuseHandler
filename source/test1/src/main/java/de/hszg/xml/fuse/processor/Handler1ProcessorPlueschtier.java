package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.xerces.dom.DeferredElementNSImpl;

public class Handler1ProcessorPlueschtier extends Handler1ProcessorMain {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("processor");
		
//		DeferredElementNSImpl doc = (DeferredElementNSImpl) exchange.getIn().getBody();
//		System.out.println("ausgabe\n" + doc.toString());
		String message = exchange.getIn().getBody(String.class);
		exchange.getOut().setBody(mainConvert(message, 
				"de/hszg/xml/fuse/xslt/PlueschtiereProduct.xsl"));

	}

}
