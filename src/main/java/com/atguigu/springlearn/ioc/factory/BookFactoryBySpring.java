package com.atguigu.springlearn.ioc.factory;

import com.atguigu.springlearn.ioc.bean.Book;
import org.springframework.beans.factory.FactoryBean;

public class BookFactoryBySpring implements FactoryBean<Book> {
	@Override
	public Book getObject() throws Exception {
		System.out.println("BookFactoryBySpring Create...");
		Book book = new Book("XXX", "BookFactoryBySpring");
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
