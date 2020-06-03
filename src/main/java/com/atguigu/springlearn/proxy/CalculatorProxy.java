package com.atguigu.springlearn.proxy;

import com.atguigu.springlearn.dao.CalculatorDao;
import com.atguigu.springlearn.utils.LogUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class CalculatorProxy<T> {

	public static CalculatorDao getProxy(CalculatorDao calculatorDao) {
		ClassLoader loader = calculatorDao.getClass().getClassLoader();
		Class<?>[] interfaces = calculatorDao.getClass().getInterfaces();
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				try {
					LogUtils.logStart(method,args);
//				result:目标方法执行完后的返回值；
					result = method.invoke(calculatorDao, args);
//				返回值必须返回出去外界才能拿到执行后的结果；
				}catch (Exception e){
					LogUtils.logException(e,method );
				}finally {
					LogUtils.logResult(result);
					return result;
				}

			}
		};
		Object object = Proxy.newProxyInstance(loader, interfaces, handler);
		return (CalculatorDao) object;
	}

	/**
	 * 利用泛型为传入的对象创建一个代理对象；
	 */
	public <E>E getE(T t) {
		ClassLoader loader = t.getClass().getClassLoader();
		Class<?>[] interfaces = t.getClass().getInterfaces();
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				try {
					LogUtils.logStart(method,args);
//				result:目标方法执行完后的返回值；
					result = method.invoke(t, args);
//				返回值必须返回出去外界才能拿到执行后的结果；
				}catch (Exception e){
					LogUtils.logException(e,method );
				}finally {
					LogUtils.logResult(result);
					return result;
				}

			}
		};
		Object object = Proxy.newProxyInstance(loader, interfaces, handler);
		return (E)object;
	}
}
