package com.conversor;

import javax.swing.JOptionPane;

public class Logic {
	
	private static String[] mainOptions= {
			 "Divisas",
			 "Temperatura"
	};
	
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
	
	public static String RequestValueToconvert(String choosedOption) {
		
		String choosedValue = (String) JOptionPane.showInputDialog(
		          null,
		          "Inserte la cantidad a convertir",
		          "Conversor de " + choosedOption,
		          JOptionPane.QUESTION_MESSAGE,
		          null,
		          null,
		          "0");

		if (choosedValue != null) {

		      JOptionPane.showMessageDialog(
		              null,
		              "La cantidad ingresada fue: " + choosedValue,
		              "Conversor de " + choosedOption,
		              JOptionPane.INFORMATION_MESSAGE);
		      return choosedValue;
		      
		} else {
		      JOptionPane.showMessageDialog(
		              null,
		              "No se ingreso ningun numero, cerrando programa.",
		              "Conversor de " + choosedOption,
		              JOptionPane.WARNING_MESSAGE);
		      return null;
		  }
		
	}
	
	
}
