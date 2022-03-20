package com.gigatechltd.pim.admin.model;

import javax.persistence.*;
import java.util.Date;

/// Created by taohid on 22 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

@Entity
@Table(name = "T_ROLES")
public class RoleModel {
    
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_ID")
    Integer companyId;

    @Column(name = "NAME")
    String name;

    @Column(name = "STATUS")
    Integer status = 1;

    @Column(name = "CREATED_AT")
    Date createdAt;

    @Column(name = "UPDATED_AT")
    Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}