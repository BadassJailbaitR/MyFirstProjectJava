package com.emi.common;


import com.emi.Interfaces.RunnableScreen;
import com.emi.log;

public class Initializer {

	private static RunnableScreen Screen = new log();
	
	public static void main(String[] args) {
		Screen.run();
	}
}