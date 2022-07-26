package com.project.stockmarket.service;

import java.util.List;

import com.project.stockmarket.dto.CompanyDto;


public interface CompanyService {
    public CompanyDto registerCompany(CompanyDto companyDto);
    public List<CompanyDto> getAll();
    public CompanyDto getCompanyByCode(Integer companyCode);
    public boolean deleteCompanyByCode(Integer companyCode);
}
