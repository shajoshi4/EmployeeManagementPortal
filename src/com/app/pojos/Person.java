package com.app.pojos;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="designation",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="P")
public class Person {
	
	
	private Integer empId;
	private String firstName;
	//@Size(min=3,max=20)
	//@NotNull 
	private String lastName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	private char gender;
	
	private String address;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDate;
	
	private int contactNo;
	
	@Email
	private String email;
	
	private String password;
	
	
	private Department dept;
	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	
	
	public Person()
	{
		
		System.out.println("in person pojo");
	}
	

	public Person( String firstName, String lastName, Date dob, char gender, String address, Date regDate,
			int contactNo, String email,  String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.regDate = regDate;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	
	}


	

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getEmpId() {
	    System.out.println("in getter of empId");
		return empId;
	}


	public void setEmpId(Integer empId) {
		System.out.println("in setter of id");
		this.empId = empId;
	}

@Column(length=20)
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		System.out.println("in setter of firstName");
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	@Column(length=20)
	public void setLastName(String lastName) {
		System.out.println("in setter of lastName");
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		System.out.println("in setter of dob");
		this.dob = dob;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		System.out.println("in setter of gender");
		this.gender = gender;
	}


	@Column(length=100)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		System.out.println("in setter of address");
		this.address = address;
	}

    @Temporal(TemporalType.DATE)
	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		System.out.println("in setter of regdate");
		this.regDate = regDate;
	}


	@Column(length=10,unique=true)
	public int getContactNo() {
		return contactNo;
	}


	public void setContactNo(int contactNo) {
		System.out.println("in setter of contavt");
		this.contactNo = contactNo;
	}


	@Column(length=50,unique=true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		System.out.println("in setter of email");
		this.email = email;
	}

    


	@Column(length=10)
	public String getPassword() {
		return password;
	}


	
	public void setPassword(String password) {
		System.out.println("in setter of pass");
		this.password = password;
	}
	
	@ManyToOne
	@JoinColumn(name="deptId")
	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		System.out.println("in setter of dept");
		this.dept = dept;
	}


	public void addFeedback(Feedback f)
	{
		feedbacks.add(f);
		f.setPerson(this);
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		//return  firstName+" "+lastName;
		return empId+"";
	}

	
	


	
	
	
	

}
