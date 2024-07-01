package com.app.daos;

import java.util.List;

import com.app.pojos.Leave;

public interface LeaveDaoIntf {

	public int addLeave(Leave l);
	public List<Leave> showLeaves(int managerId);
	public boolean updateLeaveStatus(int leaveId,char status);
	public int getEmpIdByLeaveId(int leaveId);
	
}
