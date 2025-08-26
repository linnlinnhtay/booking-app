package com.lin.booking.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.common.GenericDAO;
import com.lin.booking.entity.user.User;
import com.lin.booking.util.enumeration.CommonStatus;

@Repository("userDAO")
@Transactional
public class UserDAO extends GenericDAO<User, Long> {
	
	@SuppressWarnings("unchecked")
	public User validUser(String email, String password) {
		Criteria c = getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email.trim()));
		c.add(Restrictions.eq("password", password));
		c.add(Restrictions.eq("status", CommonStatus.ACTIVE.getCode()));
		List<User> result = c.list();
		return (result == null || result.isEmpty()) ? null : result.get(0);
	}

}
