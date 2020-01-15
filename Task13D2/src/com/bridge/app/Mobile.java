package com.bridge.app;

import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mobilerecords")
@SessionScoped
public class Mobile {

	private String companyname;
	private String modelnumber;
	private String color;
	private int quantity;
	private double price;
	public boolean[] data;
	   
	   public boolean getData() {
	      return data[0];
	   }

	   public void setData(boolean[] data) {
	      this.data = data;
	   }

	private static final ArrayList<Mobile> mobiles = 
			new ArrayList<Mobile>(
			Arrays.asList(
					new Mobile("Nokia", "N213", "Black", 10, 2500),
					new Mobile("Micromax", "A114", "White", 25, 9500),
					new Mobile("MotoG", "M345", "Grey", 40, 15300), 
					new Mobile("Samsung", "S-512", "Blue", 15, 11000)
					));

	public ArrayList<Mobile> getMobiles() {
		return mobiles;
	}

	public Mobile() {
	}

	public Mobile(String companyname, String modelnumber, String color,
			int quantity, double price) {
		this.companyname = companyname;
		this.modelnumber = modelnumber;
		this.color = color;
		this.quantity = quantity;
		this.price = price;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getModelnumber() {
		return modelnumber;
	}

	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}