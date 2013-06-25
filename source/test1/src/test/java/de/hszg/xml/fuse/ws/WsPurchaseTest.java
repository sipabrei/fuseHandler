package de.hszg.xml.fuse.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebServiceRef;

import de.hszg.xml.fuse.services.OrderRequest;

public class WsPurchaseTest{
	@WebServiceRef(wsdlLocation="http://localhost:9090/order?wsdl")
	private static OrderRequest request;
	public static void main(String args[]){
		List<String> content = new ArrayList<String>();
		content.add("barbie1;3");
		request.order(content);		
	}

}
