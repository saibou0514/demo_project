package com.example.demo1006.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1006.entity.Company;
import com.example.demo1006.entity.OrgCompanyId;

@Repository //�O�o��spring boot�U��
public interface CompanyDao extends JpaRepository<Company, OrgCompanyId>{
	

}
