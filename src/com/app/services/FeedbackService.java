package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.FeedbackDao;
import com.app.pojos.Feedback;

@Service
@Transactional
public class FeedbackService implements FeedbackServiceIntf {

	@Autowired
	private FeedbackDao fdao;
	@Override
	public int addFeedback(Feedback f) {
		return fdao.addFeedback(f);
	}

	@Override
	public List<Double> getFeedback() {
		return fdao.getFeedback();
	}

}
