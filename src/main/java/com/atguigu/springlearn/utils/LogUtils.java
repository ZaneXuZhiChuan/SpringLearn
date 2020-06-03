package com.atguigu.springlearn.utils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {

	public static void logStart(Method method, Object[] args) {
		System.out.println("Before invoke :【" + method.getName() + "】,Args:【" + args + "】");
	}

	public static void logResult(Object result) {
		System.out.println("Result :【" + result + "】" );
	}

	public static void logException(Exception e,Method method){
		System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())+"【"+method.getName()+"】 exception cause:"+e.getCause());
	}
}
