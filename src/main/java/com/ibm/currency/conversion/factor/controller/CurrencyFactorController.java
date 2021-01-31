package com.ibm.currency.conversion.factor.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currency.conversion.factor.model.CurrencyFactorModel;
import com.ibm.currency.conversion.factor.repository.CurrencyFactorRepository;

@RestController
@RequestMapping(path = "/currency/conversion/factor")
public class CurrencyFactorController {
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyFactorController.class);
	
	@Autowired
	CurrencyFactorRepository repository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<CurrencyFactorModel> addConversionFactor(
			@RequestParam(name = "country") String country, @RequestParam(name = "factor") float factor) {
		
		log.info("Received request for adding conversion factor with country {} & factor {}", country, factor);
		
		CurrencyFactorModel model = new CurrencyFactorModel();
		model.setCountryCode(country);
		model.setConversionFactor(factor);
		
		log.info("Saving currency conversion factor with country {} & factor {}", country, factor);
		repository.save(model);
		
		return new ResponseEntity<CurrencyFactorModel>(model, HttpStatus.CREATED);
	}

	
	@PutMapping public ResponseEntity<CurrencyFactorModel> updateConversionFactor(
			@RequestParam(name = "country") String country, @RequestParam(name = "factor") float factor) {
		
		log.info("Received request for updating conversion factor with country {} & factor {}", country, factor);
		
		CurrencyFactorModel model = new CurrencyFactorModel();                         
		model.setCountryCode(country);

		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("countryCode", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
			      .withIgnorePaths("conversionFactor");
		
		CurrencyFactorModel result = null;
		Example<CurrencyFactorModel> example = Example.of(model, ignoringExampleMatcher);
		
		Optional<CurrencyFactorModel> models = repository.findOne(example);
		if (models.isPresent()) {
			result = models.get();
			result.setConversionFactor(factor);
			
			log.info("Updating currency conversion factor with country {} & factor {}", country, factor);
			repository.save(result);
		}
		
		return new ResponseEntity<CurrencyFactorModel>(result, HttpStatus.CREATED);
	}
	
	@GetMapping public ResponseEntity<CurrencyFactorModel> getConversionFactor(@RequestParam(name = "country") String country) {
		
		log.info("Received request for get conversion factor with country {}", country);
		
		CurrencyFactorModel model = new CurrencyFactorModel();                         
		model.setCountryCode(country);

		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("countryCode", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
			      .withIgnorePaths("conversionFactor");
		
		CurrencyFactorModel result = null;
		Example<CurrencyFactorModel> example = Example.of(model, ignoringExampleMatcher);
		
		Optional<CurrencyFactorModel> models = repository.findOne(example);
		if (models.isPresent()) {
			result = models.get();
			
			log.info("Retrieved conversion factor {} for country {}", result.getConversionFactor(), result.getCountryCode());
		} else {
			log.info("Could not find entry for country {}", country);
			
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<CurrencyFactorModel>(result,HttpStatus.OK);
	}
	
}
