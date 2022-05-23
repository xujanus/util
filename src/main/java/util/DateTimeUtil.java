package util;

import java.time.*;
import java.util.Date;

/**
 * 日期、时间相关工具类型
 *
 * @author xujun
 * version: 1.0
 */
public class DateTimeUtil {

	/**
	 * 把Date类型对象转换成ZonedDateTime类型对象
	 *
	 * @param date Date类型对象
	 * @return ZonedDateTime 类型对象
	 */
	public static ZonedDateTime toZonedDateTime(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault());
	}

	/**
	 * 把Date类型对象转换成LocalDateTime类型对象
	 *
	 * @param date Date类型对象
	 * @return LocalDateTime 类型对象
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return toZonedDateTime(date).toLocalDateTime();
	}

	/**
	 * 把Date类型对象转换成LocalDate类型对象
	 *
	 * @param date Date类型对象
	 * @return LocalDate 类型对象
	 */
	public static LocalDate toLocalDate(Date date) {
		return toZonedDateTime(date).toLocalDate();
	}

	/**
	 * 把Date类型对象转换成LocalTime类型对象
	 *
	 * @param date Date类型对象
	 * @return LocalTime 类型对象
	 */
	public static LocalTime toLocalTime(Date date) {
		return toZonedDateTime(date).toLocalTime();
	}

	/**
	 * 把Date类型对象转换成ZonedDateTime类型对象
	 *
	 * @param date Date类型对象
	 * @return ZonedDateTime 类型对象
	 */
	public static ZonedDateTime toDate(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault());
	}

	/**
	 * 把ZonedDateTime类型转换成Date类型
	 *
	 * @param zonedDateTime ZonedDateTime类型对象
	 * @return Date类型对象
	 */
	public static Date toDate(ZonedDateTime zonedDateTime) {
		return Date.from(zonedDateTime.toInstant());
	}

	/**
	 * 把LocalDateTime类型转换成Date类型
	 *
	 * @param localDateTime LocalDateTime类型对象
	 * @return Date类型对象
	 */
	public static Date toDate(LocalDateTime localDateTime) {
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		return toDate(zonedDateTime);
	}
}
