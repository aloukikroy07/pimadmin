package com.gigatechltd.pim.admin.controller;

/// Created by taohid on 02 Mar, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import com.gigatechltd.pim.admin.model.CompanyModel;
import com.gigatechltd.pim.admin.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/company/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String addCompany(Model model, @ModelAttribute("CompanyModel") CompanyModel companyModel) {
        int result = companyRepository.addCompanies(companyModel);
        if(result==1) {
            return "redirect:/company";
        }
        else {
        	return "";
        }
    }
}
