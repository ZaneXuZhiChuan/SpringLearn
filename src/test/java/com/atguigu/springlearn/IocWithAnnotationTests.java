package com.atguigu.springlearn;

import com.atguigu.springlearn.bean.Book2;
import com.atguigu.springlearn.controller.Book2Controller;
import org.junit.jupiter.api.Test;
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
	void AutowiredTest(){
		applicationContext.getBean(Book2Controller.class).doGet();
	}



}
