package com.joya.user.domain;

public class User {
	
	private String email;
	private String phone;
	private String name;
	private String passwd;
	private String address;
	private int point;
	private String birthdate;
	private int type;
	private String regdate;
	
	public User() {}
	
	public User(String email, String phone, String name, String passwd, String address) {
		this(email, phone, name, passwd, address, 0, null, 0, null);
	}
	
	public User(String email, String phone, String name, String passwd, String address, int point, String birthdate,
			int type, String regdate) {
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.passwd = passwd;
		this.address = address;
		this.point = point;
		this.birthdate = birthdate;
		this.type = type;
		this.regdate = regdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", phone=" + phone + ", name=" + name + ", passwd=" + passwd + ", address="
				+ address + ", point=" + point + ", birthdate=" + birthdate + ", type=" + type + ", regdate=" + regdate
				+ "]";
	}
	
}
