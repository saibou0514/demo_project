package com.example.demo1006.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Company;
import com.example.demo1006.entity.OrgCompanyId;
import com.example.demo1006.repository.CompanyDao;
import com.example.demo1006.service.ifs.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;
	

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public Company findById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> companyOp = companyDao.findById(orgCompanyId); //Optional包單一物建

//		if(companyOp.isPresent()) { //判斷有無包東西(是否有值)
//			Company com = companyOp.get();
//			return com;
//			return companyOp.get();
//		}
//		return new Company();
		
//		用orElse來省略if (30~35)
		return companyOp.orElse(new Company());
	}

	@Override
	public Company updateById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> companyOp = companyDao.findById(orgCompanyId);
		
//		update name
		if(companyOp.isPresent()) {
			Company com = companyOp.get();
			com.setCompanyName("AA");
			Company newCom = companyDao.save(com);
			return newCom;
		}
		return new Company();
	}
	
	@Override
	public Company saveCompany() {
		Company com = new Company("OD", "004", "XX");
		return companyDao.save(com);
	}
	
	
	
	
	
	
	
	
	

}
