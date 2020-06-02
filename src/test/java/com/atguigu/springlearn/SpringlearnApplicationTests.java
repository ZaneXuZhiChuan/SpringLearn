package com.atguigu.springlearn;

import com.atguigu.springlearn.bean.Car;
import com.atguigu.springlearn.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * <p>
 * <p>
 * <p>
 * 实验15：通过注解分别创建Dao、Service、Controller★
 * 实验16：使用context:include-filter指定扫描包时要包含的类
 * 实验17：使用context:exclude-filter指定扫描包时不包含的类
 * <p>
 * <p>
 * 实验18：使用@Autowired注解实现根据类型实现自动装配★
 * 实验19：如果资源类型的bean不止一个，
 * 默认根据@Autowired注解标记的成员变量名作为id查找bean，进行装配★
 * 实验20：如果根据成员变量名作为id还是找不到bean，
 * 可以使用@Qualifier注解明确指定目标bean的id★
 * 实验21：在方法的形参位置使用@Qualifier注解
 * 实验22：@Autowired注解的required属性指定某个属性允许不被设置
 * <p>
 * 实验23：测试泛型依赖注入★
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
}
