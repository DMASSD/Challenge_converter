package com.conversor;

import javax.swing.JOptionPane;

public class Logic {
	
	//Dolar, Peso Mexicano, Libras Esterlinas, Yen Japones, Won Sul.coreano, Euros.	
	private static final double [] dollarToX = {
			17.05,
			0.79,
			145.46,
			1337.85,
			0.92
	};
	
	private static final double [] xToDollar = {
			0.059,
			1.27,
			0.0069,
			0.00075,
			1.09
	};
	
	private static final String[] currencies= {
			 "Dolar",
			 "Peso Mexicano",
			 "Libras Esterlinas",
			 "Yen Japones",
			 "Won Sul.coreano",
			 "Euros"
	};
	
	private static final String[] mainOptions= {
			 "Divisas",
			 "Temperatura"
	};
	
	private static String[] optionFixer(String optionToErase,String[]originalOptions) {
		
		String[] fixedOptions = new String[originalOptions.length - 1];
		
		for (int i = 0 ; i < fixedOptions.length - 1; i++) {
			
			if(!optionToErase.equalsIgnoreCase(originalOptions[i])) {
				fixedOptions[i] = originalOptions[i];
			}
			
		}
		
		return fixedOptions;
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

		if (choosedOption != null) {

		      JOptionPane.showMessageDialog(
		              null,
		              "La opcion seleccionada fue: " + choosedOption,
		              "Conversor",
		              JOptionPane.INFORMATION_MESSAGE);
		      return choosedOption;
		      
		} else {
		      JOptionPane.showMessageDialog(
		              null,
		              "Ninguna opcion seleccionada, cerrando programa",
		              "Conversor",
		              JOptionPane.WARNING_MESSAGE);
		      return null;
		  }
		
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

		if (choosedValue != null) {

		      JOptionPane.showMessageDialog(
		              null,
		              "La cantidad ingresada fue: " + choosedValue,
		              "Conversor de " + mainChoosedOption,
		              JOptionPane.INFORMATION_MESSAGE);
		      return choosedValue;
		      
		} else {
		      JOptionPane.showMessageDialog(
		              null,
		              "No se ingreso ningun numero, cerrando programa.",
		              "Conversor de " + mainChoosedOption,
		              JOptionPane.WARNING_MESSAGE);
		      return null;
		  }
		
	}
	
	public static String[] requestConversionUnits(String mainChoosedOption){
		
		String[] result = new String[2];
		
		result[0] = (String) JOptionPane.showInputDialog(
				null,
				"De:",
				"Conversor de " + mainChoosedOption,
				JOptionPane.QUESTION_MESSAGE,
				null,
				currencies,
				currencies[0]);
		
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
	
}
