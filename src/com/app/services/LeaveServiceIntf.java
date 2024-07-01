package com.app.services;

import java.util.List;

import com.app.pojos.Leave;

public interface LeaveServiceIntf {
	
	public int addLeave(Leave l);
	public List<Leave> showLeaves(int managerId);
	public boolean updateLeaveStatus(int leaveId,char status);
	public int getEmpIdByLeaveId(int leaveId);

	
	

}
