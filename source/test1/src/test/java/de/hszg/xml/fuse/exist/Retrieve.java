package de.hszg.xml.fuse.exist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

@Ignore
public class Retrieve {

	private static String URI = "xmldb:exist://193.174.103.82:8080/exist/xmlrpc/db";
	private static String collection = "/test";
	private static String resource = "test.xml";
	
	private static String query = "//test[0]/text()";

	Collection col = null;
	
	@Before
	public void setUp() throws Exception {
		final String driver = "org.exist.xmldb.DatabaseImpl";

		// initialize database driver
		Class cl = Class.forName(driver);
		Database database = (Database) cl.newInstance();
		database.setProperty("create-database", "false");
		database.setProperty("ssl_enable", "true");
		DatabaseManager.registerDatabase(database);

	}

	@Test
	public void test() throws XMLDBException {
		col = DatabaseManager.getCollection(URI + collection);
		XPathQueryService xpqs = (XPathQueryService) col.getService(
				"XPathQueryService", "1.0");
		
		xpqs.setProperty("indent", "yes");
		ResourceSet result = xpqs.query(query);
		ResourceIterator i = result.getIterator();
		Resource res = i.nextResource();
		
		assertEquals("text", res.getContent());
	}

}
