package com.app.services;

import javax.persistence.DiscriminatorValue;
import javax.servlet.http.HttpSession;

import org.apache.log4j.net.SyslogAppender;
//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.app.daos.EmployeeDaoIntf;
//import com.app.daos.ManagerDaoIntf;
import com.app.daos.PersonDaoIntf;
import com.app.pojos.Employee;
import com.app.pojos.Manager;
import com.app.pojos.Person;

@Service
@Transactional
public class PersonService implements PersonServiceIntf {

	@Autowired
	private PersonDaoIntf pdao;
	@Autowired
	private HttpSession session;
	@Override
	public String getPojo(String email, String password) {
		
		Person p=pdao.getDesignation(email, password);
		DiscriminatorValue val=p.getClass().getAnnotation(DiscriminatorValue.class);
		String desig=val.value();
		session.setAttribute("designation", desig);
		String s = "E";
		if(desig.equals(s))
		{
			System.out.println("he is employee");
			//Employee e = (Employee)p;
			session.setAttribute("user",p);
			return "redirect:/Employee/homeEmp";
		}
		else
		{
			//Manager m  = (Manager)p;
			session.setAttribute("user",p);
			System.out.println("validation completed");
			return "redirect:/Manager/homeMgr";
		}
		
		
	}
	
	@Override
	public void editProfile(int empId, String address, int contactNo, String email) {
		pdao.editProfile(empId, address, contactNo, email);		
	}

	@Override
	public void logout()
	{
		session.invalidate();
	}
}
