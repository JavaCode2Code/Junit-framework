package com.scjp.test.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.management.DescriptorKey;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.scjp.code.Calculator;

public class RepeatedTestDemoTest {
	private Calculator calculator;

	@BeforeEach
	 void setUp() {
		calculator = new Calculator();
		System.out.println("setUp method calling..");
	}


    @AfterEach
    void tearDown(){
        System.out.println("tearDown method is calling ..");
    }

    @BeforeAll
    static void setUpBeforeClass(){
        System.out.println("setUpBeforeClass method is calling ..");
    }

    @AfterAll
    static void tearDownAfterClass(){
        System.out.println("tearDownAfterClass method is calling ..");
    }

    @RepeatedTest(value=5, name=RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Test Divide repeatedly")
	@Test
	public void divideTest() {
		
		int actualResult = calculator.divide(10, 5);
		assertEquals(2, actualResult);
		System.out.println("Divide method calling..");
	}
}
