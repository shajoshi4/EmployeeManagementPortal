package com.app.daos;

import java.util.List;

import com.app.pojos.Notice;

public interface NoticeDaoIntf {

	public int addNotice(Notice n);
	public List<Notice> getNoticeByMngId(int mngId);
	public List<Notice> getNoticeByDeptId(int deptId);
	public void deleteNotice(List<Integer> noticeId);
}
