package de.hszg.xml.fuse.processor;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;

public abstract class Handler1ProcessorMain implements Processor {

	protected String mainConvert(String oldXML, String resource) throws JDOMException, IOException, TransformerFactoryConfigurationError, TransformerException {		
		org.jdom.Document doc = new SAXBuilder().build(new StringReader(oldXML));
		JDOMSource xmlFile = new JDOMSource(doc);
		JDOMResult result = new JDOMResult();
		this.getClass().getClassLoader();
		TransformerFactory newInstance = TransformerFactory.newInstance();
		newInstance.setURIResolver(new XsltURIResolver());
		Transformer transformer =
				   newInstance.newTransformer(
				      new StreamSource(this.getClass().getClassLoader().getResourceAsStream(resource)));
		transformer.transform(xmlFile, result);
		XMLOutputter xmlOutputter = new XMLOutputter();
		xmlOutputter.output(result.getDocument(), System.out);
		return result.getDocument().toString();
	}

}
