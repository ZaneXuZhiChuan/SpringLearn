package com.atguigu.springlearn.aop.utils;

import com.atguigu.springlearn.aop.service.CalculatorNoImp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LogUtilsNoImp {

	/**
	 * 虽然通过@Aspect、@Before、@After、@AfterReturning、@AfterThrowing等注解将通知方法插入到目标位置，
	 * 但到目前还没解决的一个问题是通知方法如何获取被代理对象的信息？？？？？
	 * 答案：通知方法中的JointPoint参数对象封装了被代理对象的所有信息，所以可以通过JointPoint获取获取被代理对象的信息；
	 * 		joinPoint.getSignature()可以获取被切面的方法签名信息，方法签名信息中包含了被切面方法的名字、所属类的类型等信息
	 * 		joinPoint.getTarget()获取被切面方法所属的对象信息
	 *
	 * 	虽然通过上面的方式可以获取被切面的方法信息和所属类以及对象的信息，但还有两个问题，即如何在通知方法中获取被切面方法的执行结果？？？？？
	 * 	以及如果被切面方法执行过程中出现异常，要如何获取异常信息？？？？？
	 * 	答案：在@AfterReturning注解中还存在一个returning的定义，所以可以通过指定@AfterReturning(returning="XXX")指定接收被切面方法执行结果的对象，具体操作看下面示例；
	 *		  在@AfterThrowing注解中存在throwing定义，可以通过@AfterThrowing(throwing="XXX")指定接收被切面方法执行过程中产生异常的对象，具体操作看下面示例；
	 *
	 * 目前为止我们通知方法中的参数都和spring注解中定义的内容绑定在一起，例如：
 *		@AfterReturning(value = "XXX",returning = "result")
		public static void logEnd(JoinPoint joinPoint, Object result){
			"......."
		}
	 * returning指定了一个“result”字符串，那么“result”必定和通知方法logEnd()方法中的Object result参数相对应，
	 * 那么有一个问题我们可以不可以在通知方法中指定一个不与@AfterReturning绑定在一块的参数呢？？？？？
	 * 答案：不可以，spring aop对通知方法唯一的约束就是参数，因为spring aop的通知方法并不是我们主动去调用而是交给spring帮我们在合适的时机进行调用，
	 * 		 当出现spring aop无法识别的参数时候spring奖没有办法去执行通知方法，所以通知方法中的参数一定要通过某种方式告知spring！！！！！
	 */
	@Before("execution(public int com.atguigu.springlearn.aop.service.CalculatorNoImp.*(int, int))")
	public static void logStart(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		Signature sigNature = joinPoint.getSignature();
//		System.out.println("------"+sigNature.getDeclaringTypeName()+"------"+sigNature.getDeclaringType()+"------"+
//		sigNature.getName()+"------"+sigNature.getModifiers()+"------"+sigNature.getClass());
//		CalculatorNoImp calculatorNoImp = (CalculatorNoImp) joinPoint.getTarget();
//		System.out.println("*************"+calculatorNoImp.mul(5, 6));
		System.out.println("Before invoke :【" +joinPoint.getSignature().getName() + "】,Args:【" + Arrays.asList(args) + "】");
	}

	@After("execution(public int com.atguigu.springlearn.aop.service.CalculatorNoImp.*(int, int))")
	public static void logResult(JoinPoint joinPoint)
	{
		System.out.println("After :【" + joinPoint.getSignature().getName() + "】" );
	}

	/**
	 * 通过returning="XXX"指定接收结果集的参数对象
	 */
	@AfterReturning(value = "execution(public int com.atguigu.springlearn.aop.service.CalculatorNoImp.*(int, int))",
	returning = "result")
	public static void logEnd(JoinPoint joinPoint, Object result){
		System.out.println("AfterReturning:【"+joinPoint.getSignature().getName()+"】"+result);
	}

	/**
	 * 通过throwing="XXX"指定接收异常的参数对象
	 */
	@AfterThrowing(value = "execution(public int com.atguigu.springlearn.aop.service.CalculatorNoImp.*(int, int))",throwing="exception")
	public static void logException(JoinPoint joinPoint, Exception exception){
		System.out.println("AfterThrowing："+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())+"【"+joinPoint.getSignature().getName()+
				"】 exception cause:"+exception);
	}
}
