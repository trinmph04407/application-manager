/*
 * ================================================================================
 *   == COPYRIGHT HYPERTECH ENTERPRISE SOLUTIONS. ALL RIGHT RESERVED.            ==
 *   == HYPERTECH PROPRIETARY/CONFIDENTIAL. USE THIS SUBJECT TO LICENSE TERMS.   ==
 *   ==                                                                          ==
 *   == VISIT HTTP://HYPERTECH.COM.VN FOR MORE INFORMATION                       ==
 * ================================================================================
 *
 *  == Project: iam-api
 *  == Created by: duongnguyen
 *  == Created at: 12/10/17 10:50 PM
 */
package vn.poly.group2.pro2111.common.bases;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository implements BaseRepositoryInterface {

	/*
	 * =============================================================================
	 * =================================== ===== CONSTANT =====
	 * =============================================================================
	 * ===================================
	 */

	/*
	 * =============================================================================
	 * =================================== ===== PROTECTED PROPERTIES =====
	 * =============================================================================
	 * ===================================
	 */

	/** Logger */
	protected final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Protected Resource: JPA Entity Manager
	 */
	@Autowired
	protected SessionFactory sessionFactory;

	/*
	 * =============================================================================
	 * =================================== ===== PROTECTED METHOD =====
	 * =============================================================================
	 * ===================================
	 */

	/**
	 * UnWrap Hibernate session
	 *
	 * @return Current hibernate session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * insert new entity
	 * 
	 * @param entity
	 * 
	 * @return Inserted entity
	 */
	protected Object insert(Object entity) {
		return this.getCurrentSession().save(entity);
	}

	/**
	 * insert new entity
	 * 
	 * @param entity
	 * 
	 * @return Inserted entity
	 */
	protected Object update(Object entity) {
		return this.getCurrentSession().save(entity);
	}
	
	protected boolean update2 (Object entity) {
		this.getCurrentSession().update(entity);
		return true;
	}

}
