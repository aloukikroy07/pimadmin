package com.gigatechltd.pim.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping({"/", "/home"})
    public String getView(ModelMap map) {
        return "dashboard/dashboard";
    }
}
