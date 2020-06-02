package com.atguigu.springlearn.service;

import com.atguigu.springlearn.dao.Book2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Book2ServiceExt extends Book2Service {
	@Autowired
	private Book2Dao book2Dao;

	public void saveBook2(){
		System.out.println("Book2ServiceExt is calling Book2Dao saving book2....");
		book2Dao.saveBook2();
	}
}
