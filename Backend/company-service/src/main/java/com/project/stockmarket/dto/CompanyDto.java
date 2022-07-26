package com.project.stockmarket.dto;

public class CompanyDto {
    private Integer companyCode;
    private String companyName;
    private String companyCEO;
    private Long companyTurnover;
    private String companyWebsite;
    private String stockExchange;

    public Integer getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEO() {
        return this.companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public Long getCompanyTurnover() {
        return this.companyTurnover;
    }

    public void setCompanyTurnover(Long companyTurnover) {
        this.companyTurnover = companyTurnover;
    }

    public String getCompanyWebsite() {
        return this.companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getStockExchange() {
        return this.stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }
    
}
