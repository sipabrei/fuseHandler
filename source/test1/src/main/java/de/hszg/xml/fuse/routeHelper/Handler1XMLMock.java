package de.hszg.xml.fuse.routeHelper;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class Handler1XMLMock implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ns1:root xmlns:ns1=\"http://xml.netbeans.org/schema/response_search\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://xml.netbeans.org/schema/response_search response_search.xsd\">" +
				"<ns1:results><ns1:result><ns1:maingroup name=\"Spielwaren\"><ns1:subgroup name=\"Plüschtiere\">" +
				"<ns1:product id=\"" + exchange.getIn().getBody(String.class) + "\"><ns1:pic/><ns1:price>5.99</ns1:price>" +
				"<ns1:description>TY 38046 - Beanie Ballz Lilac Ball - Hase Plüschtiere,violett</ns1:description><ns1:quantity>44</ns1:quantity><ns1:attributes/></ns1:product></ns1:subgroup></ns1:maingroup></ns1:result></ns1:results></ns1:root>");
	}

}
