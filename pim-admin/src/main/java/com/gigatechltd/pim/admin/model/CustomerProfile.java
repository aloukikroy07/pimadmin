package com.gigatechltd.pim.admin.model;

import java.sql.Date;
import java.sql.Timestamp;

public class CustomerProfile {
	private Integer id;
	private Integer applicationId;
	private String entityType;
	private String mobileNo;
	private String email;
	private Integer branchId;
	private Integer customerId;
	private String customerName;
	private String customerAddress;
	private String gender;
	private Integer postCode;
	private String nid;
	private String tinNo;
	private String password;
	private String idtpPin;
	private String idtpVid;
	private String appPassword;
	private String finName;
	private String primaryAccountNo;
	private Date birthDate;
	private Date registrationDate;
	private Timestamp activationDate;
	private Integer activatedBy;
	private String remarks;
	private Integer transCount;
	private Integer todayTransAmt;
	private Integer ticketSize;
	private Integer dailyLimit;
	private String status;
	private Timestamp createAt;
	private Timestamp updatedAt;
	
	public CustomerProfile() {
		super();
	}

	public CustomerProfile(Integer id, Integer applicationId, String entityType, String mobileNo, String email,
			Integer branchId, Integer customerId, String customerName, String customerAddress, String gender,
			Integer postCode, String nid, String tinNo, String password, String idtpPin, String appPassword,
			String finName, String primaryAccountNo, Date birthDate, Date registrationDate, Timestamp activationDate,
			Integer activatedBy, String remarks, Integer transCount, Integer todayTransAmt, Integer ticketSize,
			Integer dailyLimit, String status, Timestamp createAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.applicationId = applicationId;
		this.entityType = entityType;
		this.mobileNo = mobileNo;
		this.email = email;
		this.branchId = branchId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.gender = gender;
		this.postCode = postCode;
		this.nid = nid;
		this.tinNo = tinNo;
		this.password = password;
		this.idtpPin = idtpPin;
		this.appPassword = appPassword;
		this.finName = finName;
		this.primaryAccountNo = primaryAccountNo;
		this.birthDate = birthDate;
		this.registrationDate = registrationDate;
		this.activationDate = activationDate;
		this.activatedBy = activatedBy;
		this.remarks = remarks;
		this.transCount = transCount;
		this.todayTransAmt = todayTransAmt;
		this.ticketSize = ticketSize;
		this.dailyLimit = dailyLimit;
		this.status = status;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdtpPin() {
		return idtpPin;
	}

	public void setIdtpPin(String idtpPin) {
		this.idtpPin = idtpPin;
	}

	public String getAppPassword() {
		return appPassword;
	}

	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}

	public String getFinName() {
		return finName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}

	public String getPrimaryAccountNo() {
		return primaryAccountNo;
	}

	public void setPrimaryAccountNo(String primaryAccountNo) {
		this.primaryAccountNo = primaryAccountNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public Integer getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(Integer activatedBy) {
		this.activatedBy = activatedBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getTransCount() {
		return transCount;
	}

	public void setTransCount(Integer transCount) {
		this.transCount = transCount;
	}

	public Integer getTodayTransAmt() {
		return todayTransAmt;
	}

	public void setTodayTransAmt(Integer todayTransAmt) {
		this.todayTransAmt = todayTransAmt;
	}

	public Integer getTicketSize() {
		return ticketSize;
	}

	public void setTicketSize(Integer ticketSize) {
		this.ticketSize = ticketSize;
	}

	public Integer getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(Integer dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getIdtpVid() {
		return idtpVid;
	}

	public void setIdtpVid(String idtpVid) {
		this.idtpVid = idtpVid;
	}
	
	
	
}
