package sse.ustc.driftbottle.DAO;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Friends entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see sse.ustc.driftbottle.DAO.Friends
 * @author MyEclipse Persistence Tools
 */
public class FriendsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(FriendsDAO.class);
	// property constants
	public static final String FRIEND_ID = "friendId";
	public static final String FRIEND_NAME = "friendName";

	public void save(Friends transientInstance) {
		log.debug("saving Friends instance");
		try {
			getSession().save(transientInstance);
			getSession().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Friends persistentInstance) {
		log.debug("deleting Friends instance");
		try {
			getSession().delete(persistentInstance);
			getSession().flush();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Friends findById(java.lang.Integer id) {
		log.debug("getting Friends instance with id: " + id);
		try {
			Friends instance = (Friends) getSession().get(
					"sse.ustc.driftbottle.DAO.Friends", id);
			getSession().flush();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Friends instance) {
		log.debug("finding Friends instance by example");
		try {
			List results = getSession()
					.createCriteria("sse.ustc.driftbottle.DAO.Friends")
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
		log.debug("finding Friends instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Friends as model where model."
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

	public List findByFriendId(Object friendId) {
		return findByProperty(FRIEND_ID, friendId);
	}

	public List findByFriendName(Object friendName) {
		return findByProperty(FRIEND_NAME, friendName);
	}

	public List findAll() {
		log.debug("finding all Friends instances");
		try {
			String queryString = "from Friends";
			Query queryObject = getSession().createQuery(queryString);
			getSession().flush();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Friends merge(Friends detachedInstance) {
		log.debug("merging Friends instance");
		try {
			Friends result = (Friends) getSession().merge(detachedInstance);
			getSession().flush();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Friends instance) {
		log.debug("attaching dirty Friends instance");
		try {
			getSession().saveOrUpdate(instance);
			getSession().flush();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Friends instance) {
		log.debug("attaching clean Friends instance");
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