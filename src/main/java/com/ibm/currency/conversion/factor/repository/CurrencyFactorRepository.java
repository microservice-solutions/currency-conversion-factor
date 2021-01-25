package com.ibm.currency.conversion.factor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.currency.conversion.factor.model.CurrencyFactorModel;

public interface CurrencyFactorRepository extends JpaRepository<CurrencyFactorModel, Long> {

}
