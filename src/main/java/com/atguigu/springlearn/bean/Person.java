package com.atguigu.springlearn.bean;

public class Person {
	private String lastName;
	private String age;
	private String gender;
	private String email;

	public Person() {}

	public Person(PersonBuilder personBuilder) {
		this.lastName = personBuilder.lastName;
		this.age = personBuilder.age;
		this.gender = personBuilder.gender;
		this.email = personBuilder.email;
	}

	public static class PersonBuilder{
		private String lastName;
		private String age;
		private String gender;
		private String email;

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

		public Person build(){
			return new Person(this);
		}
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

	@Override
	public String toString() {
		return "Person{" +
				"lastName='" + lastName + '\'' +
				", age='" + age + '\'' +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				'}';
	}

}
