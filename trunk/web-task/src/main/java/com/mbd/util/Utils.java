package com.mbd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Helpful services
 */
public class Utils {
	/** Short DateFormat - dd.MM.yyyy */
	public static final SimpleDateFormat DATE_FMT = new SimpleDateFormat(
			"dd.MM.yyyy");

	/** Full DateFormat - dd.MM.yyyy HH:ss:mm */
	public static final SimpleDateFormat DATE_HOUR_FMT = new SimpleDateFormat(
			"dd.MM.yyyy HH:ss:mm");

	/**
	 * Checks if the given String is <code>null</code> or empty.
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean isNotEmpty(String s) {
		return s != null && !s.trim().equals("");
	}

	/**
	 * Validates given date range
	 * 
	 * @param from
	 *            - start date
	 * @param to
	 *            - end date
	 * @return boolean
	 */
	public static boolean isRangeValid(Date from, Date to) {
		if (from == null || to == null) {
			return true;
		}
		return to.compareTo(from) > -1;
	}

	/**
	 * Calculates the beginning of the next day, removes all addiotional
	 * information about hours, seconds and etc.
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date nextDayStart(Date date) {

		if (date == null) {
			return date;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, 1);

		return cal.getTime();
	}
}
