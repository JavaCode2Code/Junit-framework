package com.scjp.test.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.scjp.code.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

	
	@Order(4)
	@Test
	public void addTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.add(10, 20);
		assertEquals(30, actualResult);

	}


	@Order(3)
	@Test
	public void subtractTest() {
		Calculator calculator = new Calculator();
		int actutalResul = calculator.substract(30, 20);
		assertEquals(10, actutalResul);
	}

	
	@Order(2)
	@Test
	public void multiplyTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.multiply(5, 10);
		assertEquals(50, actualResult);
	}

	@Order(1)
	@Test
	public void divideTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.divide(10, 5);
		assertEquals(2, actualResult);
	}

}
