package sse.ustc.driftbottle.DAO;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sse.ustc.driftbottle.pojo.Massage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Massage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see sse.ustc.driftbottle.pojo.Massage
 * @author MyEclipse Persistence Tools
 */
public class MassageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MassageDAO.class);
	// property constants
	public static final String MASSAGE_TYPE = "massageType";
	public static final String SENDER_USER_ID = "senderUserId";

	public void save(Massage transientInstance) {
		log.debug("saving Massage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Massage persistentInstance) {
		log.debug("deleting Massage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Massage findById(sse.ustc.driftbottle.pojo.MassageId id) {
		log.debug("getting Massage instance with id: " + id);
		try {
			Massage instance = (Massage) getSession().get(
					"sse.ustc.driftbottle.DAO.Massage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Massage instance) {
		log.debug("finding Massage instance by example");
		try {
			List results = getSession()
					.createCriteria("sse.ustc.driftbottle.DAO.Massage")
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
		log.debug("finding Massage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Massage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMassageType(Object massageType) {
		return findByProperty(MASSAGE_TYPE, massageType);
	}

	public List findBySenderUserId(Object senderUserId) {
		return findByProperty(SENDER_USER_ID, senderUserId);
	}

	public List findAll() {
		log.debug("finding all Massage instances");
		try {
			String queryString = "from Massage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Massage merge(Massage detachedInstance) {
		log.debug("merging Massage instance");
		try {
			Massage result = (Massage) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Massage instance) {
		log.debug("attaching dirty Massage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Massage instance) {
		log.debug("attaching clean Massage instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}