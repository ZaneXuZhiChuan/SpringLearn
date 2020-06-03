package com.atguigu.springlearn.service;

import com.atguigu.springlearn.dao.CalculatorDao;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorDao {
	@Override
	public int add(int i, int j) {
		return (i+j);
	}

	@Override
	public int sub(int i, int j) {
		return (i-j);
	}

	@Override
	public int mul(int i, int j) {
		return (i*j);
	}

	@Override
	public int div(int i, int j) {
		return (i/j);
	}
}
