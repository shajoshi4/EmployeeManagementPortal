package com.app.pojos;


import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task {

	private Integer taskId;
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date allocatedOn;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date submittedOn;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deadline;
	private String taskFile;
	private Employee allocatedTo;
	private Manager allocatedBy;
	private String status;
	private String responseFile;

	
	
	public Task() {
		System.out.println("In Task Constructor");
	}


	public Task(String description, Date allocatedOn, Date submittedOn, Date deadline, String taskFile,
			Employee allocatedTo, Manager allocatedBy, String status,String responseFile) {
		super();
		this.description = description;
		this.allocatedOn = allocatedOn;
		this.submittedOn = submittedOn;
		this.deadline = deadline;
		this.taskFile = taskFile;
		this.allocatedTo = allocatedTo;
		this.allocatedBy = allocatedBy;
		this.status = status;
		this.responseFile=responseFile;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTaskId() {
		System.out.println("In get Task taskId");
		return taskId;
	}


	public void setTaskId(Integer taskId) {
		System.out.println("In set Task taskId");
		this.taskId = taskId;
	}


	public String getDescription() {
		System.out.println("In get Task description");
		return description;
	}


	public void setDescription(String description) {
		System.out.println("In set Task description");
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getAllocatedOn() {
		System.out.println("In get Task allocatedOn");
		return allocatedOn;
	}


	public void setAllocatedOn(Date allocatedOn) {
		System.out.println("In set Task allocatedOn");
		this.allocatedOn = allocatedOn;
	}

	@Temporal(TemporalType.DATE)
	public Date getSubmittedOn() {
		System.out.println("In get Task submittedOn");
		return submittedOn;
	}


	public void setSubmittedOn(Date submittedOn) {
		System.out.println("In set Task submittedOn");
		this.submittedOn = submittedOn;
	}

	@Temporal(TemporalType.DATE)
	public Date getDeadline() {
		System.out.println("In get Task deadline");
		return deadline;
	}


	public void setDeadline(Date deadline) {
		System.out.println("In set Task deadline");
		this.deadline = deadline;
	}

	
	public String getTaskFile() {
		System.out.println("In get Task taskFile");
		return taskFile;
	}


	public void setTaskFile(String taskFile) {
		System.out.println("In set Task taskFile");
		this.taskFile = taskFile;
	}

	
	public String getResponseFile() {
		return responseFile;
	}


	public void setResponseFile(String responseFile) {
		this.responseFile = responseFile;
	}


	@ManyToOne
	@JoinColumn(name="empId")
	public Employee getAllocatedTo() {
		System.out.println("In get Task allocatedTo");
		return allocatedTo;
	}


	public void setAllocatedTo(Employee allocatedTo) {
		System.out.println("In set Task allocatedTo");
		this.allocatedTo = allocatedTo;
	}

	@ManyToOne
	@JoinColumn(name="managerId")
	public Manager getAllocatedBy() {
		System.out.println("In get Task allocatedBy");
		return allocatedBy;
	}


	public void setAllocatedBy(Manager allocatedBy) {
		System.out.println("In set Task allocatedBy");
		this.allocatedBy = allocatedBy;
	}


	public String getStatus() {
		System.out.println("In get Task status");
		return status;
	}


	public void setStatus(String status) {
		System.out.println("In set Task status");
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", allocatedOn=" + allocatedOn
				+ ", submittedOn=" + submittedOn + ", deadline=" + deadline + ", taskFile=" + taskFile
				+ ", allocatedTo=" + allocatedTo + ", allocatedBy=" + allocatedBy + ", status=" + status +"responseFile"+responseFile+ "]";
	}
	
	
}
