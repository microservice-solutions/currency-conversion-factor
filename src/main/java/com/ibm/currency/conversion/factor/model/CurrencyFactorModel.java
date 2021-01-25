package com.ibm.currency.conversion.factor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurrencyFactorModel {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	private String countryCode;
	
	private float conversionFactor;
}
