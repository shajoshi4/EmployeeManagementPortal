package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback 
{
	
	
	private int que1;
	private int que2;
	private int que3;
	private int que4;
	private int que5;
	private Integer feedbackId;
	private Person person;
	
	
	public Feedback(int que1, int que2, int que3, int que4, int que5) {
		super();
		this.que1 = que1;
		this.que2 = que2;
		this.que3 = que3;
		this.que4 = que4;
		this.que5 = que5;
	}


	public Feedback() {
		super();
		System.out.println("in feedback pojo constructor");
	}


	public int getQue1() {
		return que1;
	}


	public void setQue1(int que1) {
		this.que1 = que1;
	}


	public int getQue2() {
		return que2;
	}


	public void setQue2(int que2) {
		this.que2 = que2;
	}


	public int getQue3() {
		return que3;
	}


	public void setQue3(int que3) {
		this.que3 = que3;
	}


	public int getQue4() {
		return que4;
	}


	public void setQue4(int que4) {
		this.que4 = que4;
	}


	public int getQue5() {
		return que5;
	}


	public void setQue5(int que5) {
		this.que5 = que5;
	}


	@ManyToOne
	@JoinColumn(name="empId")
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	

}
