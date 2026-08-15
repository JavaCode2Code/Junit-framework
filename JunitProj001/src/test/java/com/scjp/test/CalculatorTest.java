package com.scjp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.scjp.code.Calculator;

public class CalculatorTest {

	@Test
	public void addTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.add(10, 20);
		assertEquals(30, actualResult);

	}

	@Test
	public void subtractTest() {
		Calculator calculator = new Calculator();
		int actutalResul = calculator.substract(30, 20);
		assertEquals(10, actutalResul);
	}

	@Test
	public void multiplyTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.multiply(5, 10);
		assertEquals(50, actualResult);
	}

	@Test
	public void divideTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.divide(10, 5);
		assertEquals(2, actualResult);
	}

}
