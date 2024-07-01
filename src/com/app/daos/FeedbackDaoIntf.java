package com.app.daos;

import java.util.List;

import com.app.pojos.Feedback;

public interface FeedbackDaoIntf {

	public int addFeedback(Feedback f);
	public List<Double> getFeedback();
	
}
