package com.lin.booking.dao.gym_package;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.common.GenericDAO;
import com.lin.booking.entity.gym_package.UserPackage;

@Repository("userPackageDAO")
@Transactional
public class UserPackageDAO extends GenericDAO<UserPackage, Long> {

}
