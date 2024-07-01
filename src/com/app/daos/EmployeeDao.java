package com.app.daos;

import com.app.pojos.Employee;
import com.app.pojos.Person;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao implements EmployeeDaoIntf {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addEmp(Employee e) {
		return (int)sf.getCurrentSession().save(e);
		
	}
	
	@Override
	public Employee getEmp(int id)
	{
		
		
		return sf.getCurrentSession().get(Employee.class,id);
		
	}
	

	@Override
	public List<Employee> getEmployeeByMgrId(int managerId)
	{
		return sf.getCurrentSession()
				.createQuery("select e from Employee e where e.managerId=:mgrId",Employee.class)
				.setParameter("mgrId", managerId).getResultList();
	}

	@Override
	public void updateEmpCount(int empId)
	{
		Employee e=sf.getCurrentSession().get(Employee.class, empId);
		e.setCount(e.getCount()+1);	
	}
	
	@Override
	public int getMgrIdByEmpId(int empId)
	{
		Employee emp= sf.getCurrentSession().get(Employee.class,empId);
		System.out.println("Employee got from manager ID in dao :"+emp);
		System.out.println(emp.getManagerId());
		return emp.getManagerId();
	}
	
	@Override
	public Person getEmpById(int empId)
	{
		Person emp=sf.getCurrentSession()
		.createQuery("select p from Person p where p.empId=:id",Person.class)
		.setParameter("id", empId).getSingleResult();
		
		/*System.out.println("Person from dao "+emp.getEmail());
		System.out.println("Person from dao "+emp.getEmpId());
		emp.setPassword("abc");*/
		return emp;
	}
	
	@Override
	public void updatePassword(int empId,String password)
	{
		Person emp=sf.getCurrentSession()
				.createQuery("select p from Person p where p.empId=:id",Person.class)
				.setParameter("id", empId).getSingleResult();
		emp.setPassword(password);
	}
	
}
