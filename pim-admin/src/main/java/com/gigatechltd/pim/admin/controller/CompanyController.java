package com.gigatechltd.pim.admin.controller;

import com.gigatechltd.pim.admin.model.BusinessUnitModel;

/// Created by taohid on 02 Mar, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import com.gigatechltd.pim.admin.model.CompanyModel;
import com.gigatechltd.pim.admin.model.CompanyUnitModel;
import com.gigatechltd.pim.admin.repository.CompanyRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping({"/company/business_unit"})
	public String businessUnit(Model model, Model model1, BusinessUnitModel businessUnitModel) {
		model.addAttribute("businessUnits", companyRepository.getAllBusinessUnit());
		model.addAttribute("businessUnitModel", businessUnitModel);
		model1.addAttribute("companyList", companyRepository.companyDropdown());
//		model1.addAttribute("companyModel", companyModel);
		return "company/business_unit";
	}
	
	@PostMapping({"/company/business_unit/add"})
	public String addBusinessUnit(@ModelAttribute("BusinessUnitModel") BusinessUnitModel businessUnitModel){
		int result = companyRepository.addBusinessUnits(businessUnitModel);
		if(result==1) {
			return "redirect:/company/business_unit";
		}
		else {
			return "";
		}		
	}
	
	@GetMapping({"/company/unit"})
	public String companyUnit(Model model, Model model1, CompanyUnitModel companyUnitModel){
		model.addAttribute("companyUnits", companyRepository.getCompanyUnits());
		model.addAttribute("companyUnitModel", companyUnitModel);
		model1.addAttribute("companyList", companyRepository.companyDropdown());
		return "company/company_unit";
	}
	
	@PostMapping({"/company/unit/add"})
	public String addCompanyUnit(@ModelAttribute("CompanyUnitModel") CompanyUnitModel companyUnitModel){
		return "redirect:/company/unit";
	}
	
	@GetMapping({"/company/business_unit/find"})
	@ResponseBody
	public List<BusinessUnitModel> getBusinessUnit(@RequestParam String company) {
		List<BusinessUnitModel> businessUnits = companyRepository.businessUnitDropdown(company);
		return businessUnits;
	}
	
	@PostMapping({"/company/changeStatus"})
	public String companyActivateOrDeactivate(@ModelAttribute("CompanyModel") CompanyModel companyModel){
		int result = companyRepository.activateOrDeactivateCompany(companyModel);
		return "redirect:/company";
	}
	
	/*
	 * @PostMapping({"/company/delete/{id}"}) public String
	 * companyDelete(@PathVariable(name = "id") Integer id){ //int result =
	 * companyRepository.activateOrDeactivateCompany(id); return
	 * "redirect:/company"; }
	 */


}
