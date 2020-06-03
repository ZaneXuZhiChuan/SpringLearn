package com.atguigu.springlearn;

import com.atguigu.springlearn.bean.Book2;
import com.atguigu.springlearn.controller.Book2Controller;
import com.atguigu.springlearn.service.Book2Service;
import com.atguigu.springlearn.service.Book2ServiceExt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootTest
class IocWithAnnotationTests {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc-with-annotation.xml");

	private void getBeanAndPrint(String indexStr) {
		System.out.println(applicationContext.getBean(indexStr));
	}

	@Test
	void contextLoads() {
		Book2 book01 = (Book2) applicationContext.getBean("book2");
		Book2 book02 = (Book2) applicationContext.getBean("book2");
		System.out.println((book01==book02)+"\nbook01:"+book01+"\nbook02:"+book02);
		Book2Controller book2Controller = (Book2Controller) applicationContext.getBean("book2Controller");
		System.out.println("bookController:"+ book2Controller);
	}

	/**
	 * 实验18：使用@Autowired注解实现根据类型实现自动装配★
	 */
	@Test
	void AutowiredBeanTest(){
		applicationContext.getBean(Book2Controller.class).doGet();
	}

	/**
	 * spring的单元测试会自动帮我们去扫描项目并将加了注解的类加入到spring容器中进行管理，
	 * 也就是说使用spring的单元测试我们其实不再需要通过ioc.getBean()去获取组件，而可以直接通过@Autowired的方式去获取组件！！！！！
	 * 基于spring单元测试这种特性，我们这个测试方法虽然什么都没做，但其实spring会自动帮我们创建Book2Controller对象，
	 * 而又因为再Book2Controller类型中我们对doSomething()方法进行了@Autowired的修饰，所以在创建好Book2Controller对象的时候，doSomething()也会自动执行！！！！！
	 */
	@Autowired
	Book2Controller book2Controller;
	@Test
	void AutowiredMethodTest(){}

	/**
	 * 实验23：测试泛型依赖注入★
	 */
}
