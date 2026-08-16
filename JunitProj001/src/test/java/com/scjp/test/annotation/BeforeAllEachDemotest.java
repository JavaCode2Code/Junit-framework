package com.scjp.test.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.scjp.code.Calculator;

public class BeforeAllEachDemotest {
	private static Calculator calculator;

	@BeforeAll
	static void setUpBeforeAll() {
		calculator = new Calculator();
		System.out.println("setUpBeforeAll method calling..");
	}

	/*
	 * @BeforeEach void setUp() { calculator = new Calculator();
	 * System.out.println("setUp method calling.."); }
	 */

	@Test
	public void addTest() {

		int actualResult = calculator.add(10, 20);
		assertEquals(30, actualResult);
		System.out.println("Addition method calling..");

	}

	@Test
	public void subtractTest() {

		int actutalResul = calculator.substract(30, 20);
		assertEquals(10, actutalResul);
		System.out.println("Subtaction method calling..");
	}

	@Test
	public void multiplyTest() {

		int actualResult = calculator.multiply(5, 10);
		assertEquals(50, actualResult);
		System.out.println("multiply method calling..");

	}

	@Test
	public void divideTest() {

		int actualResult = calculator.divide(10, 5);
		assertEquals(2, actualResult);
		System.out.println("Divide method calling..");
	}
}
