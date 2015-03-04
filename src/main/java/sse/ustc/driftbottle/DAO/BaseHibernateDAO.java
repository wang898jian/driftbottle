package sse.ustc.driftbottle.DAO;

import org.hibernate.Session;

import sse.ustc.driftbottle.data.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}