package com.atguigu.springlearn.aop.dao;

/**
 *！！！！！@Repository
 *一般不将接口加入到spring容器中，因为spring在扫描完项目后会为容器中的类型创建对象，明显接口是不可能创建出对象的；
 * 如果强制将接口加入到spring容器中会怎样呢？？？？？
 * 事实上可以给接口加上容器注解，而spring在扫描完整个项目后也不会为接口创建对象，
 * 相反这种为接口加上容器注解的行为相当于告诉spring在容器中可能有这种类型的组件；
 */

public interface CalculatorDao {
	int add(int i, int j);
	int sub(int i, int j);
	int mul(int i, int j);
	int div(int i, int j);
}
