package com.gigatechltd.pim.admin.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.gigatechltd.pim.admin.model.CustomerProfile;
import com.gigatechltd.pim.admin.repository.ReportRepository;
import com.lowagie.text.pdf.codec.Base64.OutputStream;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
    
    public String exportJasperReport(HttpServletRequest request, HttpServletResponse response, CustomerProfile cp) throws IOException {
		String path = "C:\\Users\\User\\Downloads";
		String destFileName = path+"\\report.html";
		JRBeanCollectionDataSource jrbcd = null;
		File template;
		try {
			List<CustomerProfile> customerProfileData = reportRepository.getCustomerProfile(request, cp);
			jrbcd = new JRBeanCollectionDataSource(customerProfileData);
			template = ResourceUtils.getFile("classpath:CustomerReport.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(template.getAbsolutePath());
			Map<String, Object> parameters = new HashMap<>();
		    parameters.put("report1", "customer");
		        
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrbcd);
		    
		    JRPdfExporter pdfExporter = new JRPdfExporter();
		    pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		    ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
		    pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
		    pdfExporter.exportReport();
		    
		    response.setContentType("application/pdf");
		    response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
		    response.addHeader("Content-Disposition", "inline; filename=customer.pdf");
		    
		    ServletOutputStream responseOutputStream = response.getOutputStream();
		    responseOutputStream.write(pdfReportStream.toByteArray());
		    responseOutputStream.close();
		    pdfReportStream.close();
		    
		    Log.info("Report downloaded in path: "+destFileName);
		    System.out.println("Report downloaded in path: "+destFileName);
		    
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return path;
	}
	
	
}
