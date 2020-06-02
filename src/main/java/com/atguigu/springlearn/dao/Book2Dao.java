package com.atguigu.springlearn.dao;

import com.atguigu.springlearn.bean.Book2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Book2Dao {

	@Autowired
	private Book2 book2;

	public void saveBook2(){
		System.out.println("save one book2..." + book2);
	}

}
