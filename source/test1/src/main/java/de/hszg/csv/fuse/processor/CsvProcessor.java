package de.hszg.csv.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CsvProcessor implements Processor {
	private String xmlFileName = "src/test/resources/testData/handler2/searchResponce1.xml";
	CsvToXmlParser parser = new CsvToXmlParser();
	@Override
	public void process(Exchange exchange) throws Exception {
		String exchangeBody = exchange.getIn().getBody().toString();
		
		parser.convertFile(exchangeBody, xmlFileName, ",");
	}
}
