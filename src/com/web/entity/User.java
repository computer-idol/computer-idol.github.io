package com.web.entity;

public class User {
	int userID;
	String name;
	String pwd;
	String email;
	String registerTime;
    String account;
    String hobby;
    String Touxiang;
    int age;
    String sex;
    String qianming;
	public User() {
		super();
	}
	
	public User(int userID, String name,String email, String pwd, String registerTime, String account) {
		super();
		this.userID = userID;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.registerTime = registerTime;
		this.account = account;
	}
    
	public User(int userID, String name, String email, String pwd,String registerTime, String account, 
			 String sex,int age,String hobby,String qianming,String touxiang) {
		super();
		this.userID = userID;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.registerTime = registerTime;
		this.account = account;
		this.hobby = hobby;
		this.Touxiang = touxiang;
		this.age = age;
		this.sex = sex;
		this.qianming = qianming;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getTouxiang() {
		return Touxiang;
	}

	public void setTouxiang(String touxiang) {
		Touxiang = touxiang;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQianming() {
		return qianming;
	}

	public void setQianming(String qianming) {
		this.qianming = qianming;
	}
    
	

}
