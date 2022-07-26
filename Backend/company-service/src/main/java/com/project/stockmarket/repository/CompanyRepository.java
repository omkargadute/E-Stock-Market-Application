package com.project.stockmarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, Integer> {
    @Query("{'companyCode' : :#{#companyCode}}")
    Company findByCompanyCode(@Param("companyCode")Integer companyCode);
    @Query(value = "delete from company c where c.companyCode=:#{#companyCode}")
    Company deleteByCompanyCode(@Param("companyCode")Integer companyCode);
}
