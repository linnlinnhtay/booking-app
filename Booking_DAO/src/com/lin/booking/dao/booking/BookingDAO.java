package com.lin.booking.dao.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.common.GenericDAO;
import com.lin.booking.dto.booking.BookingDTO;
import com.lin.booking.entity.booking.Booking;
import com.lin.booking.util.common.CommonUtil;

@Repository("bookingDAO")
@Transactional
public class BookingDAO extends GenericDAO<Booking, Long> {

	@SuppressWarnings("unchecked")
	public List<Booking> searchBookingList(BookingDTO bookingDTO) {
		Criteria c = getCurrentSession().createCriteria(Booking.class);

		if (CommonUtil.validLong(bookingDTO.getClassScheduleId())) {
			c.createAlias("userPackage", "up", JoinType.LEFT_OUTER_JOIN);
			c.add(Restrictions.eq("up.id", bookingDTO.getClassScheduleId()));
		}
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.addOrder(Order.desc("createdTime"));

		List<Booking> results = c.list();
		return (results.isEmpty() || results == null) ? null : results;
	}

	@SuppressWarnings("unchecked")
	public List<Booking> searchBookingListByUser(Long userId) {
		Criteria c = getCurrentSession().createCriteria(Booking.class);

		if (CommonUtil.validLong(userId)) {
			c.createAlias("userPackage", "up", JoinType.LEFT_OUTER_JOIN);
			c.createAlias("up.user", "u", JoinType.LEFT_OUTER_JOIN);

			c.add(Restrictions.eq("u.id", userId));
		}
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.addOrder(Order.desc("createdTime"));

		List<Booking> results = c.list();
		return (results.isEmpty() || results == null) ? null : results;
	}

}
