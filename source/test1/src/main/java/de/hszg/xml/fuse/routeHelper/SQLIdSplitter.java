package de.hszg.xml.fuse.routeHelper;

import java.util.ArrayList;
import java.util.List;

public class SQLIdSplitter {
	/**
	 * The split body method returns something that is iteratable such as a
	 * java.util.List.
	 * 
	 * @param body
	 *            the payload of the incoming message
	 * @return a list containing each part splitted
	 */
	public List<String> splitBody(String body) {

		List<String> answer = new ArrayList<String>();
		body = body.substring(1, body.length() - 1);
		String[] parts = body.split(",");
		for (String part : parts) {
			part = part.substring(part.indexOf("=") + 1, part.length() - 1);
			answer.add(part);
		}
		return answer;
	}
}
