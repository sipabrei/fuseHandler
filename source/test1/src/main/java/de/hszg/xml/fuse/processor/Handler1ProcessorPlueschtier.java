package de.hszg.xml.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.xerces.dom.DeferredElementNSImpl;

public class Handler1ProcessorPlueschtier extends Handler1ProcessorMain {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("processor");
		
		DeferredElementNSImpl doc = (DeferredElementNSImpl) exchange.getIn().getBody();
		System.out.println("ausgabe\n" + doc.toString());
		exchange.getOut().setBody(mainConvert(doc.toString(), 
				"de/hszg/xml/fuse/xslt/PlüschtiereProduct.xsl"));

	}

}
