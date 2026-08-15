package com.scjp.code;

public class MathUtils {
	public boolean isEven(int number) {

		return number % 2 == 0;

	}
	
	public boolean isWeekDay(Days day) {
		return day!=Days.SATURDAY && day!=Days.SUNDAY;
	}

}
