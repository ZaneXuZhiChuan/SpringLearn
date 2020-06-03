package com.atguigu.springlearn.ioc.controller;

import com.atguigu.springlearn.ioc.dao.Book2Dao;
import com.atguigu.springlearn.ioc.service.Book2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Book2Controller {

	/**
	 * 自动装配，其实是加了四个注解中的类被spring容器管理，
	 * 之后spring内部通过反射为加了@Autowired的对象创建空参的构造实例，之后我们就用这个空参构造实例对象去调用类中封装的方法；
	 *  spring找寻对应组件过程：
	 *  1.先按照类型去容器中查找对应的组件，在这个过程中会将该组件类型+该组件所有子类型都匹配到，
	 *    这就会产生一个问题，例如Book2Service还存在一个子类Book2ServiceExt，那么spring肯定会在容器中同时找到这两个类型，
	 *    这时spring应该匹配哪一个类型去构造对象呢？？？？？
	 *  2.spring在面对在容器中同时找到多个类型的时候，接下来会将变量名作为id继续进行匹配
	 *    (事实上在IDEA中当你在给变量起名字的时候若是spring容器中只有一个类型，那么IDEA允许随便起名字；
	 *     若是容器中存在多个被定义为同类型的bean时，变量名必须满足首字母为对应变量名的小写，若不满足IDEA会直接进行报错，编译不通过
	 *		比如：在本项目中同时存在Book2Service、Book2ServiceExt、Book2ServiceExt2，那么
	 *		@Autowired
			private Book2Service book2ServiceExt
			中Book2Service的变量名就该满足规则，即book2Service、book2ServiceExt或book2Service2，除此之外都会报错
	 *     )
	 *     (-----实验20：如果根据成员变量名作为id还是找不到bean，可以使用@Qualifier注解明确指定目标bean的id★-----)
	 *     但是这又会衍生出一个问题，即当前这个定义好的变量在项目中已经在多处投入使用了，但是这个时候因为某种原因，
	 *     我要更改该变量名来达到使用容器中同属该变量类型的另一个类型的目的，这个时候如果一个一个去更改项目中已经被多处使用的变量名显然是不合适的，
	 *     那么从spring的角度出发应该怎么解决这个问题呢？？？？？
	 *     spring给出的答案是使用@Qualifier("XXX")注解来指定一个名作为spring在容器中进行查找的id，更改掉spring默认使用变量名作为id去容器中寻找的行为；
	 *     但是Qualifier也会面临一个和上述类似的问题，即万一@Qualifier("XXX")中也没有装配上spring容器中对象会发生什么情况？？？？？
	 *     答案是：会报错，而在IDEA中会和直接使用@Autowired一样，若是在@Qualifier("XXX")中命名不满足规则，IDEA会直接报错，编译不通过
	 */
	@Qualifier("book2Service")
	@Autowired
	private Book2Service book2ServiceExt;

	public void doGet(){
		book2ServiceExt.saveBook2();
	}

	/**
	 * 实验21：
	 * 在方法的形参位置使用@Qualifier注解
	 * 那么该方法中所有参数都会按照spring自动注入的规则注入进来，
	 * 注意：加了@Autowired的方法会在当前类被创建的时候自动运行！！！！！也就是说加了@Autowired的方法不需要我们手动调用
	 */
	@Autowired
	public void doSomething(@Qualifier("book2ServiceExt2e") Book2Service book2ServiceExt, Book2Dao book2Dao){
		book2ServiceExt.saveBook2();
		System.out.printf("--------------"+book2Dao);
	}
}
