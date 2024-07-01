package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Manager;
import com.app.pojos.Notice;

@Repository
public class NoticeDao implements NoticeDaoIntf {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addNotice(Notice n) {
		return (int)sf.getCurrentSession().save(n);
	}

	@Override
	public List<Notice> getNoticeByMngId(int mngId) {
		System.out.println("Manager Id="+mngId);
		Manager m = new Manager();
		m.setEmpId(mngId);
		return sf.getCurrentSession().createQuery("select n from Notice n where n.manager=:mId",Notice.class).setParameter("mId", m).getResultList();
	}

	@Override
	public void deleteNotice(List<Integer> noticeId) {
		
		for(int id: noticeId)
		{
			Notice n=sf.getCurrentSession().get(Notice.class, id);
			sf.getCurrentSession().remove(n);
		}
	}

	@Override
	public List<Notice> getNoticeByDeptId(int deptId) {
		Department d = new Department();
				d.setDeptId(deptId);
		return sf.getCurrentSession().createQuery("select n from Notice n where dept=:dId",Notice.class).setParameter("dId",d ).getResultList();
	}

}
