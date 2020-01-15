package com.bridge.app;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "resultuser")
@SessionScoped
public class Resultuser {

	/*private String item;
	private boolean flag;*/
	
	private String type;
	private String username;
	private String password;
	private String confirmpassword;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String managerName;
	private String displayName;
	private String orgcode;
	private String apptType;
	private String message;
	private String status;
	private String view1;
	private String verify1;
	private String verify2;
	private String attribute;
	private boolean checkbox;
	
	
	/*public String getItem() {
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
	
	public boolean verify() {
		//System.out.println(item);
		if (item.equals("LCEExection") || item.equals("List")) {
			setFlag(true);
			//System.out.println(flag);
			return true;
		} else {
			setFlag(false);
		}
		return false;
	}
	*/
	
	
	public String getType() {
		return type;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getApptType() {
		return apptType;
	}
	public void setApptType(String apptType) {
		this.apptType = apptType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getView1() {
		return view1;
	}
	public void setView1(String view1) {
		this.view1 = view1;
	}
	public String getVerify1() {
		return verify1;
	}
	public void setVerify1(String verify1) {
		this.verify1 = verify1;
	}
	public String getVerify2() {
		return verify2;
	}
	public void setVerify2(String verify2) {
		this.verify2 = verify2;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
}
