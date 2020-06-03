package com.atguigu.springlearn.ioc.bean;

public class Car {
	private String carName;
	private String color;
	private Integer price;

	public Car(String carName, String color, Integer price) {
		this.carName = carName;
		this.color = color;
		this.price = price;
	}

	public Car() {
		super();
		System.out.println("Car create...");
	}

	@Override
	public String toString() {
		return "Car{" +
				"carName='" + carName + '\'' +
				", color='" + color + '\'' +
				", price=" + price +
				'}';
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
