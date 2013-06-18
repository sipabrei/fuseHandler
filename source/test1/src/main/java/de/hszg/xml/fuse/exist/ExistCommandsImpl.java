package de.hszg.xml.fuse.exist;

import org.dom4j.Document;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;

public class ExistCommandsImpl implements ExistCommands {

	@Override
	public boolean safeXML(Document xml, String resource) {
		ExistDB database = null;
		try {
			database = ExistDB.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExistException();
		}
		
		String collection = resource.substring(0, resource.lastIndexOf("/") - 1);
		String fileName = resource.substring(resource.lastIndexOf("/") + 1);
		
		try {
			getOrCreateCollection(collection, database, 0);
		} catch (XMLDBException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	private static Collection getOrCreateCollection(String collectionUri, ExistDB db,
			int pathSegmentOffset) throws XMLDBException {

		Collection col = db.getCollection(collectionUri);
		if (col == null) {
			if (collectionUri.startsWith("/")) {
				collectionUri = collectionUri.substring(1);
			}
			String pathSegments[] = collectionUri.split("/");
			if (pathSegments.length > 0) {
				StringBuilder path = new StringBuilder();
				for (int i = 0; i <= pathSegmentOffset; i++) {
					path.append("/" + pathSegments[i]);
				}
				Collection start = db.getCollection(path.toString());
				if (start == null) {
					// collection does not exist, so create
					String parentPath = path
							.substring(0, path.lastIndexOf("/"));
					Collection parent = db.getCollection(parentPath);
					CollectionManagementService mgt = (CollectionManagementService) parent
							.getService("CollectionManagementService", "1.0");
					col = mgt.createCollection(pathSegments[pathSegmentOffset]);
					col.close();
					parent.close();
				} else {
					start.close();
				}
			}
			return getOrCreateCollection(collectionUri, db, ++pathSegmentOffset);
		} else {
			return col;
		}
	}
	
}
