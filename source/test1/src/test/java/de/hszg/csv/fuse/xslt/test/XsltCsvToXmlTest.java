package de.hszg.csv.fuse.xslt.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamSource;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;
import org.junit.Test;

public class XsltCsvToXmlTest {

	@Test
	public void csvToXmlTest() throws IOException, TransformerFactoryConfigurationError, JDOMException, TransformerException {
		org.jdom.Document doc = new SAXBuilder()
				.build(ClassLoader.getSystemResource("testData/handler2/searchResponce1.xml").toString() );
		JDOMSource     xmlFile    = new JDOMSource( doc );
		JDOMResult result = new JDOMResult();
		Transformer transformer =
		   TransformerFactory.newInstance().newTransformer(
		      new StreamSource(ClassLoader.getSystemResource("de/hszg/xml/fuse/xslt/csvToXml.xsl").toString()) );
		transformer.transform( xmlFile, result );
		XMLOutputter xmlOutputter = new XMLOutputter();
		  //xmlOutputter.output( doc, System.out );
		xmlOutputter.output( result.getDocument(), System.out );

	}
}
