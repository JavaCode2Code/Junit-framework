package com.scjp.test.annotation.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.scjp.code.MathUtils;

public class CsvSourceDemoTest {

	@Disabled
	@ParameterizedTest
	@CsvSource({
		"0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120"
	})
	void factorialTestDemo(int num,int expected) {
		MathUtils mathUtils=new MathUtils();
		assertEquals(expected, mathUtils.factorial(num));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/factorial_data.csv")
	void factorialCsvFileResouceTestDemo(int num,int expected) {
		MathUtils mathUtils=new MathUtils();
		assertEquals(expected, mathUtils.factorial(num));
	}
}
