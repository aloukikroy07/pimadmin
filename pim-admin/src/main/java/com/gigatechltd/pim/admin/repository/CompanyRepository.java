package com.gigatechltd.pim.admin.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "select id, name, address, city, country, phone_No as phoneNo, email, website, status from t_companies order by id desc";
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
	
	public List<BusinessUnitModel> getAllBusinessUnit(){
		String sql = "select t0.id, t0.unit_name as unitName, t1.name as companyName, t0.short_name as shortName, t0.hierarchy from t_business_units t0 inner join t_companies t1 on t0.company_id=t1.id";
		List <BusinessUnitModel> businessUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		return businessUnits;
	}
	
	public Map<Long, String> businessUnitDropdown(String companyId){
		String sql = "select id, unit_name as unitName from t_business_units where company_Id= '"+companyId+"'";
		List<BusinessUnitModel> businessUnits= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BusinessUnitModel.class));
		Map<Long, String> map=new HashMap<Long, String>();
		for(int i=0; i<businessUnits.size(); i++) {
			map.put(businessUnits.get(i).getId(), businessUnits.get(i).getUnitName());
		}
		return map;
	}
	
	public List<CompanyUnitModel> getCompanyUnits(){
		String sql = "select t0.id, t0.name, t1.name as companyName, t2.unit_name as businessUnitName, t0.parent_id,\r\n" + 
				"(case\r\n" + 
				"when t2.id>2\r\n" + 
				"then (select t10.name from t_company_units t10 where t10.id=t0.parent_id)\r\n" + 
				"else (select t10.unit_name from t_business_units t10 where t10.id=t0.COMPANY_ID)\r\n" + 
				"end) as ParentName,\r\n" + 
				"t0.address, t0.country, t0.phone_no, t0.email, t0.website, t0.status \r\n" + 
				"from t_company_units t0 \r\n" + 
				"inner join t_companies t1 on t1.id = t0.company_id\r\n" + 
				"inner join t_business_units t2 on t2.id=t0.business_unit_id";
		List <CompanyUnitModel> companyUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		return companyUnits;
	}
	
	public Map<Long, String> parentDropDown(String companyId, String businessUnitId){
		String sql = "select\r\n" + 
				"(\r\n" + 
				"case \r\n" + 
				"when t0.hierarchy>1\r\n" + 
				"then (select t10.id from t_company_units t10 where t10.business_unit_id= t0.id)\r\n" + 
				"else t0.id\r\n" + 
				"end) id,\r\n" + 
				"(\r\n" + 
				"case \r\n" + 
				"when t0.hierarchy>1\r\n" + 
				"then (select t10.name from t_company_units t10 where t10.business_unit_id= t0.id)\r\n" + 
				"else t0.unit_name\r\n" + 
				"end) name\r\n" + 
				"from t_business_units t0\r\n" + 
				"where t0.hierarchy<\r\n" + 
				"(select \r\n" + 
				"hierarchy\r\n" + 
				"from t_business_units t0\r\n" + 
				"where company_id='"+companyId+"' and id='"+businessUnitId+"') and t0.company_id='"+companyId+"'";
		List <CompanyUnitModel> companyUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		Map<Long, String> map=new HashMap<Long, String>();
		for(int i=0; i<companyUnits.size(); i++) {
			map.put(companyUnits.get(i).getId(), companyUnits.get(i).getName());
		}
		return map;
	}
	
	public List<CompanyUnitModel> companyUnitsDropDown(){
		String sql = "select id, name from t_company_units where company_id='1' and business_unit_id='1'";
		List <CompanyUnitModel> companyUnits = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CompanyUnitModel.class));
		return companyUnits;
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
		String sql = "update t_companies set status = '"+cm.getStatus()+"' where id ="+cm.getId();
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
	
}