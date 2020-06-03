package com.atguigu.springlearn.ioc.bean;

public class Book {

	private String author;
	private String bookName;

	public void bookInit(){
		System.out.println("book init....");
	}

	public void bookDestroy(){
		System.out.println("book destroy...");
	}

	public Book(String author, String bookName) {
		System.out.println("book construct...");
		this.author = author;
		this.bookName = bookName;
	}

	public Book() {
		super();
		System.out.println("Book create...");
	}

	@Override
	public String toString() {
		return "Book{" +
				"author='" + author + '\'' +
				", bookName='" + bookName + '\'' +
				'}';
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
