package com.atguigu.springlearn.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 加了注解后，通过spring容器获取目标对象的时候，ID默认就是类名首字母小写；
 * 		通过在@Repository("XXX")中指定XXX的值来改变容器中ID的值；
 * 组件的作用域默认是单例；
 * 		通过@Scope("prototype")可以改变组件的作用域；
 *
 */
@Component
@Scope("prototype")
public class Book2 {

}
