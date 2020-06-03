package com.atguigu.springlearn.ioc.service;

import com.atguigu.springlearn.ioc.dao.Book2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Book2Service {

	@Autowired
	private Book2Dao book2Dao;

	public void saveBook2(){
		System.out.println("Book2Service is calling Book2Dao saving book2....");
		book2Dao.saveBook2();
	}
}
