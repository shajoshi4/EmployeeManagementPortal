package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.TaskDaoIntf;
import com.app.pojos.Task;

@Service
@Transactional
public class TaskService implements TaskServiceIntf {

	@Autowired
	private TaskDaoIntf tdao;
	
	@Override
	public int allotTask(Task t) {
		return  tdao.allotTask(t);
	}

	@Override
	public List<Task> viewAllotedTask(int empId) {
		return tdao.viewAllotedTask(empId);
	}
	
	@Override
	public void updateTaskStatus(int taskId, String status) 
	{
		tdao.updateTaskStatus(taskId, status);
	}

	@Override
	public void updateResponseFile(int taskId,String responseFile)
	{
		tdao.updateResponseFile(taskId, responseFile);
	}
	
	@Override
	public List<Task> viewSubmittedTask(int managerId) 
	{
		return tdao.viewSubmittedTask(managerId);
	}

}
