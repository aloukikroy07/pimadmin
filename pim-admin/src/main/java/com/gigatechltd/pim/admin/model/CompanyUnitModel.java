package com.gigatechltd.pim.admin.model;

public class CompanyUnitModel {
	private long id;
	private long companyId;
	private String companyName;
	private long businessUnitId;
	private String businessUnitName;
	private long parentId;
	private String name;
	private String shortName;
	private String address;
	private String city;
	private String state;
	private String postCode;
	private String country;
	private String phoneNo;
	private String email;
	private String website;
	private String reportTo;
	private String approvalAuthority;
	private String headedBy;
	private String secondMan;
	public CompanyUnitModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyUnitModel(long id, long companyId, String companyName, long businessUnitId, String businessUnitName,
			long parentId, String name, String shortName, String address, String city, String state, String postCode,
			String country, String phoneNo, String email, String website, String reportTo, String approvalAuthority,
			String headedBy, String secondMan) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.companyName = companyName;
		this.businessUnitId = businessUnitId;
		this.businessUnitName = businessUnitName;
		this.parentId = parentId;
		this.name = name;
		this.shortName = shortName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.country = country;
		this.phoneNo = phoneNo;
		this.email = email;
		this.website = website;
		this.reportTo = reportTo;
		this.approvalAuthority = approvalAuthority;
		this.headedBy = headedBy;
		this.secondMan = secondMan;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getBusinessUnitId() {
		return businessUnitId;
	}
	public void setBusinessUnitId(long businessUnitId) {
		this.businessUnitId = businessUnitId;
	}
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
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
	public String getReportTo() {
		return reportTo;
	}
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}
	public String getApprovalAuthority() {
		return approvalAuthority;
	}
	public void setApprovalAuthority(String approvalAuthority) {
		this.approvalAuthority = approvalAuthority;
	}
	public String getHeadedBy() {
		return headedBy;
	}
	public void setHeadedBy(String headedBy) {
		this.headedBy = headedBy;
	}
	public String getSecondMan() {
		return secondMan;
	}
	public void setSecondMan(String secondMan) {
		this.secondMan = secondMan;
	}
}
