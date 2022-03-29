package com.gigatechltd.pim.admin.repository;

import java.util.List;

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
	
	public List<CustomerProfile> getCustomerProfile(){
		String sql = "select customer_name as customerName, idtp_vid as idtpPin, email, mobile_no as mobileNo, tin_no as tinNo, nid from t_customer_profiles";
		List<CustomerProfile> customerProfile= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CustomerProfile.class));
		return customerProfile;
	}
	
	
	
}
