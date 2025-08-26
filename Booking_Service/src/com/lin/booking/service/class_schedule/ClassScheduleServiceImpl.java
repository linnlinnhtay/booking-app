package com.lin.booking.service.class_schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.class_schedule.ClassScheduleDAO;
import com.lin.booking.dto.class_schedule.ClassScheduleDTO;
import com.lin.booking.entity.class_schedule.ClassSchedule;
import com.lin.booking.util.common.MapperUtil;

@Service("classScheduleService")
@Transactional
public class ClassScheduleServiceImpl implements ClassScheduleService {

	@Autowired
	private ClassScheduleDAO classScheduleDAO;

	@Override
	public List<ClassScheduleDTO> getClassScheduleList(ClassScheduleDTO requestDTO) {
		List<ClassSchedule> classScheduleList = classScheduleDAO.getClassScheduleList(requestDTO);
		return MapperUtil.mapList(classScheduleList, ClassScheduleDTO::new);
	}

	@Override
	public ClassScheduleDTO getClassScheduleById(Long classScheduleId) {
		ClassSchedule classSchedule = classScheduleDAO.get(classScheduleId);
		if (classSchedule != null) {
			return new ClassScheduleDTO(classSchedule);
		}
		return null;
	}

}
