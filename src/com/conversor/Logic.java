package com.conversor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Logic {
	
	//Dolar, Peso Mexicano, Libras Esterlinas, Yen Japones, Won Sul.coreano, Euros.	
	public static final double[] dollarToX = {
			1,
			17.0611,
			0.7884,
			145.4250,
			1335.7300,
			0.9168
	};
	
	public static final double[] xToDollar = {
			1,
			0.0586,
			1.2685,
			0.0069,
			0.00075,
			1.0907
	};
	
	public static final String[] currencies = {
			 "Dolar",
			 "Peso Mexicano",
			 "Libras Esterlinas",
			 "Yen Japones",
			 "Won Sul.coreano",
			 "Euros"
	};
	
	public static final String[] temperatureScales = {
			 "Celsius",
			 "Fahrenheit",
			 "Kelvin"
	};
	
	public static final String[] mainOptions= {
			 "Divisas",
			 "Temperatura"
	};
	
	private static String[] optionFixer(String optionToErase,String[]originalOptions) {
		
		ArrayList<String> fixedOptions = new ArrayList<>();
		
		for (String option : originalOptions) {
			
			if(!optionToErase.equalsIgnoreCase(option)) {
				fixedOptions.add(option);
			}
			
		}
		
		String[] result = fixedOptions.toArray(new String[fixedOptions.size()]);
		
		return result;
	}

	public static String requestMainOption() {
	
		String choosedOption = (String) JOptionPane.showInputDialog(
				null,
				"Selecciona lo que deseas convertir",
				"Conversor",
				JOptionPane.QUESTION_MESSAGE,
				null,
				mainOptions,
				mainOptions[0]);

		return choosedOption;
		
	}
	
	public static String requestValueToConvert(String mainChoosedOption) {
		
		String choosedValue = (String) JOptionPane.showInputDialog(
				null,
				"Inserte la cantidad a convertir",
				"Conversor de " + mainChoosedOption,
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				"0");

		return choosedValue;
		
	}
	
	public static String[] requestConversionUnits(String mainChoosedOption,
												  String[] mainChoosedFields){
		
		String[] result = new String[2];
		
		result[0] = (String) JOptionPane.showInputDialog(
				null,
				"De:",
				"Conversor de " + mainChoosedOption,
				JOptionPane.QUESTION_MESSAGE,
				null,
				mainChoosedFields,
				mainChoosedFields[0]);
		
		String[]fixedOptions = optionFixer(result[0],currencies);
		
		result[1] = (String) JOptionPane.showInputDialog(
				null,
				"A:",
				"Conversor de " + mainChoosedOption,
				JOptionPane.QUESTION_MESSAGE,
				null,
				fixedOptions,
				fixedOptions[0]); 
	
		return result; 
	}
	
	public static void doCurrencyConversion(String valueSelected,
											String[] conversionUnits) {
		
		double value = Double.valueOf(valueSelected);
		double result;
		
		int[] fromToIndex = new int[2];
		
		for (int i = 0; i < currencies.length; i++) {
			if (currencies[i].equals(conversionUnits[0])) {
				fromToIndex[0] = i;
			}
			if (currencies[i].equals(conversionUnits[1])) {
				fromToIndex[1] = i;
			}
		}
		
		result = (xToDollar[fromToIndex[0]] * value * dollarToX[fromToIndex[1]]);
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedResult = decimalFormat.format(result);

		JOptionPane.showMessageDialog(
				null,
				"El resultado es: $" + roundedResult + " " + conversionUnits[1],
				"Conversor de Divisas",
				JOptionPane.INFORMATION_MESSAGE);

		}
		
	public static void doTemperatureConversion(String valueSelected,
											String[] conversionUnits) {
		
		double value = Double.valueOf(valueSelected);
		double result = 0;
				
		switch (conversionUnits[0]) {
		 
         case "Celsius":
             switch (conversionUnits[1]) {
                 case "Fahrenheit":
                	 result = (value * 9 / 5) + 32;
                	 break;
                 case "Kelvin":
                	 result = value + 273.15;
                	 break;
             }
             break;
             
         case "Fahrenheit": 
             switch (conversionUnits[1]) {
                 case "Celsius":
                	 result = (value - 32) * 5 / 9;
                	 break;
                 case "Kelvin":
                	 result = (value + 459.67) * 5 / 9;
                	 break;
             }
             break;
             
         case "Kelvin":
             switch (conversionUnits[1]) {
                 case "Celsius":
                	 result = value - 273.15;
                	 break;
                 case "Fahrenheit":
                	 result = (value * 9 / 5) - 459.67;
                	 break;
             }
             break;
		}

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedResult = decimalFormat.format(result);
		
		JOptionPane.showMessageDialog(
				null,
				"El resultado es: " + roundedResult + " " + conversionUnits[1],
				"Conversor de Temperatura",
				JOptionPane.INFORMATION_MESSAGE);

		}
	
}
