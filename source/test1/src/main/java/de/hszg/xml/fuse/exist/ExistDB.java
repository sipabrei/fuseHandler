package de.hszg.xml.fuse.exist;

import java.io.InputStream;
import java.util.Properties;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;

public class ExistDB {

	private static ExistDB instance;
	private static String URI = "xmldb:exist://193.174.103.82:8080/exist/xmlrpc/db";
	final String driver = "org.exist.xmldb.DatabaseImpl";

	private String user = "";
	private String password = "";

	Database database = null;

	public static ExistDB getInstance() throws Exception {
		if (instance == null)
			instance = new ExistDB();
		return instance;
	}

	private ExistDB() throws Exception {
		Class cl = Class.forName(driver);
		database = (Database) cl.newInstance();
		database.setProperty("create-database", "false");
		DatabaseManager.registerDatabase(database);

		InputStream in = this.getClass().getResourceAsStream(
				"de/hszg/xml/fuse/accounts/exist.properties");

		Properties configProp = new Properties();
		configProp.load(in);
		user = configProp.getProperty("exist.user");
		password = configProp.getProperty("exist.password");

	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Collection getCollection(String collectionUri) throws XMLDBException {
		return database.getCollection(collectionUri, user, password);
	}

}
