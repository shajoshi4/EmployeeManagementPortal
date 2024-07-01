package com.app.daos;

//import javax.persistence.DiscriminatorValue;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Person;

@Repository
public class PersonDao implements PersonDaoIntf {

	@Autowired
	private SessionFactory sf;
	@Override
	public void editProfile(int empId, String address, int contactNo, String email) {
		Person p=sf.getCurrentSession().get(Person.class, empId);
		p.setAddress(address);
		p.setContactNo(contactNo);
		p.setEmail(email);
	}

	@Override
	public void changePassword(int empId, String pwd) {
		Person p=sf.getCurrentSession().get(Person.class,empId);
		p.setPassword(pwd);
	}

	@Override
	public Person getDesignation(String email, String password) {
		Person p=sf.getCurrentSession().createQuery("select p from Person p where p.email=:em and p.password=:pass",Person.class).setParameter("em", email).setParameter("pass",password).getSingleResult();
		return p;

	}

	

}
