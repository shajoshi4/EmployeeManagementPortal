package com.app.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Feedback;

@Repository
public class FeedbackDao implements FeedbackDaoIntf {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addFeedback(Feedback f) {
		
		return (int)sf.getCurrentSession().save(f);
	}

	@Override
	public List<Double> getFeedback() {
		
		List<Double> l1=new ArrayList<>();
		
		 l1.add(sf.getCurrentSession().createQuery("select avg(f.que1) from Feedback f",Double.class).getSingleResult());
		 l1.add(sf.getCurrentSession().createQuery("select avg(f.que2) from Feedback f",Double.class).getSingleResult());
		 l1.add(sf.getCurrentSession().createQuery("select avg(f.que3) from Feedback f",Double.class).getSingleResult());
		 l1.add(sf.getCurrentSession().createQuery("select avg(f.que4) from Feedback f",Double.class).getSingleResult());
		 l1.add(sf.getCurrentSession().createQuery("select avg(f.que5) from Feedback f",Double.class).getSingleResult());
		 
		 return l1;
	}

}
