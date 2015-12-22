package com.suoyi.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.suoyi.myexceptions.LogicalException;
import com.suoyi.service.util.ServiceUtil;

public class SessionUtil {
	private static ThreadLocal<SessionFactory> tl_sessionfactory = new ThreadLocal<SessionFactory>();
	private static ThreadLocal<Session> tl_session = new ThreadLocal<Session>();
	private static ThreadLocal<Transaction> tl_tx = new ThreadLocal<Transaction>();

	public static Session getSession() throws Exception {
		Session session = tl_session.get();
		if (session == null) {
			if (tl_sessionfactory.get() != null) {
				session = tl_sessionfactory.get().openSession();
			} else {
				SessionFactory sessionFactory = (SessionFactory) ServiceUtil.getBean("sessionFactory");
				if (sessionFactory != null) {
					session = sessionFactory.openSession();
					tl_session.set(session);
					tl_sessionfactory.set(sessionFactory);
				} else {
					throw new LogicalException("获取sessionFactory失败!");
				}
			}
		}
		return session;
	}

	public static void beginTx() throws Exception {
		Transaction tx = tl_tx.get();
		if (tx == null) {
			tx = getSession().beginTransaction();
			tl_tx.set(tx);
		} else {
			tx.begin();
		}
	}

	public static void commit() throws Exception {
		Transaction tx = tl_tx.get();
		if (tx == null) {
			throw new LogicalException("当前无事务需要提交!");
		}else{
			tx.commit();
		}
	}
}
