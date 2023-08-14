package com.conversor;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		
		String[] mainOptions= {
				 "Divisas",
				 "Temperatura"
		};
		
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
       } else {
           JOptionPane.showMessageDialog(
                   null,
                   "Ninguna opcion seleccionada, cerrando programa",
                   "Conversor",
                   JOptionPane.WARNING_MESSAGE);
       }
       
	}

}
