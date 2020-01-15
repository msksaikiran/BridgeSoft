package com.bfs.app;

import java.io.Serializable;

public class Employee implements Serializable {
	String empName;
    String add;
    int empId;
    
	public Employee(String empName, String add, int empId) {
		this.empName = empName;
		this.add = add;
		this.empId = empId;
	}

	/*@Override
	public String toString() {
		return "Employee 1:empName....>" + empName
				+ "\n\tadd.....>" + add 
				+ "\n\tempId....>" + empId ;
	}*/
	public void m1()
	{
		System.out.println("empname:"+this.empName);
		System.out.println("empId;"+this.empId);
		System.out.println("add;"+this.add); 
	}
}
