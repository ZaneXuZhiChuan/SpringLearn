package com.atguigu.springlearn.factory;

import com.atguigu.springlearn.bean.Book;
/*
静态工厂：通过静态方法直接创建对象
 */
public class BookStaticFactory {

	public static Book getBook(String bookName){
		System.out.println("BookStaticFactory Working ...");
		Book book = new Book();
		book.setAuthor("GuLong");
		book.setBookName(bookName);
		return book;
	}

}
