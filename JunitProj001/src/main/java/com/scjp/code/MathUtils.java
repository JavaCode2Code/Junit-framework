package com.scjp.code;

public class MathUtils {
	public boolean isEven(int number) {

		return number % 2 == 0;

	}
	
	public boolean isWeekDay(Days day) {
		return day!=Days.SATURDAY && day!=Days.SUNDAY;
	}
	  public long factorial(int number){
	        int result = 1;
	        for(int i = 1; i <= number; i++){
	            result = result * i;
	        }
	        return result;
	    }
}
