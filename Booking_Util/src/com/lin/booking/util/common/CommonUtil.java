package com.lin.booking.util.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtil {
	public static boolean validString(String value) {
		return value != null && !value.trim().isEmpty();
	}

	public static boolean validList(List<?> value) {
		return value != null && !value.isEmpty();
	}

	public static boolean validLong(Long value) {
		return value != null && value.longValue() > 0;
	}

	public static boolean validInteger(Integer value) {
		return value != null && value.intValue() > 0;
	}

	public static String dateToString(String format, Date date) {
		if (date == null) {
			return "";
		}

		if (format == null || format.trim().isEmpty()) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		return new SimpleDateFormat(format).format(date);

	}

	public static Date addDayToDate(Date dt, int days) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DATE, days);
			dt = c.getTime();
		} catch (Exception e) {
			System.out.println("addDayToDate() error >>" + e.getMessage());
			return null;
		}
		return dt;
	}
}
