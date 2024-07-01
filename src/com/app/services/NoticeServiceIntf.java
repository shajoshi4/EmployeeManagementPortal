package com.app.services;

import java.util.List;

import com.app.pojos.Notice;

public interface NoticeServiceIntf {

	public int addNotice(Notice n);
	public List<Notice> getNoticeByMngId(int mngId);
	public List<Notice> getNoticeByDeptId(int deptId);
	public void deleteNotice(List<Integer> noticeId);
	
}
