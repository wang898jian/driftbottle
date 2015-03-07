package sse.ustc.driftbottle.DAO;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A data access object (DAO) providing persistence and search support for
 * Bottle entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see sse.ustc.driftbottle.DAO.Bottle
 * @author MyEclipse Persistence Tools
 */
public class BottleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BottleDAO.class);
	// property constants
	public static final String BOTTLE_TYPE = "bottleType";
	public static final String SENDER_USER_ID = "senderUserId";

	public void save(Bottle transientInstance) {
		log.debug("saving Bottle instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bottle persistentInstance) {
		log.debug("deleting Bottle instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bottle findById(sse.ustc.driftbottle.DAO.BottleId id) {
		log.debug("getting Bottle instance with id: " + id);
		try {
			Bottle instance = (Bottle) getSession().get(
					"sse.ustc.driftbottle.DAO.Bottle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bottle instance) {
		log.debug("finding Bottle instance by example");
		try {
			List results = getSession()
					.createCriteria("sse.ustc.driftbottle.DAO.Bottle")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bottle instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bottle as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBottleType(Object bottleType) {
		return findByProperty(BOTTLE_TYPE, bottleType);
	}

	public List findBySenderUserId(Object senderUserId) {
		return findByProperty(SENDER_USER_ID, senderUserId);
	}

	public List findAll() {
		log.debug("finding all Bottle instances");
		try {
			String queryString = "from Bottle";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bottle merge(Bottle detachedInstance) {
		log.debug("merging Bottle instance");
		try {
			Bottle result = (Bottle) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bottle instance) {
		log.debug("attaching dirty Bottle instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bottle instance) {
		log.debug("attaching clean Bottle instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}