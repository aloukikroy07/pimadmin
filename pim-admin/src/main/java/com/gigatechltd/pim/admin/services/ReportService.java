package com.gigatechltd.pim.admin.services;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.gigatechltd.pim.admin.repository.ReportRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class ReportService {
	
	@Autowired
	ReportRepository reportRepository;
	
	@Autowired
	Connection getDataSource;

    public void generatePdfReport(Map<String, Object> map, HttpServletResponse response) throws IOException {
		File template;
	    
		try {
			template = ResourceUtils.getFile("classpath:"+map.get("fileNameAndPath"));
			JasperReport jasperReport = JasperCompileManager.compileReport(template.getAbsolutePath());
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, getDataSource);
		    
		    JRPdfExporter pdfExporter = new JRPdfExporter();
		    pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		    ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
		    pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
		    pdfExporter.exportReport();
		    
		    response.setContentType("application/pdf");
		    response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
		    
		    ServletOutputStream responseOutputStream = response.getOutputStream();
		    responseOutputStream.write(pdfReportStream.toByteArray());
		    responseOutputStream.close();
		    pdfReportStream.close();
		    
		    Log.info(map.get("fileNameAndPath")+" Report Generated !");
		    
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
	
}
