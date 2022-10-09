package com.yash.rbs.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtil {
	
	public static Timestamp getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp today = java.sql.Timestamp.valueOf(now);
		return today;
	}

}
