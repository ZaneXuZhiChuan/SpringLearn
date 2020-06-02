package com.atguigu.springlearn.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private String lastName;
	private String age;
	private String gender;
	private String email;
	private Double salary;

	private Car car;
	private List<Book> bookList;
	private Map<String, Object> maps;
	private Properties properties;

	public Person() {
		super();
		System.out.println("create Person。。。");
	}

	public Person(String lastName, String age, String gender, String email, Car car, List<Book> bookList, Map<String, Object> maps, Properties properties) {
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.car = car;
		this.bookList = bookList;
		this.maps = maps;
		this.properties = properties;
	}

	public Person(String lastName, String age, String gender, String email, Double salary, Car car, List<Book> bookList, Map<String, Object> maps, Properties properties) {
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.salary = salary;
		this.car = car;
		this.bookList = bookList;
		this.maps = maps;
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Person{" +
				"lastName='" + lastName + '\'' +
				", age='" + age + '\'' +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				", salary=" + salary +
				", car=" + car +
				", bookList=" + bookList +
				", maps=" + maps +
				", properties=" + properties +
				'}';
	}

	/**
	 * 为实验3准备的构造方法
	 * 实验3：通过构造器为bean的属性赋值（index,type属性介绍）
	 */
	public Person(String lastName, String age, String gender, String email) {
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public Person(PersonBuilder personBuilder) {
		this.lastName = personBuilder.lastName;
		this.age = personBuilder.age;
		this.gender = personBuilder.gender;
		this.email = personBuilder.email;
		this.car = personBuilder.car;
		this.bookList = personBuilder.bookList;
		this.maps = personBuilder.maps;
		this.properties = personBuilder.properties;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public static class PersonBuilder {
		private String lastName;
		private String age;
		private String gender;
		private String email;
		private Car car;
		private List<Book> bookList;
		private Map<String, Object> maps;
		private Properties properties;
		private Double salary;

		public PersonBuilder salary(Double salary) {
			this.salary = salary;
			return this;
		}
		public PersonBuilder car(Car car) {
			this.car = car;
			return this;
		}

		public PersonBuilder bookList(List<Book> bookList) {
			this.bookList = bookList;
			return this;
		}

		public PersonBuilder maps(Map<String, Object> maps) {
			this.maps = maps;
			return this;
		}

		public PersonBuilder properties(Properties properties) {
			this.properties = properties;
			return this;
		}

		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PersonBuilder age(String age) {
			this.age = age;
			return this;
		}

		public PersonBuilder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public PersonBuilder email(String email) {
			this.email = email;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

}
