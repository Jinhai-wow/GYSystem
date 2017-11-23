package com.gmsys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Util {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	private static SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * 检查字符串是否为空
	 * @param s
	 * @return
	 */
	public static boolean isNullOrBlank(final String s) {
		if (s == null) {
			return true;
		}
		if (s.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检查字符
	 * @param s
	 * @return
	 */
	public static boolean isNullOrBlank(final Short s) {
		if (s == null || s.intValue() == -1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 时间格式化
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date)
	{
		Date ret = null;
		if(date != null && date != "")
		{
			try {
				ret = df.parse(date);
			} catch (ParseException e) {
				ret = null;
			}
		}
		return ret;
	}
	
	/**
	 * “yyyy-MM-dd”
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date)
	{
		String ret = "";
		try {
			ret = df.format(date);
		}
		catch(Exception e)
		{
			ret = "";
		}
		return ret;
	}
	
	/**
	 * yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date)
	{
		String ret = "";
		try {
			ret = tf.format(date);
		}
		catch(Exception e)
		{
			ret = "";
		}
		return ret;
	}
	
	
	/**
	 * 按格式分割ID和名字
	 * @param idandname
	 * @return
	 */
	public static String[] splitIdAndName(String idandname)
	{
		String[] obj = idandname.split("/");
		return obj;
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String[] splitPath(String path)
	{
		String[] obj = null;
		if(path != null && !path.equals(""))
			obj = path.split("\\\\");
		return obj;
	}
}
