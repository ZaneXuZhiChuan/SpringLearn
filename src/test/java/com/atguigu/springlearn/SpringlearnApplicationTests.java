package com.atguigu.springlearn;

import com.atguigu.springlearn.bean.Book;
import com.atguigu.springlearn.bean.Car;
import com.atguigu.springlearn.bean.Person;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * 实验1：通过IOC容器创建对象，并为属性赋值★
 * 实验2：根据bean的类型从IOC容器中获取bean的实例★
 * <p>
 * 实验3：
 * 通过构造器为bean的属性赋值（index,type属性介绍）
 * 通过p名称空间为bean赋值
 * <p>
 * 实验4：正确的为各种属性赋值
 * 测试使用null值 、
 * 引用类型赋值（引用其他bean、引用内部bean）
 * 集合类型赋值（List、Map、Properties）、
 * util名称空间创建集合类型的bean
 * 级联属性赋值
 * <p>
 * <p>
 * ====================工厂方式创建bean==========
 * 实验5：配置通过静态工厂方法创建的bean、实例工厂方法创建的bean、FactoryBean★
 * <p>
 * <p>
 * 实验6：通过继承实现bean配置信息的重用
 * 实验7：通过abstract属性创建一个模板bean
 * 实验8：bean之间的依赖
 * 实验9：测试bean的作用域，分别创建单实例和多实例的bean★
 * <p>
 * <p>
 * <p>
 * 实验10：创建带有生命周期方法的bean
 * 实验11：测试bean的后置处理器
 * <p>
 * 实验12：引用外部属性文件★
 * 实验13：基于XML的自动装配
 * <p>
 * <p>
 * 实验14：[SpEL测试I]
 * 在SpEL中使用字面量、
 * 引用其他bean、
 * 引用其他bean的某个属性值、
 * 调用非静态方法
 * 调用静态方法、
 * 使用运算符
 */

@SpringBootTest
class SpringlearnApplicationTests {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");

	private void getBeanAndPrint(String indexStr) {
		System.out.println(applicationContext.getBean(indexStr));
	}

	@Test
	void contextLoads() {
		System.out.println(applicationContext.getBean("person01"));
	}

	//	实验2：根据bean的类型从IOC容器中获取bean的实例★
	@Test
	void test02() {
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
	}

	//	通过构造器为bean的属性赋值（index,type属性介绍）
	@Test
	void test0301() {
		Person person03 = (Person) applicationContext.getBean("person0301");
		System.out.println(person03);
	}

	//	通过p名称空间为bean赋值
	@Test
	void test0302() {
		getBeanAndPrint("person0302");
	}

	/**
	 * =================================================================================================================
	 * 实验4：正确的为各种属性赋值——引用类型赋值（引用其他bean、引用内部bean）
	 */
	@Test
	void test0401() {
		Person person0401 = (Person) applicationContext.getBean("person0401");  // 在xml文件中通过ref引用为Person内部持有的Car类型赋值，
		System.out.println(person0401);                                               // 本质上和通过applicationContext获取xml中获取到的Car对象是同一个对象
		Car car0401 = (Car) applicationContext.getBean("car0401");               // 所以更改Car对象的值也会改变Person对象的值；
		car0401.setCarName("Audi");
		System.out.println(person0401);
	}
	/**
	 * 集合类型赋值（List、Map、Properties）、
	 */
	@Test
	void test0402() {
		getBeanAndPrint("person0402");
	}
	/*
	util名称空间创建集合类型的bean
	通过abstract属性创建一个模板bean
	 */
	@Test
	void test0403(){
		getBeanAndPrint("person0403");
	}
	/**
	 * 级联属性赋值
	 */
	@Test
	void test0404(){
		getBeanAndPrint("person0404");
		System.out.println(applicationContext.getBean("car0401"));
	}

//	实验5：配置通过静态工厂方法创建的bean=========================================
	@Test
	void test0501(){
		getBeanAndPrint("car0501");
	}
//	实例工厂方法创建的bean、FactoryBean★
	@Test
	void test0502(){
		getBeanAndPrint("car0502");
	}

//	实现Spring的FactoryBean进行工厂创建目标对象
	@Test
	void BookFactoryBySpringTest() {
//		getBeanAndPrint("BookFactoryBySpring");
		Book bookFactoryBySpring1 = (Book) applicationContext.getBean("BookFactoryBySpring");
		Object bookFactoryBySpring2 = applicationContext.getBean("BookFactoryBySpring");
		System.out.println(":"+bookFactoryBySpring1);
	}

	/**
	 * TODO 实验10：创建带有生命周期方法的bean
	 * TODO 实验11：测试bean的后置处理器
	 * 没有测试出来预期结果
	 */
	@Test
	void test1001(){
		Book book1001 = (Book) applicationContext.getBean("book1001");
	}

	/**
	 * 实验12：引用外部属性文件★
	 */
	@Test
	void comboPooledDataSourceTest(){
//		DataSource comboPooledDataSource = (DataSource) applicationContext.getBean("comboPooledDataSource");
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
	}

	/**
	 * 实验14：[SpEL测试I]
	 在SpEL中使用字面量、
	 引用其他bean、
	 引用其他bean的某个属性值、
	 调用非静态方法
	 调用静态方法、
	 使用运算符
	 */
	@Test
	void test1401(){
		getBeanAndPrint("person1401");
	}

}
