package com.gigatechltd.pim.admin.model;

import java.util.Date;

public class BusinessUnitModel {
	private long id;
	private long companyId;
	private String companyName;
	private String unitName;
	private String shortName;
	private String hierarchy;
	private String status;
	private String userId;
	private Date createdAt;
	private Date updatedAt;
	public BusinessUnitModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessUnitModel(long id, long companyId, String companyName, String unitName, String shortName,
			String hierarchy, String status, String userId, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.companyName = companyName;
		this.unitName = unitName;
		this.shortName = shortName;
		this.hierarchy = hierarchy;
		this.status = status;
		this.userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}