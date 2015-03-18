package sse.ustc.driftbottle.DAO;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Loginformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see sse.ustc.driftbottle.DAO.Loginformation
 * @author MyEclipse Persistence Tools
 */
public class LoginformationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LoginformationDAO.class);
	// property constants
	public static final String PASS_WD = "passWd";

	public void save(Loginformation transientInstance) {
		log.debug("saving Loginformation instance");
		try {
			getSession().save(transientInstance);
			getSession().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Loginformation persistentInstance) {
		log.debug("deleting Loginformation instance");
		try {
			getSession().delete(persistentInstance);
			getSession().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Loginformation findById(java.lang.String id) {
		System.out.print("getting Loginformation instance with id: ");
		log.debug("getting Loginformation instance with id: " + id);
		try {
			Loginformation instance = (Loginformation) getSession().get(
					"sse.ustc.driftbottle.DAO.Loginformation", id);
			getSession().flush();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
//	public Loginformation findByIdTest(java.lang.String id) {
//		System.out.print("getting Loginformation instance with id: ");
//		log.debug("getting Loginformation instance with id: " + id);
//		try {
//			 List<Loginformation> list = getSession()
//					 .createQuery("select t from Loginformation t where t.username=:userName")
//					 .setParameter("userName", id).list();  
//			 return list.isEmpty() ? null : list.get(0);
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
	public List findByExample(Loginformation instance) {
		log.debug("finding Loginformation instance by example");
		try {
			List results = getSession()
					.createCriteria("sse.ustc.driftbottle.DAO.Loginformation")
					.add(Example.create(instance)).list();
			getSession().flush();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Loginformation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Loginformation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			getSession().flush();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassWd(Object passWd) {
		return findByProperty(PASS_WD, passWd);
	}

	public List findAll() {
		log.debug("finding all Loginformation instances");
		try {
			String queryString = "from Loginformation";
			Query queryObject = getSession().createQuery(queryString);
			getSession().flush();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Loginformation merge(Loginformation detachedInstance) {
		log.debug("merging Loginformation instance");
		try {
			Loginformation result = (Loginformation) getSession().merge(
					detachedInstance);
			getSession().flush();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Loginformation instance) {
		log.debug("attaching dirty Loginformation instance");
		try {
			getSession().saveOrUpdate(instance);
			getSession().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Loginformation instance) {
		log.debug("attaching clean Loginformation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			getSession().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}