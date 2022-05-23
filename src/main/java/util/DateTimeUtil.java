package util;

import java.time.*;
import java.util.Date;

/**
 * 日期、时间相关工具类型
 *
 * @author xujun
 * version: 1.1
 */
public class DateTimeUtil {
	/**
	 * 获取一天的开始时刻
	 * 业务场景：日历选择后作为筛选条件查询数据库
	 */
	public static Date getBeginDate(Date queryDate) {
		LocalDateTime localDateTime = LocalDateTime.of(toLocalDate(queryDate), LocalTime.MIN);
		return toDate(localDateTime);
	}

	/**
	 * 获取一天的结束时刻
	 * 业务场景：日历选择后作为筛选条件查询数据库
	 */
	public static Date getEndDate(Date queryDate) {
		LocalDateTime localDateTime = LocalDateTime.of(toLocalDate(queryDate), LocalTime.MAX);
		return toDate(localDateTime);
	}

	/**
	 * 把ZonedDateTime类型转换成Date类型
	 * 业务场景：类型转换
	 */
	public static Date toDate(ZonedDateTime zonedDateTime) {
		return Date.from(zonedDateTime.toInstant());
	}

	/**
	 * 把LocalDateTime类型转换成Date类型
	 * 业务场景：类型转换
	 */
	public static Date toDate(LocalDateTime localDateTime) {
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		return toDate(zonedDateTime);
	}

	/**
	 * 把Date类型对象转换成ZonedDateTime类型对象
	 * 业务场景：类型转换
	 */
	public static ZonedDateTime toZonedDateTime(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault());
	}

	/**
	 * 把Date类型对象转换成LocalDateTime类型对象
	 * 业务场景：类型转换
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return toZonedDateTime(date).toLocalDateTime();
	}

	/**
	 * 把Date类型对象转换成LocalDate类型对象
	 * 业务场景：类型转换
	 */
	public static LocalDate toLocalDate(Date date) {
		return toZonedDateTime(date).toLocalDate();
	}

	/**
	 * 把Date类型对象转换成LocalTime类型对象
	 * 业务场景：类型转换
	 */
	public static LocalTime toLocalTime(Date date) {
		return toZonedDateTime(date).toLocalTime();
	}

	/**
	 * 把Date类型对象转换成ZonedDateTime类型对象
	 * 业务场景：类型转换
	 */
	public static ZonedDateTime toDate(Date date) {
		Instant instant = date.toInstant();
		return instant.atZone(ZoneId.systemDefault());
	}
}
