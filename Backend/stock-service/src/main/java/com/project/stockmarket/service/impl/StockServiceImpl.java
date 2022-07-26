package com.project.stockmarket.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarket.dto.StockDto;
import com.project.stockmarket.entity.Stock;
import com.project.stockmarket.repository.StockRepository;
import com.project.stockmarket.service.StockService;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public StockDto addStockDto(Integer companyCode, Double stockPrice) {
        Stock stockEntity = new Stock();
        StockDto stockDto = new StockDto();
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        stockDto.setStockPrice(stockPrice);
        stockDto.setDate(currentDate.toString());
        stockDto.setTime(currentTime.toString());
        stockDto.setCompanyCode(companyCode);
        stockDto.setId(stockRepository.findAll().size()+1);
        BeanUtils.copyProperties(stockDto, stockEntity);
        BeanUtils.copyProperties(stockRepository.save(stockEntity), stockDto);
        return stockDto;
    }

    @Override
    public List<StockDto> getStockPrice(Integer companyCode,String startDate, String endDate) {
        List<Stock> stockEntities = stockRepository.findAll();
        List<StockDto> stockDtos = new ArrayList<>();
        stockEntities.forEach(entity -> {
            StockDto dto = new StockDto();
            BeanUtils.copyProperties(entity, dto);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dtoDate;
            try {
                dtoDate = formatter.parse(dto.getDate());
            } catch (ParseException e) {
                dtoDate = new Date();
            }
            Date minDate;
            try {
                minDate = formatter.parse(startDate);
            } catch (ParseException e) {
                minDate = new Date();
            }
            Date maxDate;
            try {
                maxDate = formatter.parse(endDate);
            } catch (ParseException e) {
                maxDate = new Date();
            }
            if(minDate.compareTo(dtoDate)<=0 && maxDate.compareTo(dtoDate)>=0 && dto.getCompanyCode()==companyCode) {
                stockDtos.add(dto);
            }
        });
        return stockDtos;
    }
}
