package comPractice;

import java.util.Date;

public class Time {

	public static void main(String[] args) {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");

		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
		String tt = arr[3];

		String format = yyyy+"-"+mm+"-"+dd+"-"+tt;
		
		
		System.out.println(format);
	}
}
