package com.crazy.dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.crazy.bean.TUser;
import com.crazy.dao.TUserDao;

public class TUserDaoImpl implements TUserDao{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 删除前进行持久化
	 */
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		TUser user=(TUser) session.get(TUser.class, uid);
		session.delete(user);
		session.getTransaction().commit();
		return 1;
	}

	/**
	 * 添加一条数据
	 */
	@Override
	public int insertSelective(TUser record) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.save(record);
		tran.commit();
		return 1;
	}

	/**
	 * 根据id查询用户
	 */
	@Override
	public TUser selectByPrimaryKey(Integer uid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("select uname,umessage,utime from TUser where uid = ?");
		query.setInteger(0, uid);
		Object[] obj=(Object[]) query.uniqueResult();
		TUser user=new TUser();
		user.setUname(obj[0].toString());
		user.setUmessage(obj[1].toString());
		user.setUtime((Date)obj[3]);
		session.close();
		return user;
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public int updateByPrimaryKey(TUser record) {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(record);
		session.getTransaction().commit();
		return 1;
	}

	/**
	 * 查询用户列表
	 */
	@Override
	public List<TUser> queryAll() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from TUser order by utime desc");
		@SuppressWarnings("unchecked")
		List<TUser> list=query.list();
		System.out.println(list.get(0));
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * 查询用户条数
	 */
	@Override
	public int getTotal() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("select count(*) from t_user");
		int count=Integer.valueOf(query.uniqueResult().toString());
		session.getTransaction().commit();
		session.close();
		return count;
	}

}
