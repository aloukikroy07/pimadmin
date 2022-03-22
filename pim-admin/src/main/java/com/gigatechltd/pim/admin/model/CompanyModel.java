package com.gigatechltd.pim.admin.model;

public class CompanyModel {
	private long id;
	private long bankId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String postCode;
	private String country;
	private String phoneNo;
	private String email;
	private String website;
	private char status;
	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyModel(long id, long bankId, String name, String address, String city, String state, String postCode,
			String country, String phoneNo, String email, String website, char status) {
		super();
		this.id = id;
		this.bankId = bankId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.country = country;
		this.phoneNo = phoneNo;
		this.email = email;
		this.website = website;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	
}