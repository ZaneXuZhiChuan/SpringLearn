package com.atguigu.springlearn.factory;

import com.atguigu.springlearn.bean.Book;
/*
实例工厂：需要通过创建该工程实例才能创建对象
 */
public class BookInstanceFactory {
	public Book getBook(String bookName) {
		System.out.println("BookInstanceFactory Working ...");
		Book book = new Book();
		book.setAuthor("GuLong");
		book.setBookName(bookName);
		return book;
	}
}
