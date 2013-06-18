package de.hszg.xml.fuse.processor;

import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

public class XsltURIResolver implements URIResolver {
public XsltURIResolver() {
	// TODO Auto-generated constructor stub
}
    @Override
    public Source resolve(String href, String base) throws TransformerException {
              InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("de/hszg/xml/fuse/xslt/" + href);
              return new StreamSource(inputStream);
    }
}