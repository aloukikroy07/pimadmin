package com.gigatechltd.pim.admin.model;

/// Created by taohid on 22 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@DynamicUpdate
@Entity
@Table(name = "T_ROLE_PERMISSIONS")
public class MenuPermissionModel {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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

    @Column(name = "MENU_ID")
    Integer menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "MENU_ID",
            insertable = false,
            updatable = false
    )
    @Fetch(FetchMode.JOIN)
    MenuModel menuModel;

    @Column(name = "IS_VIEW")
    Integer isView = 0;

    @Column(name = "IS_ADD")
    Integer isAdd = 0;

    @Column(name = "IS_EDIT")
    Integer isEdit = 0;

    @Column(name = "IS_DELETE")
    Integer isDelete = 0;

    @Column(name = "IS_PRINT")
    Integer isPrint = 0;

    @Column(name = "STATUS")
    Integer status = 1;

    @Column(name = "APPROVED_BY")
    Integer approvedBy = 1;

    @Column(name = "CREATED_AT")
    Date createdAt;

    @Column(name = "UPDATED_AT")
    Date updatedAt;

    public void update(MenuPermissionModel data) {
        this.isView = data.isView;
        this.isAdd = data.isAdd;
        this.isEdit = data.isEdit;
        this.isDelete = data.isDelete;
        this.isPrint = data.isPrint;
        this.status = data.status;
        this.updatedAt = new Date();
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Integer getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(Integer isAdd) {
        this.isAdd = isAdd;
    }

    public Integer getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
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
