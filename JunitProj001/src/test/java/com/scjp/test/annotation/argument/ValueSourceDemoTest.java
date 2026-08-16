package com.scjp.test.annotation.argument;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.scjp.code.MathUtils;

public class ValueSourceDemoTest {

	@ParameterizedTest
	@ValueSource(ints={2,4,6,8,10})
	void isEvenTest(int number) {
		MathUtils mathUtils=new MathUtils();
				assertTrue(mathUtils.isEven(number));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"hello","Hi","welcome","Namaste"})
	void valueSource(String param) {
		assertNotNull(param);
	}
}
