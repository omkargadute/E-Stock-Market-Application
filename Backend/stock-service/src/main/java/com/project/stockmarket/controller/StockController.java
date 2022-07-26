package com.project.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarket.dto.StockDto;
import com.project.stockmarket.service.StockService;

@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping(value="/add/{companyCode}")
    public ResponseEntity<StockDto> addStock(@PathVariable Integer companyCode, Double stockPrice) {
        return new ResponseEntity<>(stockService.addStockDto(companyCode, stockPrice),HttpStatus.CREATED);
    }

    @GetMapping(value="/get/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity< List<StockDto> >  getStockDetails(@PathVariable Integer companyCode, @PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") String startDate, @PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") String endDate) {
        return new ResponseEntity<>(stockService.getStockPrice(companyCode, startDate, endDate),HttpStatus.CREATED);
    }
}
