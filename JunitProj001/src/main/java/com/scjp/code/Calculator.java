package com.scjp.code;

public class Calculator {

public int add(int a,int b) {
	return a+b;
}
public int substract(int a,int b) {
	return a-b;
}
public int multiply(int a,int b) {
	return a*b;
}
public int divide(int a,int b) {
	if(b==0) {
		throw new ArithmeticException("Devision by zero on not allowed");
	}
	return a/b;
}


}
