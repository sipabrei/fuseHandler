package de.hszg.xml.fuse.exist;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Consumer;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointConfiguration;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.PollingConsumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultPollingEndpoint;
import org.xmldb.api.base.Collection;

public class ExistEndpoint extends DefaultPollingEndpoint {

	public ExistEndpoint(String uri, ExistComponent component, Collection collection) {
        super(uri, component);
        // this.collection = collection;
    }

	
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEndpointUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EndpointConfiguration getEndpointConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEndpointKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange createExchange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange createExchange(ExchangePattern pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange createExchange(Exchange exchange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CamelContext getCamelContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producer createProducer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consumer createConsumer(Processor processor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PollingConsumer createPollingConsumer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configureProperties(Map<String, Object> options) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCamelContext(CamelContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLenientProperties() {
		// TODO Auto-generated method stub
		return false;
	}

}
