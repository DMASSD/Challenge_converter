package com.conversor;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		boolean keepOnProgram = true;
		
		while(keepOnProgram) {
			
			try {
				String choosedMainOption = Logic.requestMainOption();					
				double value = Logic.requestValueToConvert(choosedMainOption);	       
				
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
				
			} catch (Exception e) {
				keepOnProgram = Logic.endProgram();
			}
			
			
			
		}
		
		 JOptionPane.showMessageDialog(
					null,
					"Programa Finalizado",
					"Saliendo del programa",
					JOptionPane.INFORMATION_MESSAGE);
		
	}

}
