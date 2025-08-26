package com.lin.booking.dao.gym_package;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.common.GenericDAO;
import com.lin.booking.dto.gym_package.GymPackageDTO;
import com.lin.booking.entity.gym_package.GymPackage;
import com.lin.booking.util.common.CommonUtil;

@Repository("gymPackageDAO")
@Transactional
public class GymPackageDAO extends GenericDAO<GymPackage, Long> {

	@SuppressWarnings("unchecked")
	public List<GymPackage> getPackageList(GymPackageDTO requestDTO) {
		Criteria c = getCurrentSession().createCriteria(GymPackage.class);

		if (CommonUtil.validString(requestDTO.getCountryCode())) {
			c.add(Restrictions.eq("countryCode", requestDTO.getCountryCode()));
		}
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		c.addOrder(Order.desc("createdTime"));

		List<GymPackage> results = c.list();
		return (results.isEmpty() || results == null) ? null : results;
	}

}
