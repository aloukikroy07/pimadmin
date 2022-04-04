package com.gigatechltd.pim.admin.controller;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gigatechltd.pim.admin.model.CustomerProfile;
import com.gigatechltd.pim.admin.services.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping({"/customer/report"})
	public String openCustomerReportParameterWindow(Model model) {
		return "report/customerReport";
	}
	
	@PostMapping({"/customer/report/generate"})
	public String generateCustomerReport(HttpServletRequest request, HttpServletResponse response, CustomerProfile cp) throws IOException {
		reportService.exportJasperReport(request, response, cp);
		return "";
	}
	
	
	
}
