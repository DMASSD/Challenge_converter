package com.conversor;

public class Main {
	
	public static void main(String[] args) {
		
		boolean keepOnProgram = true;
		
		while(keepOnProgram) {
			
			double value = 0;
		
			String choosedMainOption = Logic.requestMainOption();
			
			while (value == 0) {
				value = Logic.requestValueToConvert(choosedMainOption);
			}
	       
			
			if(choosedMainOption.equals(Logic.mainOptions[0])) {
				
				String[] conversionUnits= Logic.requestConversionUnits(choosedMainOption,
						Logic.currencies);
				
				Logic.doCurrencyConversion(value,conversionUnits);
			}
			
			else {
				String[] conversionUnits= Logic.requestConversionUnits(choosedMainOption,
						Logic.temperatureScales);
				
				Logic.doTemperatureConversion(value,conversionUnits);
			}
		
			keepOnProgram = Logic.endProgram();
			
		}
		
	}

}
