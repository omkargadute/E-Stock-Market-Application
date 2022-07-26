package com.project.stockmarket.service;

import java.util.List;

import com.project.stockmarket.dto.StockDto;

public interface StockService {

    public StockDto addStockDto(Integer companyCode, Double stockPrice);
    public List<StockDto> getStockPrice(Integer companyCode,String startDate, String endDate);
}
