package com.conversor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Class that contains the logic of the converter program, 
 * inside there are methods that perform the respective 
 * conversions of 2 main things, currency and temperature.<br><br>
 *
 *For currencies:<br><br>
 *
 *-Dollar<br>
 *-Mexican Peso<br>
 *-Sterling Pound<br>
 *-Japanese Yen<br>
 *-Korean Won Sul.Korean<br>
 *-Euro<br><br>
 *
 *The currency conversion is accomplished by initially converting any 
 *currency to US dollars, and subsequently using that value as the basis 
 *for conversion to the desired currency.<br><br>
 *
 *For temperature:<br><br>
 *
 *-Celsius<br>
 *-Fahrenheit<br>
 *-Kelvin<br><br>
 *
 *The method for temperature conversion involves applying 
 *the standard formulas outlined in scientific textbooks.
 * 
 * @author Daniel Mass Domínguez
 */
public class Logic {
		
	/**
	 * Constant values used to convert dollars to any currency
	 * The values are given in the following order:<br><br>
	 *  -Dollar<br>
		-Mexican Peso<br>
		-Sterling Pound<br>
		-Japanese Yen<br>
		-Korean Won Sul.Korean<br>
		-Euro<br>
	 */
	public static final double[] dollarToX = {
			1,
			17.0611,
			0.7884,
			145.4250,
			1335.7300,
			0.9168
	};
	
	/**
	 * Constant values used to convert any currency to dollars.
	 * The values are given in the following order:<br><br>
	 *  -Dollar<br>
		-Mexican Peso<br>
		-Sterling Pound<br>
		-Japanese Yen<br>
		-Korean Won Sul.Korean<br>
		-Euro<br>
	 */
	public static final double[] xToDollar = {
			1,
			0.0586,
			1.2685,
			0.0069,
			0.00075,
			1.0907
	};
	
	/**
	 * Names of the currencies handled:<br><br>
	 *  -Dollar<br>
		-Mexican Peso<br>
		-Sterling Pound<br>
		-Japanese Yen<br>
		-Korean Won Sul.Korean<br>
		-Euro<br>
	 */
	public static final String[] currencies = {
			 "Dolar",
			 "Peso Mexicano",
			 "Libras Esterlinas",
			 "Yen Japones",
			 "Won Sul.coreano",
			 "Euros"
	};
	
	/**
	 * Names of the temperature units handled:<br><br>
	 *  -Celsius<br>
		-Fahrenheit<br>
		-Kelvin<br>
	 */
	public static final String[] temperatureScales = {
			 "Celsius",
			 "Fahrenheit",
			 "Kelvin"
	};
	
	/**
	 * Names of the conversions handled:<br><br>
	 *  -Currencies<br>
		-Temperature<br>
	 */
	public static final String[] mainOptions = {
			 "Divisas",
			 "Temperatura"
	};
	
	/**
	 * This method removes the previously selected currency 
	 * or temperature option,preventing redundant conversions 
	 * within the same currency or temperature scale.<br><br>
	 * 
	 * @param optionToErase
	 * 
	 * @param originalOptions
	 * 
	 * @return (String[]) an array of Strings filled with all the 
	 * options except the one previously selected.
	 */
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

	/**
	 * This method shows a message using JOptionPane in which 
	 * the user is asked for the conversion he/she wants to make 
	 * (For this version only currency and temperature conversions 
	 * are allowed).<br><br>
	 *
	 * In case the user does not select any option the method will 
	 * throw an exception of the ConverterException type, this exception 
	 * serves mainly to stop the whole operation of the program.
	 * 
	 * @return (String) a String containing the user-selected conversion 
	 * type value. (These values are sourced from mainOptions()).
	 */
	public static String requestMainOption() {
	
		String choosedOption = (String) JOptionPane.showInputDialog(
				null,
				"Selecciona lo que deseas convertir",
				"Conversor",
				JOptionPane.QUESTION_MESSAGE,
				null,
				mainOptions,
				mainOptions[0]);
		
		if(choosedOption == null)throw new ConverterException();

		return choosedOption;
		
	}
	
	/**
	 * This method shows a message using JOptionPane in which 
	 * the user is asked for the value he/she wants to convert.<br><br>
	 *
	 * If the user selects a negative or zero value, the method will trigger
	 * an NumberFormatException type exception. This exception will be caught within 
	 * the same method, which will establish a loop until the user inputs a 
	 * valid number.<br><br>
	 *
	 * In case the user does not select any option the method will 
	 * throw an exception of the ConverterException type, this exception 
	 * serves mainly to stop the whole operation of the program.
	 * 
	 * @param mainChoosedOption
	 * 
	 * @return (Double) The number added by the user.
	 */
	public static double requestValueToConvert(String mainChoosedOption) {
		
		double choosedValue = 0;
		
		boolean  notAValidNumber = true;
		
		while (notAValidNumber) {
			
			try {
				
				String getValue = (String)JOptionPane.showInputDialog(
						null,
						"Inserte la cantidad a convertir",
						"Conversor de " + mainChoosedOption,
						JOptionPane.QUESTION_MESSAGE,
						null,
						null,
						"0");
				
				if(getValue == null)throw new ConverterException();
				
				choosedValue = Double.parseDouble(getValue);
				
				if(choosedValue <= 0)throw new NumberFormatException();
				
				notAValidNumber = false;
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
						null,
						"No se aceptan numeros menores o igual a cero, "
						+ " letras ni "
						+ "caracteres especiales",
						"Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}	
		
		return choosedValue;
		
	}
	
	/**
	 * This method shows a message using JOptionPane in which 
	 * the user is asked for the Conversion Units he/she wants to convert.<br><br>
	 * 
	 * In case the user does not select any option the method will 
	 * throw an exception of the ConverterException type, this exception 
	 * serves mainly to stop the whole operation of the program.<br><br>
	 * 
	 * @param mainChoosedOption @see mainOptions
	 * @param mainChoosedFields @see currencies or temperatureScales
	 * @return (String[]) An array of 2 strings that contains the desired 
	 * conversion units, the first position being the unit to convert from 
	 * and the second the unit to convert to.
	 */
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
		
		if(result[1] == null)throw new ConverterException();
	
		return result; 
	}
	
	/**
	 * This method performs the conversion of currencies.<br><br>
	 * 
	 *The currency conversion is accomplished by initially converting any 
	 *currency to US dollars, and subsequently using that value as the basis 
	 *for conversion to the desired currency.<br><br>
	 *
	 *The result is showed in a JOptionPane.
	 * 
	 * @param valueSelected @see requestValueToConvert()
	 * @param conversionUnits @see requestConversionUnits()
	 */
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
		
	/**
	 * This method performs the conversion of Temperatures.<br><br>
	 * 
	 *The method for temperature conversion involves applying 
	 *the standard formulas outlined in scientific textbooks.<br><br>
	 *
	 *The result is showed in a JOptionPane.
	 * 
	 * @param valueSelected @see requestValueToConvert()
	 * @param conversionUnits @see requestConversionUnits()
	 */
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
	
	/**
	 * This method is used to exit the program, the Main class 
	 * consists of a While loop which can only be exited by setting 
	 * the @see keepOnProgram variable to True.<br><br>
	 * 
	 * @return (boolean) this boolean let you exit the while loop of
	 * the Main Class if true.
	 */
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
        
        return false;
		
	}
}
