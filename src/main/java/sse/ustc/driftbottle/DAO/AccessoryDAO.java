package sse.ustc.driftbottle.DAO;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Accessory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see sse.ustc.driftbottle.DAO.Accessory
 * @author MyEclipse Persistence Tools
 */
public class AccessoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AccessoryDAO.class);
	// property constants
	public static final String ACCESSORY_TYPE = "accessoryType";
	public static final String ACCESSORY_URL = "accessoryUrl";

	public void save(Accessory transientInstance) {
		log.debug("saving Accessory instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Accessory persistentInstance) {
		log.debug("deleting Accessory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Accessory findById(java.lang.String id) {
		log.debug("getting Accessory instance with id: " + id);
		try {
			Accessory instance = (Accessory) getSession().get(
					"sse.ustc.driftbottle.DAO.Accessory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Accessory instance) {
		log.debug("finding Accessory instance by example");
		try {
			List results = getSession()
					.createCriteria("sse.ustc.driftbottle.DAO.Accessory")
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
		log.debug("finding Accessory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Accessory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccessoryType(Object accessoryType) {
		return findByProperty(ACCESSORY_TYPE, accessoryType);
	}

	public List findByAccessoryUrl(Object accessoryUrl) {
		return findByProperty(ACCESSORY_URL, accessoryUrl);
	}

	public List findAll() {
		log.debug("finding all Accessory instances");
		try {
			String queryString = "from Accessory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Accessory merge(Accessory detachedInstance) {
		log.debug("merging Accessory instance");
		try {
			Accessory result = (Accessory) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Accessory instance) {
		log.debug("attaching dirty Accessory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Accessory instance) {
		log.debug("attaching clean Accessory instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}