package com.scjp.code;

public class Factorial {

	public int factoorial(int number) {
		if(number<0) {
			throw new IllegalArgumentException("Factorial is not deified for negative numbers");
		}
		int factorial=1;
		for(int i=1;i<=number;i++) {
			factorial=factorial*i;
		}
		return factorial;
	}
}
