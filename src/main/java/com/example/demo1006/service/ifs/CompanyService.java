package com.example.demo1006.service.ifs;

import java.util.List;

import com.example.demo1006.entity.Company;

public interface CompanyService {
	
	public List<Company> findAll();
	
	public Company findById(String orgId, String companyId);
	
	public Company updateById (String orgId, String companyId);

	public Company saveCompany ();
}
