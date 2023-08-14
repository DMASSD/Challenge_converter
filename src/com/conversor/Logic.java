package com.conversor;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Logic {
	
	//Dolar, Peso Mexicano, Libras Esterlinas, Yen Japones, Won Sul.coreano, Euros.	
	public static final double [] dollarToX = {
			17.05,
			0.79,
			145.46,
			1337.85,
			0.92
	};
	
	public static final double [] xToDollar = {
			0.059,
			1.27,
			0.0069,
			0.00075,
			1.09
	};
	
	public static final String[] currencies = {
			 "Dolar",
			 "Peso Mexicano",
			 "Libras Esterlinas",
			 "Yen Japones",
			 "Won Sul.coreano",
			 "Euros"
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
		
		JOptionPane.showMessageDialog(
	              null,
	              "Se selecciono la conversion de: "
	              + result[0] + 
	              " a : "
	              + result[1],
	              "Conversor de " + mainChoosedOption,
	              JOptionPane.WARNING_MESSAGE);
	
		return result; 
	}
	
	
}
