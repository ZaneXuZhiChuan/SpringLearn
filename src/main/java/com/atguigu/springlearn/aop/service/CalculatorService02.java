package com.atguigu.springlearn.aop.service;

import com.atguigu.springlearn.aop.dao.CalculatorDao;

public class CalculatorService02 implements CalculatorDao{

	@Override
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

	@Override
	public int mul(int i, int j) {
		int res = i * j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}

	@Override
	public int div(int i, int j) {
		int res = i / j;
		System.out.println("CalculatorService02:"+res);
		return res;
	}
}
