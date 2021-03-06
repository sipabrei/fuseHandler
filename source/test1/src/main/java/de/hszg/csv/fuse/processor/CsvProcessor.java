package de.hszg.csv.fuse.processor;

import java.io.FileReader;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;

import de.hszg.xml.fuse.processor.XsltURIResolver;

public class CsvProcessor implements Processor {
	private String xmlFileName = "src/data/handler2/searchResponce1.xml";
	private String xslUrl = "de/hszg/xml/fuse/xslt/csvToXml.xsl";
	private CsvToXmlParser parser = new CsvToXmlParser();

	@Override
	public void process(Exchange exchange) throws Exception {
		String exchangeBody = exchange.getIn().getBody(String.class);
		System.out.println("TESTBODY"+exchangeBody);
		parser.convertFile(exchangeBody, xmlFileName, ";".charAt(0));
		org.jdom.Document doc = new SAXBuilder().build(new FileReader(
				xmlFileName));
		JDOMSource xmlFile = new JDOMSource(doc);
		JDOMResult result = new JDOMResult();
		this.getClass().getClassLoader();
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		tranFactory.setURIResolver(new XsltURIResolver());
		Transformer aTransformer = tranFactory.newTransformer(new StreamSource(
				this.getClass().getClassLoader().getResourceAsStream(xslUrl)));
		aTransformer.transform(xmlFile, result);

		XMLOutputter xmlOutputter = new XMLOutputter();
		exchange.getOut().setBody(xmlOutputter.outputString(result.getDocument()));
	}
}

/*
 *
 * 
 */
