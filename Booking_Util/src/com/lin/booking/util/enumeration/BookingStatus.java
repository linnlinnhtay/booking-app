package com.lin.booking.util.enumeration;

import java.util.ArrayList;
import java.util.List;

import com.lin.booking.util.common.object.CommonObject;

public enum BookingStatus {
	BOOKED(1, "Booked"), CANCELED(2, "Canceled"), WAITLIST(3, "WaitList"), CHECKED_IN(4, "Checked_In");

	private Integer code;
	private String desc;

	BookingStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static String getDescByCode(int code) {
		for (BookingStatus cs : values()) {
			if (cs.getCode() == code) {
				return cs.getDesc();
			}
		}
		return "";
	}

	public static List<CommonObject> getAll() {
		List<CommonObject> typeList = new ArrayList<CommonObject>();
		for (BookingStatus t : BookingStatus.values()) {
			typeList.add(new CommonObject(t.getCode(), t.getDesc()));
		}
		return typeList;
	}
}
