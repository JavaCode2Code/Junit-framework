package com.scjp.test.annotation.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses({ClassATest.class,ClassTest2.class,ClassTest3.class})
@SelectPackages({"com.scjp.test.annotation","com.scjp.test"})
public class SuiteTest {

}
