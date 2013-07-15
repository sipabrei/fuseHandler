package de.hszg.xml.fuse.routeHelper;

import java.io.StringReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.hszg.xml.fuse.exist.ExistUser;
import de.hszg.xml.fuse.processor.Handler1ProcessorMain;

public class Handler1XMLProcessor implements Processor {	
	private static Logger logger = LogManager.getLogger("Handler1XMLProcessor");

	@Override
	public void process(Exchange exchange) throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document xml = builder.build(new StringReader(exchange.getIn().getBody(String.class)));
		PurchaseItems purchaseItems = PurchaseItems.getInstance();
		Namespace namespace = Namespace.getNamespace("tns", "http://www.example.org/OrderRequestSchema");
		String name = xml.getRootElement().getChild("name",namespace).getValue();
		int count =  Integer.parseInt(xml.getRootElement().getChild("count",namespace).getValue());
		PurchaseItem item = new PurchaseItem(count, name);
		purchaseItems.addHandler1(item);

		

	}

}
