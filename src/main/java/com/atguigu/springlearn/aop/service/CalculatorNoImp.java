package com.atguigu.springlearn.aop.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorNoImp {

	public int add(int i, int j) {
		int res = i + j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}

	public int sub(int i, int j) {
		int res = i - j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}

	public int mul(int i, int j) {
		int res = i * j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}

	public int div(int i, int j) {
		int res = i / j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}
}
