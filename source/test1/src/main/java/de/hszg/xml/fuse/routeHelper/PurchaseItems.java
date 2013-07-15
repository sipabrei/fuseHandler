package de.hszg.xml.fuse.routeHelper;

import java.util.ArrayList;
import java.util.List;

import de.hszg.xml.fuse.exist.User;

public class PurchaseItems {
	private static PurchaseItems items=null;
	private User user = null;
	private List<PurchaseItem> handler1;
	private List<PurchaseItem> handler2;
	
	private PurchaseItems() {
		
	}
	public static PurchaseItems getInstance(){
		if(items==null){
			items = new PurchaseItems();
		}
		return items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.handler1 = new ArrayList<PurchaseItem>();
		this.handler2 = new ArrayList<PurchaseItem>();

		this.user = user;
	}
	public List<PurchaseItem> getHandler2() {
		return handler2;
	}
	public void addHandler2(PurchaseItem item) {
		this.handler2.add(item);
	}
	public List<PurchaseItem> getHandler1() {
		return handler1;
	}
	public void addHandler1(PurchaseItem item) {
		this.handler1.add(item);
	}

}
