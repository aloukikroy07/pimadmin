package com.gigatechltd.pim.admin.controller;

import com.gigatechltd.pim.admin.model.BusinessUnitModel;

/// Created by taohid on 02 Mar, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import com.gigatechltd.pim.admin.model.CompanyModel;
import com.gigatechltd.pim.admin.model.CompanyUnitModel;
import com.gigatechltd.pim.admin.repository.CompanyRepository;

import java.util.HashMap;
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
	public String businessUnit(Model model, BusinessUnitModel businessUnitModel) {
		long a = companyRepository.companyId();
		model.addAttribute("businessUnits", companyRepository.getAllBusinessUnit(a));
		model.addAttribute("businessUnitModel", businessUnitModel);
		
		return "company/business_unit";
	}
	
	@PostMapping({"/company/business_unit/add"})
	public String addBusinessUnit(@ModelAttribute("BusinessUnitModel") BusinessUnitModel businessUnitModel){
		businessUnitModel.setCompanyId(companyRepository.companyId());
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
		long a = companyRepository.companyId();
		model.addAttribute("companyUnits", companyRepository.getCompanyUnits(a));
		model.addAttribute("companyUnitModel", companyUnitModel);
		model1.addAttribute("businessUnit", companyRepository.businessUnitDropdown(a));
		return "company/company_unit";
	}
	
	@PostMapping({"/company/unit/add"})
	public String addCompanyUnit(@ModelAttribute("CompanyUnitModel") CompanyUnitModel companyUnitModel){
		companyUnitModel.setCompanyId(companyRepository.companyId());
		int i = companyRepository.addCompanyUnits(companyUnitModel);
		return "redirect:/company/unit";
	}
	
	@GetMapping({"/company/parent/find"})
	@ResponseBody
	public Map<Long, String> getParentUnit(@RequestParam String parentBusinessUnit, @RequestParam String businessUnit) {
		String hierarchy = companyRepository.getHierarchy(parentBusinessUnit);
		if(hierarchy.equals("1")) {
			String businessUnitHierarchy = companyRepository.getHierarchy(businessUnit);
			if(businessUnitHierarchy.equals("1")) {
				Map<Long, String> map = companyRepository.parentFromBusinessUnit();
				return map;
			}
			else {
				Map<Long, String> map = companyRepository.parentFromCompanyUnit(parentBusinessUnit);
				return map;
			}
		}
		else {
			Map<Long, String> map = companyRepository.parentFromCompanyUnit(parentBusinessUnit);
			return map;
		}		
	}
	
	@GetMapping({"/company/parentBusinessUnit/find"})
	@ResponseBody
	public Map<Long, String> getParentBusinessUnit(@RequestParam String businessUnit) {
		String businessUnitHierarchy = companyRepository.getHierarchy(businessUnit);
		if(businessUnitHierarchy.equals("1")) {
			Map<Long, String> map = companyRepository.parentFromBusinessUnit();
			return map;
		}
		else {
			long a = companyRepository.companyId();
			List <BusinessUnitModel>  parentBusinessUnit=companyRepository.businessUnitDropdown(a);
			Map<Long, String> map=new HashMap<Long, String>();
			for(int i=0; i<parentBusinessUnit.size(); i++) {
				map.put(parentBusinessUnit.get(i).getId(), parentBusinessUnit.get(i).getUnitName());
			}
			return map;
		}		
	}
	
	@PostMapping({"/company/changeStatus"})
	public String companyActivateOrDeactivate(@ModelAttribute("CompanyModel") CompanyModel companyModel){
		companyRepository.activateOrDeactivateCompany(companyModel);
		return "redirect:/company";
	}
	
	@PostMapping({"/company/business_unit/changeStatus"})
	public String businessUnitActivateOrDeactivate(@ModelAttribute("businessUnitModel") BusinessUnitModel bum){
		companyRepository.activateOrDeactivateBusinessUnit(bum);
		return "redirect:/company/business_unit";
	}
	
	@PostMapping({"/company/editCompany"})
	public String openCompanyEditModal(@ModelAttribute("CompanyModel") CompanyModel companyModel){ 
	  companyRepository.updateCompany(companyModel); 
	  return "redirect:/company"; 
	}
	 
	@PostMapping({"/company/business_unit/edit"})
	public String editBusinessUnit(@ModelAttribute("businessUnitModel") BusinessUnitModel bum){ 
	  companyRepository.updateBusinessUnit(bum); 
	  return "redirect:/company/business_unit";
	}

}
