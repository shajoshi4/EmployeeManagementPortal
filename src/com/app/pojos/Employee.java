package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Person")
@DiscriminatorValue(value="E")
public class Employee extends Person{
	private int managerId;
	int count;
	private List<Leave> leaves = new ArrayList<Leave>();
	private List<Task> tasks = new ArrayList<Task>();
	
	

	public Employee() {
		super();
		System.out.println("in Employee pojo");
	}
	
	public Employee(int managerId,int count, String firstName, String lastName, Date dob, char gender, String address, Date regDate, int contactNo, String email, char designation, String password, int deptId) {
		super( firstName, lastName, dob, gender, address, regDate, contactNo, email, password);
		this.managerId = managerId;
		this.count = count;
	}

	
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	public void addLeave(Leave l)
	{
		leaves.add(l);
		l.setRequestedBy(this);
	}
	public void getTasks(Task t)
	{
		tasks.add(t);
		t.setAllocatedTo(this);
		
    }
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requestedBy")//discarding third table
	public List<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy="allocatedTo")
	public List<Task> getTasks() {
		return tasks;
	}

	//this is not required for employee
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	@Override
	public String toString() {
		return super.toString();
	}

	
	
	


	
	

}
