package com.gigatechltd.pim.admin.controller;

/// Created by taohid on 28 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import com.gigatechltd.pim.admin.model.FilterModel;
import com.gigatechltd.pim.admin.model.MenuModel;
import com.gigatechltd.pim.admin.model.MenuPermissionModel;
import com.gigatechltd.pim.admin.service.menu.MenuService;
import com.gigatechltd.pim.admin.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping({"/menu"})
    public String roleListView(Model model) {
        model.addAttribute("menus", menuService.findMenus());
        return "menu/menu_list";
    }

    @PostMapping("/menu/changeStatus")
    public String changeMenuStatus(@RequestParam("id") Long id, @RequestParam("v") Integer status, RedirectAttributes redirectAttributes) {
        try {
            menuService.updateMenuStatusById(id, status);
            redirectAttributes.addFlashAttribute("message", "Updated successfully.");
        } catch (Exception e) {
            LogUtils.print(e.getLocalizedMessage());
        }
        return "redirect:/menu";
    }

    @GetMapping({"/menu/assign"})
    public String roleAssignView(FilterModel filterModel, Model model, @RequestParam(required = false, name = "role") String roleId) {
        MenuPermissionModel menuPermissionModel = new MenuPermissionModel();
        if (roleId != null && !roleId.isEmpty()) {
            menuPermissionModel.setRoleId(Integer.parseInt(roleId));
            model.addAttribute("enableAddButton", true);
        }


        List<MenuPermissionModel> menuPermissionModelList = menuService.findMenuPermissionByRole(roleId);

        List<MenuModel> allMenuList = menuService.findMenus();
        List<MenuModel> filteredMenu = allMenuList.stream().filter(menuModel -> menuPermissionModelList.stream().noneMatch(permissionModel -> permissionModel.getMenuId() == menuModel.getId().intValue())).collect(Collectors.toList());

        model.addAttribute("menuPermissionModel", menuPermissionModel);
        model.addAttribute("filterModel", filterModel);
        model.addAttribute("roles", menuService.findAllRoles());
        model.addAttribute("menus", filteredMenu);
        model.addAttribute("menuPermissionList", menuPermissionModelList);
        return "menu/menu_assign";
    }


    @PostMapping("/menu/permission/changeStatus")
    public String changeMenuPermissionStatus(@RequestParam("roleId") String roleId, @RequestParam("id") Long id, @RequestParam("v") Integer status, RedirectAttributes redirectAttributes) {
        try {
            menuService.updateMenuPermissionStatusById(id, status);
            redirectAttributes.addAttribute("role", roleId);
            redirectAttributes.addFlashAttribute("message", "Updated successfully.");
        } catch (Exception e) {
            LogUtils.print(e.getLocalizedMessage());
        }
        return "redirect:/menu/assign";
    }

    @PostMapping("/menu/permission/add")
    public String addMenuPermission(@ModelAttribute @Valid MenuPermissionModel menuPermissionModel, Model model, RedirectAttributes redirectAttributes) {

        try {
            menuService.saveMenuPermission(menuPermissionModel);
            redirectAttributes.addAttribute("role", menuPermissionModel.getRoleId());
            redirectAttributes.addFlashAttribute("message", "Menu assign successfully.");
            return "redirect:/menu/assign";
        } catch (Exception e) {
//            if (e.getClass() == DataIntegrityViolationException.class) {
//                model.addAttribute("errorMessage", "Email already exist !");
//            } else {
//                model.addAttribute("errorMessage", e.getLocalizedMessage());
//            }
//            model.addAttribute("roles", userService.findAllRoles());
            return "redirect:/menu/assign";
        }
    }


    @PostMapping({"/menu/permission/update/{id}"})
    public String updateMenuPermission(@PathVariable("id") Long id, @ModelAttribute @Valid MenuPermissionModel menuPermissionModel, RedirectAttributes redirectAttributes) {

        try {
            menuService.updateMenuPermission(id, menuPermissionModel);
            redirectAttributes.addAttribute("role", menuPermissionModel.getRoleId());
            redirectAttributes.addFlashAttribute("message", "Updated successfully.");
        } catch (Exception e) {
//            if (e.getClass() == DataIntegrityViolationException.class) {
//                redirectAttributes.addFlashAttribute("errorMessage", "Email already exist !");
//            } else {
//                redirectAttributes.addFlashAttribute("errorMessage", e.getLocalizedMessage());
//            }
        }
         return "redirect:/menu/assign";
    }
}
