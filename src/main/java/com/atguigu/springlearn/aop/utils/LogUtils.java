package com.atguigu.springlearn.aop.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.通过@Aspect告知spring容器哪个类属于切面类(@Aspect注解需要在pom.xml文件中加入spring-boot-starter-aop依赖)，
 * 	 要想spring aop功能生效还要求切面类被加入到spring容器中，即要被容器注解修饰；！！！！！
 * 2.告知切面类中的切面方法分别在什么时刻运行？？？？？(要清楚spring将方法调用过程分为四个横切关注点：方法开始、方法返回、方法异常、方法结束)
 * 	 spring通过5个通知注解来告知切面类中的切面方法分别在什么方法的哪个调用过程中进行，分别是：
 * 	   @Before：在目标方法z前运行						前置通知
 * 	   @After：在目标方法结束之后						后置通知
 * 	   @AfterReturning：在目标方法正常返回之后			返回通知
 * 	   @Afterthrowing：在目标方法抛出异常之后运行		异常通知
 * 	   @Around:	环绕										环绕通知(最强大的通知注解)
 * 	分别对应Java动态代理过程：
 * 		try {
 			@Before
			method .invoke(obi,args);
			@AfterReturning
		}catch(Exception e){
			@Afterthrowing
		}Finally{
 			@After
		}
 *
 */
@Aspect
@Component
public class LogUtils {

	@Before("execution(public int com.atguigu.springlearn.aop.service.CalculatorService.*(int, int))")
	public static void logStart() {
		System.out.println("Before invoke :【" +"XXX" + "】,Args:【" + "XXX" + "】");
	}

	@After("execution(public int com.atguigu.springlearn.aop.service.CalculatorService.*(int, int))")
	public static void logResult() {
		System.out.println("Result :【" + "XXX" + "】" );
	}

	@AfterReturning("execution(public int com.atguigu.springlearn.aop.service.CalculatorService.*(int, int))")
	public static void logEnd(){
		System.out.println("Method End:【"+"XXX"+"】");
	}

	@AfterThrowing("execution(public int com.atguigu.springlearn.aop.service.CalculatorService.*(int, int))")
	public static void logException(){
		System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())+"【"+"XXX"+"】 exception cause:"+"XXX");
	}
}
