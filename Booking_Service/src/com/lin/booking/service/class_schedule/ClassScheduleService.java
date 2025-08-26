package com.lin.booking.service.class_schedule;

import java.util.List;

import com.lin.booking.dto.class_schedule.ClassScheduleDTO;

public interface ClassScheduleService {

	List<ClassScheduleDTO> getClassScheduleList(ClassScheduleDTO requestDTO);

	ClassScheduleDTO getClassScheduleById(Long classScheduleId);

}
