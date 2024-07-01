package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.NoticeDaoIntf;
import com.app.pojos.Notice;

@Service
@Transactional
public class NoticeService implements NoticeServiceIntf {

	@Autowired
	private NoticeDaoIntf ndao;
	@Override
	public int addNotice(Notice n) {
		
		return ndao.addNotice(n);
	}

	@Override
	public List<Notice> getNoticeByMngId(int mngId) {
		return ndao.getNoticeByMngId( mngId);
	}

	@Override
	public List<Notice> getNoticeByDeptId(int deptId) {
		return ndao.getNoticeByDeptId(deptId);
	}

	@Override
	public void deleteNotice(List<Integer> noticeId) {
		ndao.deleteNotice(noticeId);

	}

}
