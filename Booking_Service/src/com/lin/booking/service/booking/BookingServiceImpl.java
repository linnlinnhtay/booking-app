package com.lin.booking.service.booking;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.booking.dao.booking.BookingDAO;
import com.lin.booking.dao.class_schedule.ClassScheduleDAO;
import com.lin.booking.dao.gym_package.UserPackageDAO;
import com.lin.booking.dto.booking.BookingDTO;
import com.lin.booking.entity.booking.Booking;
import com.lin.booking.entity.class_schedule.ClassSchedule;
import com.lin.booking.entity.gym_package.UserPackage;
import com.lin.booking.util.common.CommonUtil;
import com.lin.booking.util.common.MapperUtil;
import com.lin.booking.util.enumeration.BookingStatus;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;

	@Autowired
	private UserPackageDAO userPackageDAO;

	@Autowired
	private ClassScheduleDAO classScheduleDAO;

	@Override
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		try {
			if (bookingDTO != null && bookingDTO.getUserPackageId() != null
					&& bookingDTO.getClassScheduleId() != null) {
				Booking booking = new Booking();
				booking.setCreatedTime(new Date());
				booking.setBookingStatus(BookingStatus.BOOKED.getCode());

				UserPackage userPackage = new UserPackage();
				userPackage.setId(bookingDTO.getUserPackageId());
				booking.setUserPackage(userPackage);

				ClassSchedule classSchedule = new ClassSchedule();
				classSchedule.setId(bookingDTO.getClassScheduleId());
				booking.setClassSchedule(classSchedule);

				Long bookingId = bookingDAO.saveWithId(booking);
				if (CommonUtil.validLong(bookingId)) {
					booking = bookingDAO.get(bookingId);

					// deduct credit
					userPackage = userPackageDAO.get(booking.getUserPackage().getId());
					classSchedule = classScheduleDAO.get(booking.getClassSchedule().getId());

					userPackage.setRemainingCredits(
							userPackage.getRemainingCredits().subtract(classSchedule.getRequiredCredits()));
					userPackage.setUpdatedTime(new Date());
					userPackageDAO.saveOrUpdate(userPackage);

					return new BookingDTO(booking);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookingDTO> searchBookingList(BookingDTO bookingDTO) {
		List<Booking> bookingList = bookingDAO.searchBookingList(bookingDTO);
		return MapperUtil.mapList(bookingList, BookingDTO::new);
	}

	@Override
	public List<BookingDTO> searchBookingListByUser(Long userId) {
		List<Booking> bookingList = bookingDAO.searchBookingListByUser(userId);
		return MapperUtil.mapList(bookingList, BookingDTO::new);
	}

}
