package com.app.services;

public interface PersonServiceIntf {

	public String getPojo(String email, String password);
	public void logout();
	public void editProfile(int empId,String address, int contactNo,String email);
}
