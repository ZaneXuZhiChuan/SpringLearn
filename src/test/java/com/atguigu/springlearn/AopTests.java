package com.atguigu.springlearn;

import com.atguigu.springlearn.dao.CalculatorDao;
import com.atguigu.springlearn.proxy.CalculatorProxy;
import com.atguigu.springlearn.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTests {

	@Autowired
	private CalculatorService calculatorService;
	@Autowired
	private CalculatorProxy calculatorProxy;
	@Test
	public void calculatorProxyTest() {
//		CalculatorService calculatorService = new CalculatorService();
//		CalculatorDao calculatorDaoProxy = CalculatorProxy.getProxy(calculatorService);
//		calculatorDaoProxy.add(1, 3);
//		calculatorDaoProxy.mul(2, 5);
//		calculatorDaoProxy.div(1, 0);

		CalculatorDao calculatorDaoProxy = (CalculatorDao) calculatorProxy.getE(calculatorService);
		calculatorDaoProxy.add(1, 3);
		calculatorDaoProxy.mul(2, 5);
		calculatorDaoProxy.div(1, 0);
	}

}
