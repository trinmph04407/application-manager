/**
 * 
 */
package vn.poly.group2.pro2111.subject.repositories.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.entities.Subject;
import vn.poly.group2.pro2111.subject.repositories.SubjectRepository;

/**
 * Subject repository implement
 * 
 * @author minht
 * 
 */
@Repository
public class SubjectRepositoryImpl extends BaseRepository implements SubjectRepository {

	
	@Override
	public Long count(Long majorId, Long lecturerId, String name) {
		
		// Build query string with default conditional
        StringBuilder queryStb = new StringBuilder("select count(1) from Subject ");
        	
        // Add name && majorId && lecturerId condition
        if (StringUtils.isNoneBlank(name) && majorId != null && lecturerId != null) {
        	queryStb.append(" where majorId = :majorId and lecturerId = :lecturerId and name like :name");
		}
        
        // Add name && majorId condition
        else if (StringUtils.isNoneBlank(name) && majorId != null) {
			queryStb.append(" where majorId = :majorId and name like :name");
		}
        
        // Add majorId && lecturerId condition
        else if (majorId != null && lecturerId != null) {
			queryStb.append(" where majorId = :majorId and lecturerId = :lecturerId");
		}
        
        // Add name && lecturerId condition
        else if (StringUtils.isNoneBlank(name) && lecturerId != null) {
			queryStb.append(" where name like :name and lecturerId = :lecturerId");
		}
        
        // Add majorId condition
        else if (majorId != null) {
            queryStb.append(" where majorId = :majorId ");
        }
        
        // Add lecturerId condition
        else if (lecturerId != null) {
            queryStb.append(" where lecturerId = :lecturerId ");
        }
        
        // Add name condition
        else if (StringUtils.isNotBlank(name)) {
            queryStb.append(" where name like :name ");
        }

        // Build query
        Query query = this.getCurrentSession().createQuery(queryStb.toString());
        
        
        // Set majorId parameter
        if (majorId != null) {
            query.setLong("majorId", majorId);
        }
        
        // Set lecturerId parameter
        if (lecturerId != null) {
        	query.setLong("lecturerId", lecturerId);
        }

        // Set name parameter
        if (StringUtils.isNotBlank(name)) {
            query.setString("name", "%" + name + "%");
        }

        return (Long) query.uniqueResult();
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Subject> select(Long majorId, Long lecturerId, String name, int offset, int limit) {
			
		// Build query string with default conditional
		 StringBuilder queryStb = new StringBuilder("from Subject ");
		 
		 // Add name && majorId && lecturerId condition
		 if (StringUtils.isNoneBlank(name) && majorId != null && lecturerId != null) {
	        	queryStb.append(" where majorId = :majorId and lecturerId = :lecturerId and name like :name");
			}else if (StringUtils.isNoneBlank(name) && majorId != null) {
				queryStb.append(" where majorId = :majorId and name like :name");
			}else if (majorId != null && lecturerId != null) {
				queryStb.append(" where majorId = :majorId and lecturerId = :lecturerId");
			}else if (StringUtils.isNoneBlank(name) && lecturerId != null) {
				queryStb.append(" where name like :name and lecturerId = :lecturerId");
			}else if (majorId != null) {
	            queryStb.append(" where majorId = :majorId ");
	        }else if (lecturerId != null) {
	            queryStb.append(" where lecturerId = :lecturerId ");
	        }else if (StringUtils.isNotBlank(name)) {
	            queryStb.append(" where name like :name ");
	        }
		 
	        // Build query
	        Query query = this.getCurrentSession().createQuery(queryStb.toString());      
	        
	        // Set majorId parameter
	        if (majorId != null) {
	            query.setLong("majorId", majorId);
	        }
	        
	        // Set lecturerId parameter
	        if (lecturerId != null) {
	        	query.setLong("lecturerId", lecturerId);
	        }
	        
	        // Set name parameter
	        if (StringUtils.isNotBlank(name)) {
	            query.setString("name", "%" + name + "%");
	        }

	        return query.setFirstResult(offset).setMaxResults(limit).list();
	}
	
	/*
	 * (non-Javadoc) select id major
	 */
	@Override
	public Subject select(Long id) {
		Subject entity =  this.getCurrentSession().get(Subject.class, id);
	        return entity;
	}
	
	/*
	 * (non-Javadoc) create subject
	 */
	@Override
	public Long insert(Subject subject) {
		return (Long) super.insert(subject);
	}
	
	/*
	 * (non-Javadoc) update subject
	 */
	@Override
	public Long update(Subject subject) {
		return (Long) super.update(subject);
	}	
	
	/*
	 * (non-Javadoc) remove subject
	 */
	@Override
	public boolean remove(Long id) {
		Session session = this.getCurrentSession();
		Subject subject = session.get(Subject.class, id);
		session.delete(subject);
		return true;
	}
	
	/*
	 * (non-Javadoc) check code
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean check(String code) {
		List<Subject> list = null;
		
		// Build session
		Session session = this.getCurrentSession();
		
		// statement 
		String sql = "from Subject where code = '" + code + "' ";
		
		// Build query
		Query query = session.createQuery(sql);
		list = query.list();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

}
