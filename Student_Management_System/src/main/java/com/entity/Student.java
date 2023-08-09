package com.entity;

public class Student {
	private int id;
	private String fullname;
	private String dob;
	private String address;
	private String qualification;
	private String email;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String fullname, String dob, String address, String qualification, String email) {
		super();
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}
	
	public Student(int id, String fullname, String dob, String address, String qualification, String email) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", address=" + address
				+ ", qualification=" + qualification + ", email=" + email + "]";
	}
	
}
