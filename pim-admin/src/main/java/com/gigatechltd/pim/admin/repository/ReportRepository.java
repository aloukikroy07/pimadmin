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
	
	public List<CustomerProfile> getCustomerProfile(){
		String sql = " select cp.id, cp.idtp_vid as idtpVid, cp.customer_name as customerName from t_customer_profiles cp order by cp.customer_name asc";
		
		List<CustomerProfile> customerProfile= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CustomerProfile.class));
		return customerProfile;
	}
	
	
	
}
