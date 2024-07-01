package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Leaveemp")
public class Leave {
	
	private Integer leaveId;
	
	private String subject;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date fromDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date toDate;
	
	private String description;
	private char status;
	private Employee requestedBy;
	private Manager requestedTo;
	
	
	public Leave()
	{
		System.out.println("in Leave pojo");
	}
	
	
	public Leave( String subject, Date fromDate, Date toDate, String description, char status) 
	{
		super();
		this.subject = subject;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
		this.status = status;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

    @Column(length=100)
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		System.out.println("in setter of setsubject");
		this.subject = subject;
	}

    @Temporal(TemporalType.DATE)
	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		System.out.println("in setter of setfromDate");
		this.fromDate = fromDate;
	}


	 @Temporal(TemporalType.DATE)
	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		System.out.println("in setter of setTodate");
		this.toDate = toDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		System.out.println("in setter of setdescription");
		this.description = description;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		System.out.println("in seeter of status");
		
		this.status = status;
	}


	@ManyToOne//many leaves can be taken by one employee
	@JoinColumn(name="employeeId")
	public Employee getRequestedBy() {
		return requestedBy;
	}


	public void setRequestedBy(Employee requstedBy) {
		System.out.println("in setter of setrequested by");
		this.requestedBy = requstedBy;
	}



	@ManyToOne//many leaves can be approved by one manager
	@JoinColumn(name="managerId")
	public Manager getRequestedTo() {
		return requestedTo;
	}


	public void setRequestedTo(Manager requestedTo) {
		System.out.println("in setter of setrequestedto");
		this.requestedTo = requestedTo;
	}
	
	
	

}
