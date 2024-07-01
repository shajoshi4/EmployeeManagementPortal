package com.app.pojos;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notice {
  private Integer noticeId;
  private String noticeText;
  private Department dept;
  private Manager manager;
  
  
public Notice() {
	super();
	System.out.println("in notice constructor");
}


public Notice(String noticeText) {
	super();
	this.noticeText = noticeText;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getNoticeId() {
	return noticeId;
}


public void setNoticeId(Integer noticeId) {
	this.noticeId = noticeId;
}



public String getNoticeText() {
	return noticeText;
}


public void setNoticeText(String noticeText) {
	this.noticeText = noticeText;
}

@ManyToOne
@JoinColumn(name="deptId")
public Department getDept() {
	return dept;
}


public void setDept(Department dept) {
	this.dept = dept;
}

@ManyToOne
@JoinColumn(name="managerId")
public Manager getManager() {
	return manager;
}


public void setManager(Manager manager) {
	this.manager = manager;
}


@Override
public String toString() {
	return  noticeId + " " + noticeText ;
}


  
  
  

}
