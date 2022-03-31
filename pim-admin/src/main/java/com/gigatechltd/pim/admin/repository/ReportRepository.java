package com.gigatechltd.pim.admin.repository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pim.PIMProject.Model.Request.CustomerProfile;

@Repository
public class ReportRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public List<TestCF> getCustomerProfile(){
//		String sql = "select customer_name as cusname, idtp_vid as idtp, email, mobile_no as mobile, tin_no as tin, nid from t_customer_profiles";
//		List<TestCF> customerProfile= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TestCF.class));
//		return customerProfile;
//	}
	
	public List<CustomerProfile> getCustomerProfile(CustomerProfile cp){
		String idtpVid = cp.getIdtpPin().equalsIgnoreCase("") ? null : cp.getIdtpPin();
		String nID = cp.getNid().equalsIgnoreCase("") ? null : cp.getNid();
		String mobileNo = cp.getMobileNo().equalsIgnoreCase("") ? null : cp.getMobileNo();
		String dob=cp.getBirthDate().equals("") ? null : new SimpleDateFormat("dd-MM-yyyy").format(cp.getBirthDate());
		
		String sql = "select customer_name as customerName, idtp_vid as idtpPin, email, mobile_no as mobileNo, tin_no as tinNo, nid from t_customer_profiles "
				+ "where (idtp_vid = nvl("+idtpVid+", idtp_vid) or idtp_vid is null) or (nid = nvl("+nID+", nid) or nid is null) "
				+ "or (mobile_no = nvl("+mobileNo+", mobile_no) or mobile_no is null) or (birth_date = nvl(TO_DATE('"+dob+"', 'DD-MM-YY'), birth_date) or birth_date is null)";
		
		List<CustomerProfile> customerProfile= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CustomerProfile.class));
		return customerProfile;
	}
	
	
	
}
