package com.app.daos;

import com.app.pojos.Person;

public interface PersonDaoIntf {

	public void editProfile(int empId,String address, int contactNo,String email);
	public void changePassword(int empId,String pwd);
	public Person getDesignation(String email, String password);
	
	
	
}
