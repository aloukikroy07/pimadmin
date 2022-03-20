package com.gigatechltd.pim.admin.service.menu;

import com.gigatechltd.pim.admin.model.MenuModel;
import com.gigatechltd.pim.admin.model.MenuPermissionModel;
import com.gigatechltd.pim.admin.model.RoleModel;
import com.gigatechltd.pim.admin.repository.MenuRepository;
import com.gigatechltd.pim.admin.repository.MenuPermissionRepository;
import com.gigatechltd.pim.admin.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    private final MenuPermissionRepository menuPermissionRepository;

    public MenuServiceImpl(RoleRepository roleRepository, MenuRepository menuRepository, MenuPermissionRepository menuPermissionRepository) {
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
        this.menuPermissionRepository = menuPermissionRepository;
    }


    @Override
    public void updateMenuPermissionStatusById(Long id, Integer status) {
        menuPermissionRepository.updateStatusById(id, status);
    }

    @Override
    public void updateMenuStatusById(Long id, Integer status) {
        menuRepository.updateStatusById(id, status);
    }

    @Override
    public List<RoleModel> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<MenuModel> findMenus() {
        return menuRepository.findAllByOrderByMenuId();
    }

    @Override
    public void saveMenuPermission(MenuPermissionModel menuPermissionModel) {
        menuPermissionModel.setCreatedAt(new Date());
        menuPermissionRepository.save(menuPermissionModel);
    }

    @Override
    public void updateMenuPermission(Long id, MenuPermissionModel menuPermissionModel) {
        MenuPermissionModel existingData = menuPermissionRepository.getOne(id);
        existingData.update(menuPermissionModel);
        menuPermissionRepository.save(existingData);
    }

    @Override
    public List<MenuPermissionModel> findMenuPermissionByRole(String roleId) {
        try {
            return menuPermissionRepository.findAllByRoleIdOrderByMenuId(Integer.parseInt(roleId));
        } catch (Exception e) {
            return menuPermissionRepository.findAll();
        }
    }
}
