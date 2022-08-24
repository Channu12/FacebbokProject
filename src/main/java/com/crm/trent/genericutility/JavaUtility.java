package com.crm.trent.genericutility;

import java.sql.Date;
import java.util.Random;
/**
 * 
 * @author User
 *
 */

public class JavaUtility {
	/**
	 * It is used to generate the random number within the range 0f 1000
	 * @return
	 */
	public static int getRandDomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}
	/**
	 * It is used to get current system date based on YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDate() 
	{
		java.util.Date date = new java.util.Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");

		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;

		String format = yyyy+"-"+mm+"-"+dd;
		return format;

	}
}
