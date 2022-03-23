package com.gigatechltd.pim.admin.controller;

import com.gigatechltd.pim.admin.configuration.Config;
import com.gigatechltd.pim.admin.model.UserModel;
import com.gigatechltd.pim.admin.repository.CompanyRepository;
import com.gigatechltd.pim.admin.service.menu.MenuService;
import com.gigatechltd.pim.admin.service.user.UserService;
import com.gigatechltd.pim.admin.utils.LogUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
    private final UserService userService;
    private final MenuService menuService;

    public UserController(UserService userService, MenuService menuService) {
        this.userService = userService;
        this.menuService = menuService;
    }


    @GetMapping({"/users"})
    public String userListView(Model model) {
        model.addAttribute("users", userService.findAll());        
        return "user/user_list";
    }

    @GetMapping({"/users/add"})
    public String userAddView(Model model, Model model1) {
        UserModel userModel = new UserModel();
        model.addAttribute("userModel", userModel);
        model.addAttribute("roles", menuService.findAllRoles());
        model1.addAttribute("CompanyUnits", companyRepository.companyUnitDropDown());
        return "user/user_add";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute @Valid UserModel user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("roles", menuService.findAllRoles());
            return "user/user_add";
        }

        try {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "User added successfully.");
            return "redirect:/users";
        } catch (Exception e) {
            if (e.getClass() == DataIntegrityViolationException.class) {
                model.addAttribute("errorMessage", "Email already exist !");
            } else {
                model.addAttribute("errorMessage", e.getLocalizedMessage());
            }
            model.addAttribute("roles", menuService.findAllRoles());
            return "user/user_add";
        }
    }


    @GetMapping({"/users/activate"})
    public String userActivateView(Model model) {
        model.addAttribute("users", userService.findAllByStatus(Config.STATUS_PENDING));
        return "user/inactive_user_list";
    }

    @PostMapping("/users/changeStatus")
    public String changeUserStatus(@RequestParam("id") Long id, @RequestParam("r") String redirect, @RequestParam("v") Integer status) {
        try {
            userService.updateUserStatusById(id, status);
            return "redirect:" + redirect;
        } catch (Exception e) {
            LogUtils.print(e.getLocalizedMessage());
            return "redirect:" + redirect;
        }
    }

    @GetMapping({"/users/update/{id}"})
    public String userUpdateView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userModel", userService.findUserById(id));
        model.addAttribute("roles", menuService.findAllRoles());
        return "user/user_edit";
    }

    @PostMapping({"/users/update/{id}"})
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute @Valid UserModel userModel, RedirectAttributes redirectAttributes) {
        try {
            userService.update(id, userModel);
            redirectAttributes.addFlashAttribute("message", "User updated successfully.");
            return "redirect:/users";
        } catch (Exception e) {
            if (e.getClass() == DataIntegrityViolationException.class) {
                redirectAttributes.addFlashAttribute("errorMessage", "Email already exist !");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", e.getLocalizedMessage());
            }
            return "redirect:/users/update/" + id;
        }
    }
}
