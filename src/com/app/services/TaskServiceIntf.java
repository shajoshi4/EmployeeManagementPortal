package com.app.services;

import java.util.List;

import com.app.pojos.Task;

public interface TaskServiceIntf {
	public int allotTask(Task t);
	public List<Task> viewAllotedTask(int empId);
	public void updateTaskStatus(int taskId, String status);
	public void updateResponseFile(int taskId,String responseFile);
	public List<Task> viewSubmittedTask(int managerId);

}
