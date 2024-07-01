//constructor parameterized

package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
@DiscriminatorValue(value="M")
public class Manager extends Person {
	
	private List<Notice> notices = new ArrayList<Notice>();
	private List<Leave> leaves = new ArrayList<Leave>();
	private List<Task> tasks = new ArrayList<Task>();
	
	
	public Manager()
	{
		
		System.out.println("in manager");
		//notices = new ArrayList<Notice>();
	}
	
	
	
	public void addNotice(Notice n)
	{
		notices.add(n);
		n.setManager(this);
		
	}
	
	public Manager(String firstName, String lastName, Date dob, char gender, String address, Date regDate,
			int contactNo, String email, String password) {
		super(firstName, lastName, dob, gender, address, regDate, contactNo, email, password);
		// TODO Auto-generated constructor stub
	}

	public void grantLeave(Leave l)
	{
		leaves.add(l);
		l.setRequestedTo(this);
	}
	
	public void addTasks(Task t)
	{
		tasks.add(t);
		t.setAllocatedBy(this);
		
    }


	@OneToMany(cascade=CascadeType.ALL,mappedBy="manager")
	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="requestedTo")
	public List<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="allocatedBy")
	public List<Task> getTasks() {
		return tasks;
	}

	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
