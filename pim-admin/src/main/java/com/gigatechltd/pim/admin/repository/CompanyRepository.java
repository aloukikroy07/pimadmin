package com.gigatechltd.pim.admin.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gigatechltd.pim.admin.model.BusinessUnitModel;
import com.gigatechltd.pim.admin.model.CompanyModel;
import com.gigatechltd.pim.admin.model.CompanyUnitModel;

@Repository
public class CompanyRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CompanyModel> getAllCompanies(){
		String sql = "select id, name, address, city, country, phone_No as phoneNo, email, website, status, bank_id as bankId, state from t_companies order by id desc";
		List <CompanyModel> companies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyModel.class));
		return companies;
	}
	
	public int addCompanies(CompanyModel companyModel){
		long bankId = companyModel.getBankId();
		if (bankId == 0) {
			bankId = 1;
		}
		String sql = "insert into t_companies(bank_id, name, address, city, state, country, phone_no, email, website, status) values("+bankId+",'"+companyModel.getName()+"', '"+companyModel.getAddress()+"','"+companyModel.getCity()+"', '"+companyModel.getState()+"','"+companyModel.getCountry()+"', '"+companyModel.getPhoneNo()+"', '"+companyModel.getEmail()+"','"+companyModel.getWebsite()+"', '"+companyModel.getStatus()+"')";
		int result= jdbcTemplate.update(sql);
		if(result==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public long companyId(){
		String sql = "select min(id) as id from t_companies";
		List <CompanyModel> companies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyModel.class));
		long a = companies.get(0).getId();
		return a;
	}
	
	public List<BusinessUnitModel> getAllBusinessUnit(long companyId){
		String sql = "select t0.id, t0.unit_name as unitName, t1.name as companyName, t0.short_name as shortName,"
				+ " t0.hierarchy, t0.status from t_business_units t0 inner join t_companies t1 on t0.company_id=t1.id order by t0.hierarchy asc";
		List <BusinessUnitModel> businessUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		return businessUnits;
	}
	
	public List<BusinessUnitModel> businessUnitDropdown(long companyId){
		String sql = "select id, unit_name as unitName from t_business_units where company_Id= '"+companyId+"' and status= '1'";
		List<BusinessUnitModel> businessUnits= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		return businessUnits;
	}
	
	public List<BusinessUnitModel> parentBusinessUnitDropdown(String businessUnit){
		String sql = "select id, unit_name as unitName from t_business_units where company_Id= '"+companyId()+"' and status= '1' and hierarchy<= '"+businessUnit+"'";
		List<BusinessUnitModel> businessUnits= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		return businessUnits;
	}
	
	public List<CompanyUnitModel> getCompanyUnits(long companyId){
		String sql = "select t0.id, t0.name, t1.name as companyName, t2.unit_name as businessUnitName, t0.parent_id,\r\n" + 
				"(case\r\n" + 
				"when t2.id>2\r\n" + 
				"then (select t10.name from t_company_units t10 where t10.id=t0.parent_id)\r\n" + 
				"else (select t10.unit_name from t_business_units t10 where t10.id=t0.COMPANY_ID)\r\n" + 
				"end) as ParentName,\r\n" + 
				"t0.short_name as shortName, t0.address, t0.country, t0.phone_no, t0.email, t0.website, t0.status \r\n" + 
				"from t_company_units t0 \r\n" + 
				"inner join t_companies t1 on t1.id = t0.company_id\r\n" + 
				"inner join t_business_units t2 on t2.id=t0.business_unit_id where t0.company_id='"+companyId+"'";
		List <CompanyUnitModel> companyUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		return companyUnits;
	}
	
	public List<CompanyUnitModel> companyUnitDropDown(){
		String sql = "select id, name from t_company_units where company_id='"+companyId()+"'";
		List <CompanyUnitModel> companyUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		return companyUnits;
	}
	
	public String getHierarchy(String businessUnitId){
		String sql = "select hierarchy from t_business_units where id='"+businessUnitId+"'";
		List <BusinessUnitModel>  hierarchy= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		String a = hierarchy.get(0).getHierarchy();
		return a;
	}
	
	public Map<Long, String> parentFromBusinessUnit(){
		String sql = "select id, unit_name from t_business_units where hierarchy=1 and company_id='"+companyId()+"' and status='1'";
		List <BusinessUnitModel>  businessUnit= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		Map<Long, String> map=new HashMap<Long, String>();
		for(int i=0; i<businessUnit.size(); i++) {
			map.put(businessUnit.get(i).getId(), businessUnit.get(i).getUnitName());
		}
		return map;
	}
	
	public Map<Long, String> parentFromCompanyUnit(String businessUnit){
		String sql = "select id, name from t_company_units where business_unit_id='"+businessUnit+"' and company_id='"+companyId()+"' and status='1'";
		List <CompanyUnitModel>  companyUnit= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		Map<Long, String> map=new HashMap<Long, String>();
		for(int i=0; i<companyUnit.size(); i++) {
			map.put(companyUnit.get(i).getId(), companyUnit.get(i).getName());
		}
		return map;
	}
	
	public int addCompanyUnits(CompanyUnitModel companyUnitModel){
		String sql = "insert into t_company_units(company_id, business_unit_id, parent_id, name, short_name, address, city, country, status, user_id) "
				+ "values('"+companyUnitModel.getCompanyId()+"','"+companyUnitModel.getBusinessUnitId()+"','"+companyUnitModel.getParentId()+"','"
				+ companyUnitModel.getName()+"','"+companyUnitModel.getShortName()+"','"+companyUnitModel.getAddress()+"','"+companyUnitModel.getCity()
				+"','"+companyUnitModel.getCountry()+"','"+companyUnitModel.getStatus()+"',1)";
		int result= jdbcTemplate.update(sql);
		if(result==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int addBusinessUnits(BusinessUnitModel businessUnitModel){
		String sql = "insert into t_business_units(company_id, unit_name, short_name, hierarchy, status, user_id) values('"+businessUnitModel.getCompanyId()+"','"+businessUnitModel.getUnitName()+"','"+businessUnitModel.getShortName()+"','"+businessUnitModel.getHierarchy()+"','"+businessUnitModel.getStatus()+"', 1)";
		int result= jdbcTemplate.update(sql);
		if(result==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int activateOrDeactivateCompany(CompanyModel cm){
		char status = cm.getStatus();
		if (status == '1') {
			status = '0';
		}else {
			status = '1';
		}
		
		String sql = "update t_companies set status = '"+status+"' where id ="+cm.getId();
		int result= jdbcTemplate.update(sql);
		return result;
	}
	
	public int activateOrDeactivateBusinessUnit(BusinessUnitModel bum){
		String status = bum.getStatus();
		if (status.equals("1")) {
			status = "0";
		}else {
			status = "1";
		}
		
		String sql = "update t_business_units set status = '"+status+"' where id ="+bum.getId();
		int result= jdbcTemplate.update(sql);
		return result;
	}
	public int activateOrDeactivateCompanyUnit(CompanyUnitModel cum){
		String status = cum.getStatus();
		if (status.equals("1")) {
			status = "0";
		}else {
			status = "1";
		}
		
		String sql = "update t_company_units set status = '"+status+"' where id ="+cum.getId();
		int result= jdbcTemplate.update(sql);
		return result;
	}
	
		
	public int updateCompany(CompanyModel cm){
		String sql = "update t_companies set name = '"+cm.getName()+"', bank_id = '"+cm.getBankId()+"', address = '"+cm.getAddress()+"',"
				+ " city = '"+cm.getCity()+"', state = '"+cm.getState()+"', country = '"+cm.getCountry()+"', phone_no = '"+cm.getPhoneNo()+"',"
				+ " email = '"+cm.getEmail()+"', website = '"+cm.getWebsite()+"', status = '"+cm.getStatus()+"' where id ="+cm.getId();
		int result= jdbcTemplate.update(sql);
		return result;
	}

	public int updateBusinessUnit(BusinessUnitModel bum){
		
		String sql2 = "update t_business_units set unit_name = '"+bum.getUnitName()+"', short_name = '"+bum.getShortName()+"',"
				+ "hierarchy = '"+bum.getHierarchy()+"', status = '"+bum.getStatus()+"' where id ="+bum.getId();
		int result= jdbcTemplate.update(sql2);
		return result;
	}
	
}