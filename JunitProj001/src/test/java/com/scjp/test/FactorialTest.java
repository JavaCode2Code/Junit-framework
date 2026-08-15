package com.scjp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.scjp.code.Factorial;

public class FactorialTest {  

	@Test
	public void factorialTest() {
		Factorial factorial=new Factorial();
		int actualResult=factorial.factoorial(5);
	assertEquals(120,actualResult);
	}
}
