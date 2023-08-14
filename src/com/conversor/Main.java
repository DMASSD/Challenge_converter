package com.conversor;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		
		String choosedMainOption = Logic.requestMainOption();
       
		String value = Logic.requestValueToConvert(choosedMainOption);
		
	}

}
