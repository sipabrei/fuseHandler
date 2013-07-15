package de.hszg.xml.fuse.routeHelper;

import java.io.StringReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.hszg.xml.fuse.exist.ExistUser;
import de.hszg.xml.fuse.processor.Handler1ProcessorMain;

public class Handler1XMLProcessor implements Processor {	

	@Override
	public void process(Exchange exchange) throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document xml = builder.build(new StringReader(exchange.getIn().getBody(String.class)));
		PurchaseItems purchaseItems = PurchaseItems.getInstance();
		String name = xml.getRootElement().getChild("tns:order").getChild("tns:name").getValue();
		int count =  Integer.parseInt(xml.getRootElement().getChild("tns:order").getChild("tns:count").getValue());
		PurchaseItem item = new PurchaseItem(count, name);
		purchaseItems.addHandler1(item);

		

	}

}
