package com.annotation.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StoreNumberValidator implements ConstraintValidator<StoreNumber,String> {
	
	public void initialize(StoreNumber constraintAnnotation) {
		
	}
	public boolean isValid(String contactField, ConstraintValidatorContext arg1) {
		return contactField != null && (contactField.length() > 1 && contactField.length() < 5);
	}
  
}
