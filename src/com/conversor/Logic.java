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
	
	public static double requestValueToConvert(String mainChoosedOption) {
		
		double choosedValue = 0;
		
		try {
			
			String getValue = (String)JOptionPane.showInputDialog(
					null,
					"Inserte la cantidad a convertir",
					"Conversor de " + mainChoosedOption,
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					"0");
			
			choosedValue = Double.parseDouble(getValue);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"Solamente se admiten numeros favor de omitir letras y "
					+ "caracteres especiales",
					"Error",
					JOptionPane.WARNING_MESSAGE);
		}
				
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
		
		String[]fixedOptions = optionFixer(result[0],mainChoosedFields);
		
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
	
	public static void doCurrencyConversion(double valueSelected,
											String[] conversionUnits) {
		
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
		
		result = (xToDollar[fromToIndex[0]] * valueSelected * dollarToX[fromToIndex[1]]);
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedResult = decimalFormat.format(result);

		JOptionPane.showMessageDialog(
				null,
				"El resultado es: $" + roundedResult + " " + conversionUnits[1],
				"Conversor de Divisas",
				JOptionPane.INFORMATION_MESSAGE);

		}
		
	public static void doTemperatureConversion(double valueSelected,
											String[] conversionUnits) {

		double result = 0;
				
		switch (conversionUnits[0]) {
		 
         case "Celsius":
             switch (conversionUnits[1]) {
                 case "Fahrenheit":
                	 result = (valueSelected * 9 / 5) + 32;
                	 break;
                 case "Kelvin":
                	 result = valueSelected + 273.15;
                	 break;
             }
             break;
             
         case "Fahrenheit": 
             switch (conversionUnits[1]) {
                 case "Celsius":
                	 result = (valueSelected - 32) * 5 / 9;
                	 break;
                 case "Kelvin":
                	 result = (valueSelected + 459.67) * 5 / 9;
                	 break;
             }
             break;
             
         case "Kelvin":
             switch (conversionUnits[1]) {
                 case "Celsius":
                	 result = valueSelected - 273.15;
                	 break;
                 case "Fahrenheit":
                	 result = (valueSelected * 9 / 5) - 459.67;
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
	
	public static boolean endProgram() {
		
		String[] options = {"Sí", "No", "Cancelar"};
        
        int selectedOption = JOptionPane.showOptionDialog(
        		null,
                "¿Desea continuar?",
                "Seleccione una opcion",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        
        if(selectedOption == JOptionPane.YES_OPTION) {return true;}
        
        JOptionPane.showMessageDialog(
				null,
				"Programa Finalizado",
				"Saliendo del programa",
				JOptionPane.INFORMATION_MESSAGE);
        
        return false;
		
	}
}
