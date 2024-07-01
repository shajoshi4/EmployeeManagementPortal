package com.app.services;

import java.util.List;

import com.app.pojos.Feedback;

public interface FeedbackServiceIntf {

	public int addFeedback(Feedback f);
	public List<Double> getFeedback();
}
