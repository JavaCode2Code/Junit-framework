package com.scjp.test.annotation.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.scjp.code.MathUtils;

public class MethodSourceDemoTest {

	@ParameterizedTest
	@MethodSource("provideArguments")
	void factorialTest(int num, int expected) {
		MathUtils mathUtils = new MathUtils();
		assertEquals(expected, mathUtils.factorial(num));

	}

	static Stream<Arguments> provideArguments() {

		return Stream.of(

				Arguments.arguments(0, 1), Arguments.arguments(1, 1), Arguments.arguments(2, 2),
				Arguments.arguments(3, 6), Arguments.arguments(4, 24), Arguments.arguments(5, 120));

	}
}
