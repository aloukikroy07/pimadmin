package com.gigatechltd.pim.admin.service.menu;

import com.gigatechltd.pim.admin.model.MenuModel;
import com.gigatechltd.pim.admin.model.MenuPermissionModel;
import com.gigatechltd.pim.admin.model.RoleModel;

import java.util.List;

public interface MenuService {

    void saveMenuPermission(MenuPermissionModel menuPermissionModel);

    void updateMenuPermission(Long id, MenuPermissionModel menuPermissionModel);

    void updateMenuPermissionStatusById(Long id, Integer status);

    void updateMenuStatusById(Long id, Integer status);

    List<RoleModel> findAllRoles();

    List<MenuModel> findMenus();

    List<MenuPermissionModel> findMenuPermissionByRole(String roleId);
}
