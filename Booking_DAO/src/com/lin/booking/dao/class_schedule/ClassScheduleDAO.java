package com.lin.booking.dao.class_schedule;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.common.GenericDAO;
import com.lin.booking.dto.class_schedule.ClassScheduleDTO;
import com.lin.booking.entity.class_schedule.ClassSchedule;
import com.lin.booking.util.common.CommonUtil;

@Repository("classScheduleDAO")
@Transactional
public class ClassScheduleDAO extends GenericDAO<ClassSchedule, Long> {

	@SuppressWarnings("unchecked")
	public List<ClassSchedule> getClassScheduleList(ClassScheduleDTO requestDTO) {
		Criteria c = getCurrentSession().createCriteria(ClassSchedule.class);

		if (CommonUtil.validString(requestDTO.getCountryCode())) {
			c.add(Restrictions.eq("countryCode", requestDTO.getCountryCode()));
		}
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.addOrder(Order.desc("createdTime"));

		List<ClassSchedule> results = c.list();
		return (results.isEmpty() || results == null) ? null : results;
	}

}
