package com.gigatechltd.pim.admin.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.resource.HttpResource;

import com.gigatechltd.pim.admin.services.ReportService;
import com.pim.PIMProject.Model.Request.CustomerProfile;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping({"/customer/report"})
	public String openCustomerReportParameterWindow(Model model) {
		return "report/customerReport";
	}
	@PostMapping({"/customer/report/generate"})
	public String generateCustomerReport(HttpServletResponse response, CustomerProfile cp) throws IOException {
		reportService.exportJasperReport(response, cp);
		return "";
	}
	
}
