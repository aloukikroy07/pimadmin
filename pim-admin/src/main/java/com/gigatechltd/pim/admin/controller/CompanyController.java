package com.gigatechltd.pim.admin.controller;

/// Created by taohid on 02 Mar, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import com.gigatechltd.pim.admin.model.CompanyModel;
import com.gigatechltd.pim.admin.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

	@GetMapping({"/company"})
    public String companyListView(Model model, CompanyModel companyModel) {
        model.addAttribute("companies", companyRepository.getAllCompanies());
        model.addAttribute("companyModel", companyModel);
        return "company/company_list";
    }
	
	@PostMapping({"/company/add"})
    public String addCompany(@RequestBody CompanyModel companyModel) {
        int result = companyRepository.addCompanies(companyModel);
        if(result==1) {
        	return "redirect:/company";
        }
        else {
        	return "";
        }
    }
}
