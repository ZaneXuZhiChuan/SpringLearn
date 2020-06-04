package com.atguigu.springlearn.aop.service;

import com.atguigu.springlearn.aop.dao.CalculatorDao;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorDao {
	@Override
	public int add(int i, int j) {
		int res = i + j;
		System.out.println("CalculatorService:"+res);
		return res;
	}

	@Override
	public int sub(int i, int j) {
		int res = i - j;
		System.out.println("CalculatorService:"+res);
		return res;
	}

	@Override
	public int mul(int i, int j) {
		int res = i * j;
		System.out.println("CalculatorService:"+res);
		return res;
	}

	@Override
	public int div(int i, int j) {
		int res = i / j;
		System.out.println("CalculatorService:"+res);
		return res;
	}
}
