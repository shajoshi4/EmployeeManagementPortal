package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Department")
public class Department {
	private Integer deptId;
	String deptName;
	private List<Person> persons = new ArrayList<Person>();
	private List<Notice> notices = new ArrayList<Notice>();
	
	
	
	public Department() {
		super();
		//persons = new ArrayList<Person>();
		//notices = new ArrayList<Notice>();
		System.out.println("in department pojo");
	}


	public Department( String deptName) {
		super();
		this.deptName = deptName;
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

    @Column(length=20,unique=true)
	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public void addEmployee(Person p)
	{
		persons.add(p);
		p.setDept(this);
	}

	public void addNotice(Notice n)
	{
		notices.add(n);
		n.setDept(this);
		
	}
	
	

    @OneToMany(cascade=CascadeType.ALL,mappedBy="dept")
	public List<Person> getPersons() {
		return persons;
	}


	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

    @OneToMany(cascade=CascadeType.ALL,mappedBy="dept")
	public List<Notice> getNotices() {
		return notices;
	}


	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
	
}
