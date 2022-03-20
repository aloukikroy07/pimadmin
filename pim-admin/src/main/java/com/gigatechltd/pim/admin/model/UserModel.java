package com.gigatechltd.pim.admin.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/// Created by taohid on 22 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

@DynamicUpdate
@Entity
@Table(name = "T_USERS")
public class UserModel implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "COMPANY_UNIT_ID")
    Integer companyUnitId;

    @Column(name = "ROLE_ID")
    Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ROLE_ID",
            insertable = false,
            updatable = false
    )
    @Fetch(FetchMode.JOIN)
    RoleModel roleModel;

    @Column(name = "NAME", nullable = false)
    String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    String email;

    @Column(name = "EMAIL_VERIFIED_AT")
    Date emailVerifiedAt;

    @Column(name = "PHONE_VERIFIED_AT")
    Date phoneVerifiedAt;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "PASS_EXP_DATE")
    Date passExpDate;

    @Column(name = "PASS_EXP_PERIOD")
    Integer passExpPeriod = 3;

    @Column(name = "PASS_NEVER_EXP")
    Integer passNeverExp = 0;

    @Column(name = "PASSWORD_LOCK")
    Integer passwordLock = 0;

    @Column(name = "IP_ALLOW")
    String ipAllow;

    @Column(name = "WRONG_PASS_COUNT")
    Integer wrongPassCount = 0;

    @Column(name = "STATUS")
    Integer status = 1;

    @Column(name = "CREATED_AT")
    Date createdAt;

    @Column(name = "UPDATED_AT")
    Date updatedAt;

    @Column(name = "REMEMBER_TOKEN")
    String rememberToken;

    public void update(UserModel data) {
        this.name = data.name;
        this.email = data.email;
        this.status = data.status;
        this.roleId = data.roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCompanyUnitId() {
        return companyUnitId;
    }

    public void setCompanyUnitId(Integer companyUnitId) {
        this.companyUnitId = companyUnitId;
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Date emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }


    public Date getPhoneVerifiedAt() {
        return phoneVerifiedAt;
    }

    public void setPhoneVerifiedAt(Date phoneVerifiedAt) {
        this.phoneVerifiedAt = phoneVerifiedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getPassExpDate() {
        return passExpDate;
    }

    public void setPassExpDate(Date passExpDate) {
        this.passExpDate = passExpDate;
    }

    public Integer getPassExpPeriod() {
        return passExpPeriod;
    }

    public void setPassExpPeriod(Integer passExpPeriod) {
        this.passExpPeriod = passExpPeriod;
    }

    public Integer getPassNeverExp() {
        return passNeverExp;
    }

    public void setPassNeverExp(Integer passNeverExp) {
        this.passNeverExp = passNeverExp;
    }

    public Integer getPasswordLock() {
        return passwordLock;
    }

    public void setPasswordLock(Integer passwordLock) {
        this.passwordLock = passwordLock;
    }


    public String getIpAllow() {
        return ipAllow;
    }

    public void setIpAllow(String ipAllow) {
        this.ipAllow = ipAllow;
    }

    public Integer getWrongPassCount() {
        return wrongPassCount;
    }

    public void setWrongPassCount(Integer wrongPassCount) {
        this.wrongPassCount = wrongPassCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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


    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}