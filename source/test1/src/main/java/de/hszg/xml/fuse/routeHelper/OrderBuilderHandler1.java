package de.hszg.xml.fuse.routeHelper;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OrderBuilderHandler1 {
	
	String user;

	private static Logger logger = LogManager.getLogger("OrderBuilderHandler1");
	
	public OrderBuilderHandler1(String id) {
		this.user = id;
	}

	public String build(List<PurchaseItem> itemList){
		
		String result = "<req:payment>\n";
		
		result += "<req:payment>" +
				"<req:personality>" +
				"    <req:firstname>Max</req:firstname>" +
				"    <req:lastname>Mustermann</req:lastname>" +
				"    <req:address>Am Hirschwinkel</req:address>" +
				"    <req:zipcode>02826</req:zipcode>" +
				"    <req:city>Görlitz</req:city>" +
				"</req:personality>" +
				"<req:billing>" +
				"    <req:accountnumber>058987453</req:accountnumber>" +
				"    <req:bankcode>080215648</req:bankcode>" +
				"</req:billing>" +
				"<req:objects>";
		
		String orderList = "";
		
		for(PurchaseItem item : itemList){
			orderList += "-" + item.getId() + ":" + item.getCount();
		}
		
		if(orderList.charAt(0) == '-')
			orderList = orderList.substring(1);
		
		result += orderList + "</req:objects></req:payment>";
		
		logger.info(result);
		
		return result;
		
	}

}