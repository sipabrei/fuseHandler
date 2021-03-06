package de.hszg.xml.fuse.routeHelper;

import java.io.StringReader;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.hszg.xml.fuse.exist.ExistUser;
import de.hszg.xml.fuse.processor.Handler1ProcessorMain;

public class PostXMLProcessor implements Processor {	
	private static Logger logger = LogManager.getLogger("PostXMLProcessor");

	@Override
	public void process(Exchange exchange) throws Exception {
		PurchaseItems instance = PurchaseItems.getInstance();
		List<PurchaseItem> handler1 = instance.getHandler1();
		List<PurchaseItem> handler2 = instance.getHandler2();
		String orderListHandler2 = "";		
		logger.info("user:"+instance.getUser().getId());
		logger.info("handler1");
		for(PurchaseItem item : handler1){
			logger.info(item.getId()+" "+item.getCount());
		}
		
		OrderBuilderHandler1 handler1Builder = new OrderBuilderHandler1(instance.getUser().getId());
		String requestHandler1 = handler1Builder.build(handler1);
		
		exchange.getOut().setHeader("handler1Order", requestHandler1);
		
		logger.info("handler2");
		for(PurchaseItem item : handler2){
			logger.info(item.getId()+" "+item.getCount());
			orderListHandler2 += "/kaeufer1/"+item.getId()+"/"+item.getCount();
		}		
		exchange.getOut().setHeader("handler2Order", orderListHandler2);
	}

}
