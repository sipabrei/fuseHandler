package de.hszg.xml.fuse.exist;


public class ExistUser {
	private static ExistUser existUser = null;
	
	public static ExistUser getInstance(){
		if(existUser==null){
			existUser = new ExistUser();
		}
		return existUser;
	}
	
	private ExistUser() {
		// TODO Auto-generated constructor stub
	}
	public User getbyID(String id){
		User user = new User();
		user.setAddress("Am Hirschwinkel");
		user.setCity("goerlitz");
		user.setFirstname("max");
		user.setLastname("mustermann");
		user.setZipcode("02826");
		user.setId(id);
		return user;
	}
	

}
