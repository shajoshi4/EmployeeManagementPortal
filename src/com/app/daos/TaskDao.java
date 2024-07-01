package com.app.daos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
import com.app.pojos.Task;

@Repository
public class TaskDao implements TaskDaoIntf {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public int allotTask(Task t ) {
		
		return (int)sf.getCurrentSession().save(t);
	}

	@Override
	public List<Task> viewSubmittedTask(int managerId) {
		return sf.getCurrentSession().
				createQuery("select t from Task t where t.status='SUBMITTED' order by t.submittedOn desc",Task.class).getResultList();
	}

	@Override
	public void updateTaskStatus(int taskId, String status) {
		Task t=sf.getCurrentSession().get(Task.class, taskId);
		t.setStatus(status);
	}

	@Override
	public List<Task> viewAllotedTask(int empId) {
		Employee emp=new Employee();
		emp.setEmpId(empId);
		return sf.getCurrentSession()
				.createQuery("select t from Task t where t.allocatedTo=:em and t.status in ('NEWTASK','REASSIGNED')", Task.class)
				.setParameter("em", emp).getResultList();
	}
	
	@Override
	public void updateResponseFile(int taskId,String responseFile)
	{
		Task t=sf.getCurrentSession().get(Task.class, taskId);
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		t.setResponseFile(responseFile);
		t.setSubmittedOn(date);
	}

}
