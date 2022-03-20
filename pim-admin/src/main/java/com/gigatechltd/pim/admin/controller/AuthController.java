package com.gigatechltd.pim.admin.controller;

import com.gigatechltd.pim.admin.service.security.SecurityService;
import com.gigatechltd.pim.admin.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;
    private final SecurityService securityService;

    public AuthController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping({"/login"})
    public String userListView(Model model) {

        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        return "auth/login";
    }
}
