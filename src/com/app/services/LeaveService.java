package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.LeaveDaoIntf;
import com.app.pojos.Leave;

@Service
@Transactional
public class LeaveService implements LeaveServiceIntf {
	
	@Autowired
	private LeaveDaoIntf leaveDao;

	@Override
	public int addLeave(Leave l) {
		return leaveDao.addLeave(l);
	}

	@Override
	public List<Leave> showLeaves(int managerId) {
		   return leaveDao.showLeaves(managerId);
	}

	@Override
	public boolean updateLeaveStatus(int leaveId, char status) {
		if(leaveDao.updateLeaveStatus(leaveId, status))
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
		return leaveDao.getEmpIdByLeaveId(leaveId);
	}


}
