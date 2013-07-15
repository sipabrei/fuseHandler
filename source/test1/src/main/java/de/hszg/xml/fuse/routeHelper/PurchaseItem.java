package de.hszg.xml.fuse.routeHelper;

public class PurchaseItem {
	private int count;
	private String id;
	public PurchaseItem(int count, String id) {
		this.setCount(count);
		this.setId(id);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
