package com.lin.booking.service.booking;

import java.util.List;

import com.lin.booking.dto.booking.BookingDTO;

public interface BookingService {

	BookingDTO createBooking(BookingDTO bookingDTO);

	List<BookingDTO> searchBookingList(BookingDTO bookingDTO);

	List<BookingDTO> searchBookingListByUser(Long userId);

}
