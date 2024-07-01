package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Leave;
import com.app.pojos.Manager;
import com.app.pojos.Person;

@Repository
public class LeaveDao implements LeaveDaoIntf {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addLeave(Leave l) {
		return (int)sf.getCurrentSession().save(l);
	}

	@Override
	public List<Leave> showLeaves(int Id) {
		
		Person mg = new Person();
		mg.setEmpId(Id);
		
		System.out.println("Id value is"+Id);
		return sf.getCurrentSession().createQuery("select l from Leave l where requestedTo=:mgrId and status='P'",Leave.class).setParameter("mgrId",mg).getResultList();
	}

	@Override
	public boolean updateLeaveStatus(int leaveId, char status) {
	Leave l=sf.getCurrentSession().get(Leave.class, leaveId);
	l.setStatus(status);
	
	if(l.getLeaveId()>0)
	{
	return true;
	}
	else
	{
		return false;
	}
	}
	
	@Override
	public int getEmpIdByLeaveId(int leaveId)
	{
		return sf.getCurrentSession().get(Leave.class,leaveId).getRequestedBy().getEmpId();
	}
}
