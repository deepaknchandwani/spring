package com.deepakchandwani.entity;

public class Employee {
private int CUST_ID;
	
	private String name;
	
	private int age;

	public Employee(){
		
	}
	
	public Employee(int id, String name, int age) {
		this.CUST_ID = id;
		this.name = name;
		this.age = age;
	}

	public int getCUST_ID() {
		return CUST_ID;
	}

	public void setCUST_ID(int cUST_ID) {
		CUST_ID = cUST_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [CUST_ID=" + CUST_ID + ", name=" + name + ", age="
				+ age + "]";
	}

 

	 

}
