package com.app.daos;

import java.util.List;

import com.app.pojos.Task;

public interface TaskDaoIntf {

	public int allotTask(Task t);
	public List<Task> viewSubmittedTask(int managerId);
	public void updateTaskStatus(int taskId,String status);
	public List<Task> viewAllotedTask(int empId);
	public void updateResponseFile(int taskId,String responseFile);

}
