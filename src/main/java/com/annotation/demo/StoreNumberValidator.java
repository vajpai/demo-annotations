package com.annotation.demo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StoreNumberValidator implements ConstraintValidator<StoreNumber,String> {
	
	public void initialize(StoreNumber constraintAnnotation) {
		System.out.println("----initialize-----");
		
	}
	public boolean isValid(String contactField, ConstraintValidatorContext arg1) {
		System.out.println("----isValid------contactField-----------"+contactField);
		return contactField != null && (contactField.length() > 1 && contactField.length() < 5);
	}
  
}
