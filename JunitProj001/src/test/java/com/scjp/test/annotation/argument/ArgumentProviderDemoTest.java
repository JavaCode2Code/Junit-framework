package com.scjp.test.annotation.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.scjp.code.MathUtils;

public class ArgumentProviderDemoTest {

	@ParameterizedTest
	@ArgumentsSource(FactorialArgumentProvider.class)
	void factorialTest(int num,int expected) {
		MathUtils mathUtils=new MathUtils();
		assertEquals(expected, mathUtils.factorial(num));
		
	}
}
