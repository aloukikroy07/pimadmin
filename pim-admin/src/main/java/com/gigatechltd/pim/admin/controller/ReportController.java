package com.gigatechltd.pim.admin.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gigatechltd.pim.admin.model.CompanyUnitModel;
import com.gigatechltd.pim.admin.model.CustomerProfile;
import com.gigatechltd.pim.admin.services.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	Map<String, Object> map = new HashMap<>();
	
	@GetMapping({"/customer/report"})
	public String openCustomerReportParameterWindow(Model model) {
		return "report/customerRegistrantionReport";
	}
	
	@PostMapping({"/customer/report/generate"})
	public void generateDatewiseCustomerReport(HttpServletRequest request, HttpServletResponse response, CustomerProfile cp) throws IOException, ClassNotFoundException, SQLException {
		map.put("fileNameAndPath", "templates/report_template/DatewiseUserRegistration.jrxml");
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("toDate",  request.getParameter("toDate"));
		
		reportService.generatePdfReport(map, response);
	}
	
	@GetMapping({"/datewise/trans/report"})
	public String openDatewiseTransReport(Model model) {
		return "report/datewiseTransReport";
	}
	
	@PostMapping({"/datewise/trans/report/generate"})
	public void generateDatewiseTransReport(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		map.put("fileNameAndPath", "templates/report_template/DatewiseTransactionReport.jrxml");
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("toDate",  request.getParameter("toDate"));
		
		reportService.generatePdfReport(map, response);
	}
	
	
	@GetMapping({"/userwise/trans/report"})
	public String openUserwiseTransReport(Model model) {
		List<CustomerProfile> cusProfile = reportService.getCusProfile();
		model.addAttribute("customerProfileName", cusProfile);
		return "report/userwiseTransReport";
	}
	
	
	@PostMapping({"/userwise/trans/report/generate"})
	public void generateUserwiseTransReport(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		map.put("fileNameAndPath", "templates/report_template/userwiseTransactionReport.jrxml");
		
		String cusId = request.getParameter("cpId");
		Integer cpId = cusId != null ? Integer.parseInt(cusId): null ;
		
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("toDate",  request.getParameter("toDate"));
		map.put("customerProfileId",  cpId);
		
		reportService.generatePdfReport(map, response);
	}
}
