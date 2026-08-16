package com.scjp.test.annotation.argument;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.scjp.code.Days;
import com.scjp.code.MathUtils;

public class EnumSourceDemoTest {
	
	
	@ParameterizedTest
	@EnumSource(value=Days.class,names= {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"})
void isWeekDayTest(Days day) {
	MathUtils mathUtils=new MathUtils();
	assertTrue(mathUtils.isWeekDay(day));
}
}
