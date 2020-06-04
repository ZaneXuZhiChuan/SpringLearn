package com.atguigu.springlearn;

import com.atguigu.springlearn.aop.dao.CalculatorDao;
import com.atguigu.springlearn.aop.proxy.CalculatorProxy;
import com.atguigu.springlearn.aop.service.CalculatorNoImp;
import com.atguigu.springlearn.aop.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class AopTests {

	@Autowired
	private CalculatorService calculatorDao;
	@Autowired
	private CalculatorProxy calculatorProxy;

	ApplicationContext ioc = new ClassPathXmlApplicationContext("aop.xml");

	@Test
	public void calculatorProxyTest() {
//		CalculatorService calculatorService = new CalculatorService();
//		CalculatorDao calculatorDaoProxy = CalculatorProxy.getProxy(calculatorService);
//		calculatorDaoProxy.add(1, 3);
//		calculatorDaoProxy.mul(2, 5);
//		calculatorDaoProxy.div(1, 0);

		CalculatorDao calculatorDaoProxy = (CalculatorDao) calculatorProxy.getE(calculatorDao);
		calculatorDaoProxy.add(1, 3);
		calculatorDaoProxy.mul(2, 5);
		calculatorDaoProxy.div(1, 0);
	}

	@Test
	public void aopWithInterfaceTest01(){

		/**！！！！！
		 * 如果某个容器中的类被spring aop修饰，被修饰的类通过spring ioc获取的时候一定要它的接口类型
		 * (个人猜测是：spring ioc管理被spring aop修饰的对象会在容器中直接保存该类的代理对象，spring以“被修饰类类名首字母小写”将代理对象保存在容器中，
		 * 所以对于代理类想通过 被代理类.class 获取明显是获取不到的，因为spring容器中压根不存在这个类型，所以被修饰的类通过spring ioc获取的时候一定要用它的接口类型，即它的父类类型，
		 * 但这样又会衍生出另外一个问题，当该接口类型存在不止一个子类的时候，ioc容器通过接口类型可以获得多个结果，ioc显然不能帮我们做出正确的选择，面对这种情况应该怎么处理呢？？？？？
		 * 答案是：ioc容器通过“被修饰类类名首字母小写”作为id来获取代理对象)
		 *
		 * 例如：
		 * CalculatorDao接口有两个实现类CalculatorService、CalulatorService02，其中CalculatorService被spring aop修饰，那么spring容器中会以calculatorService作为key保存CalculatorService代理对象
		 * 此时如果通过ioc.getBean(CalculatorService.class)没办法获取到CalculatorService对象，因为spring容器中只存在它的代理对象；
		 * 若想通过ioc.getBean(CalculatorDao.class)，企图利用CalculatorDao作为CalculatorService代理对象的父类来获取代理对象也是行不通的，因为CalculatorDao有两个子类，
		 * spring容器通过ioc.getBean(CalculatorDao.class)会获得多个结果，spring不知道该为用户选择哪个对象，
		 * 所以正确做法是通过ioc.getBean("calculatorService")来获取代理对象，因为CalculatorService的代理对象会以calculatorService作为key保存在Spring容器中
		 */
		CalculatorDao calculatorService = (CalculatorDao) ioc.getBean("calculatorService");
		calculatorService.add(2,1 );
		System.out.println(calculatorService.getClass()+"\n"+calculatorService);
	}

	/**
	 * ！！！！！
	 * 若aop修饰的是一个没有任何接口的类型那么spring的cglib会为没有接口的组件创建代理对象，但是aop修饰的类存在接口的话spring就一定是通过接口来创建代理对象
	 * 那么通过容器获取对象的时候就一定要通过接口来接收获取到的对象；
	 */
	@Test
	void aopNoImpTest01(){
		CalculatorNoImp calculatorNoImp = (CalculatorNoImp) ioc.getBean("calculatorNoImp");
		calculatorNoImp.add(2,1 );
		System.out.println("===============");
		calculatorNoImp.div(4, 2);
//		int[][] stuGrades = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
//		System.out.println(Arrays.toString(stuGrades));
//		System.out.println(Arrays.deepToString(stuGrades));

	}
}
