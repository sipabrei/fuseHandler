package de.hszg.xml.fuse.routeHelper;

import org.apache.camel.Exchange;

import de.hszg.xml.fuse.processor.Handler1ProcessorMain;

public class Handler1XMLProcessor extends Handler1ProcessorMain {
	private String xslUrl = "de/hszg/xml/fuse/xslt/PlueschtiereProduct.xsl";
	

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = exchange.getIn().getBody(String.class);
		String mainConvert = mainConvert(message,xslUrl);
		exchange.getOut().setBody(mainConvert);

	}

}
