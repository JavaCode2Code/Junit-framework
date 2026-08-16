package com.scjp.test.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.scjp.code.Calculator;

public class NestedCalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
		System.out.println("setUp method calling..");
	}

	@Nested
	class AdditionTests {
		@Test
		public void addTest() {

			assertEquals(7, calculator.add(3, 4));

		}
		@Test
		public void addTest2() {

			assertEquals(9, calculator.add(5, 4));

		}
		
		@Test
		public void addTes3() {

			assertEquals(10, calculator.add(6, 4));

		}

	}

	@Nested
	class SubtractTesting {
		@Test
		public void subtractTest() {
			assertEquals(1, calculator.substract(4, 3));
		}
		@Test
		public void subtractTest2() {
			assertEquals(-7, calculator.substract(-4, 3));
		}
		@Test
		public void subtractTest3() {
			assertEquals(3, calculator.substract(0, 3));
		}
	}

	@Nested
	class Mltiply {
		@Test
		public void multiplyTest() {

			assertEquals(12, calculator.multiply(3, 4));

		}
		@Test
		public void multiplyTest2() {

			assertEquals(20, calculator.multiply(5, 4));

		}
	}

	@Nested
	class Divide {
		@Test
		public void divideTest() {

			assertEquals(5, calculator.divide(10, 2));
		}
		@Test
		public void divideTest2() {

			assertEquals(5, calculator.divide(15, 3));
		}
		
		@Test
		public void divideTes3() {

			assertEquals(2, calculator.divide(20, 5));
		}
	}
}
