package com.app.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.EmployeeDaoIntf;
import com.app.pojos.Employee;
import com.app.pojos.Person;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceIntf {

	@Autowired
	private EmployeeDaoIntf empDao;
	@Override
	public int addEmp(Employee e) {

		return empDao.addEmp(e);
	}
	
	@Override
	public Employee getEmp(int id)
	{
		return empDao.getEmp(id);
	}
	

	@Override
	public void updateEmpCount(int empId)
	{
		 empDao.updateEmpCount(empId);
	}
	
	@Override
	public List<Employee> getEmployeeByMgrId(int managerId)
	{
		return empDao.getEmployeeByMgrId(managerId);
	}
	
	@Override
	public int getMgrIdByEmpId(int empId)
	{
		return empDao.getMgrIdByEmpId(empId);
	}

	@Override
	public Person getEmpById(int empId)
	{
		return empDao.getEmpById(empId);
	}
	
	@Override
	public void updatePassword(int empId,String password)
	{
		empDao.updatePassword(empId, password);
	}
	
	public int getRandInt(int min,int max)
    {
    Random r=new Random();
    int n=r.nextInt((max-min)+1)+min;
    return n;
    }
	@Override
	public String getCaptchaCode()
    {
        String code="";
        char ch;
       ch=(char)getRandInt(65, 90);
       code+=ch;
       ch=(char)getRandInt(65, 90);
       code+=ch;
       ch=(char)getRandInt(97, 122);
       code+=ch;
       ch=(char)getRandInt(97, 122);
       code+=ch;
       ch=(char)getRandInt(49, 57);
       code+=ch;
       ch=(char)getRandInt(49, 57);
       code+=ch;
       return code;
    
    }
	
}
