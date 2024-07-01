package com.app.daos;

import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.Person;

public interface EmployeeDaoIntf {

	public int addEmp(Employee e);
	public Employee getEmp(int id);	 
	public void updateEmpCount(int empIds);
	public List<Employee> getEmployeeByMgrId(int managerId);
	public int getMgrIdByEmpId(int empId);
	public Person getEmpById(int empId);
	public void updatePassword(int empId,String password);
	
	 
}

