package com.project.stockmarket.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.dto.CompanyDto;
import com.project.stockmarket.entity.Company;
import com.project.stockmarket.exceptions.CompanyNotFoundException;
import com.project.stockmarket.repository.CompanyRepository;
import com.project.stockmarket.service.CompanyService;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto registerCompany(CompanyDto companyDto) {
        Company companyEntity = new Company();
        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setCompanyCEO(companyDto.getCompanyCEO());
        companyDto2.setCompanyCode(companyDto.getCompanyCode());
        companyDto2.setCompanyName(companyDto.getCompanyName());
        companyDto2.setCompanyTurnover(companyDto.getCompanyTurnover());
        companyDto2.setStockExchange(companyDto.getStockExchange());
        companyDto2.setCompanyWebsite(companyDto.getCompanyWebsite());
        BeanUtils.copyProperties(companyDto2, companyEntity);
        BeanUtils.copyProperties(companyRepository.save(companyEntity), companyDto);
        return companyDto;
    }

    @Override
    public List<CompanyDto> getAll() {
        List<Company> companyEntities = companyRepository.findAll();
        List<CompanyDto> companyDtos = new ArrayList<>();
        companyEntities.forEach(entity -> {
            CompanyDto dto = new CompanyDto();
            BeanUtils.copyProperties(entity, dto);
            companyDtos.add(dto);
        });
        return companyDtos;
    }

    @Override
    public CompanyDto getCompanyByCode(Integer companyCode) {
        Company companyEntity = companyRepository.findByCompanyCode(companyCode);
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(companyEntity, companyDto);
        return companyDto;
    }

    @Override
    public boolean deleteCompanyByCode(Integer companyCode) {
        Company companyEntity = companyRepository.findByCompanyCode(companyCode);
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(companyEntity, companyDto);
        BeanUtils.copyProperties(companyDto, companyEntity);
        if (companyEntity != null) {
            companyRepository.deleteByCompanyCode(companyEntity.getCompanyCode());
            return true;
        } else {
            throw new CompanyNotFoundException("The given Party is not found");
        }
    }

}
