package com.project.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarket.dto.CompanyDto;
import com.project.stockmarket.service.CompanyService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PostMapping(value="/register")
    public ResponseEntity<CompanyDto> registerCompany(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.registerCompany(companyDto),HttpStatus.CREATED);
    }

    @GetMapping(value="/getall")
    public ResponseEntity< List<CompanyDto> > getAll() {
        return new ResponseEntity<>(companyService.getAll(),HttpStatus.OK);
    }

    @GetMapping(value="/info/{companyCode}")
    public ResponseEntity<CompanyDto> getCompanyByCode(@PathVariable Integer companyCode) {
        return new ResponseEntity<>(companyService.getCompanyByCode(companyCode), HttpStatus.OK);
    }
    
    @DeleteMapping(value="/delete/{companyCode}")
    public ResponseEntity<Boolean> deleteCompanyByCode(@PathVariable Integer companyCode) {
        return new ResponseEntity<>(companyService.deleteCompanyByCode(companyCode), HttpStatus.OK);
    }
}
