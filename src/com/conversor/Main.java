package com.conversor;

public class Main {
	
	public static void main(String[] args) {
		
		String choosedMainOption = Logic.requestMainOption();
       
		String value = Logic.requestValueToConvert(choosedMainOption);
		
		String[] conversionUnits= Logic.requestConversionUnits(choosedMainOption,
																Logic.currencies);
		
		Logic.doCurrencyConversion(value,conversionUnits);
	}

}
