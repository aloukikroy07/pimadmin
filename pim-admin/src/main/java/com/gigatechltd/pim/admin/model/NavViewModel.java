package com.gigatechltd.pim.admin.model;

/// Created by taohid on 28 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import java.util.List;

public class NavViewModel extends MenuPermissionModel {

    public boolean isGroupMenu = false;
    public List<MenuPermissionModel> child;

    public NavViewModel(MenuPermissionModel menuPermissionModel) {
        this.id = menuPermissionModel.id;
        this.roleId = menuPermissionModel.roleId;
        this.roleModel = menuPermissionModel.roleModel;
        this.menuId = menuPermissionModel.menuId;
        this.menuModel = menuPermissionModel.menuModel;
        this.isView = menuPermissionModel.isView;
        this.isAdd = menuPermissionModel.isAdd;
        this.isEdit = menuPermissionModel.isEdit;
        this.isDelete = menuPermissionModel.isDelete;
        this.isPrint = menuPermissionModel.isPrint;
        this.status = menuPermissionModel.status;
        this.approvedBy = menuPermissionModel.approvedBy;
        this.createdAt = menuPermissionModel.createdAt;
        this.updatedAt = menuPermissionModel.updatedAt;
    }

    public boolean isGroupMenu() {
        return isGroupMenu;
    }

    public void setGroupMenu(boolean group) {
        isGroupMenu = group;
    }

    public List<MenuPermissionModel> getChild() {
        return child;
    }

    public void setChild(List<MenuPermissionModel> child) {
        this.child = child;
    }
}
