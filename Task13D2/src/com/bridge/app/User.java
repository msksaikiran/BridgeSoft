package com.bridge.app;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="user")
@SessionScoped
public class User  {
	

	private String item;
	private boolean flag;
    private boolean checkbox=false;
    private String type;
    private String report;
    private String password;
    private String name;
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("name::"+name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("password::"+password);
	}

	public String getItem() {
		return item;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		System.out.println("flage::"+flag);
	}

	public void setItem(String item) {
		this.item = item;
		System.out.println("item:::"+item);
	}


	public String items() {
		return "one";
	}

	
	public boolean isCheckbox() {
		System.out.println("value"+checkbox);
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
		System.out.println("checkbox::"+checkbox);
		System.out.println("***********");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		System.out.println("type::"+type);
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
		System.out.println("report::"+report);
	}

	public boolean verify() {
		//System.out.println(item);
		if (item.equals("LCEExection") || item.equals("List")) {
			setFlag(true);
			System.out.println("***************");
			return true;
		} else {
			setFlag(false);
		}
		return false;
	}
	
}
