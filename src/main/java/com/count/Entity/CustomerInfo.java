package com.count.Entity;

public class CustomerInfo {
	private int id;
	private String name;
	private String gender;
	private int age;
	private double weight;
	private double height;
	private int activityType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getActivityType() {
		return activityType;
	}
	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	public CustomerInfo(int id, String name, String gender, int age, double weight, double height, int activityType) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.activityType = activityType;
	}
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", weight="
				+ weight + ", height=" + height + ", activityType=" + activityType + "]";
	}
	public CustomerInfo() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	

}
