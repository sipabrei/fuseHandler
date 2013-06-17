package de.hszg.xml.fuse.exist;

import java.util.Map;


import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

public class ExistComponent extends DefaultComponent {

	private static Logger logger = LogManager.getLogger("ExistComponent");
	private String driver = "org.exist.xmldb.DatabaseImpl";
	
    private Database database;
	private String username;
	private String password;

	@Override
	protected Endpoint createEndpoint(String uri, String remaining,
			Map<String, Object> parameters) throws Exception {
		
		if(database==null){

			Class cl = Class.forName(driver);
			database = (Database) cl.newInstance();
			database.setProperty("create-database", "false");
			DatabaseManager.registerDatabase(database);
			logger.debug("new Database created: " + database.toString());
		}
		
		Collection collection = database.getCollection(uri, username, password);
		
		logger.debug("return new ExistEndpoint");
		return new ExistEndpoint(uri, this, collection);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}
