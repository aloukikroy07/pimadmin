package com.gigatechltd.pim.admin.repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gigatechltd.pim.admin.model.CustomerProfile;

@Repository
public class ReportRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String stringFormatInString(String date) {
		String formattedDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = sdf.format(date);
		} catch(Exception e) { 
			
		}
		return formattedDate;
	}
	
	public String dateFormatInString(Date date) {
		String formattedDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm:ss a");
			formattedDate = sdf.format(date);
		} catch(Exception e) { 
			
		}
		return formattedDate;
	}
	
	public List<CustomerProfile> getCustomerProfile(HttpServletRequest request, CustomerProfile cp){
		
		String toDate = request.getParameter("toDate");
		String fromDate = request.getParameter("fromDate");
		String now = dateFormatInString(new Date());
		
		String sql = "select ca.account_no as primaryAccountNo, cp.customer_name as customerName, cp.idtp_vid as idtpPin, cp.email, cp.mobile_no as mobileNo, cp.tin_no as tinNo, cp.nid" 
				+" from t_customer_profiles cp join t_customer_accounts ca on ca.profile_id = cp.id"
				;//+ "where created_at between nvl("+toDate+" "+now+") and nvl("+fromDate+" "+now+")";
		
		List<CustomerProfile> customerProfile= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CustomerProfile.class));
		return customerProfile;
	}
	
	
	
}
