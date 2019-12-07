package com.neet.DiamondHunter.MapViewer;

public class MyException extends Exception {

	String message;
	/*
	 * This code is used to return error messages whenever the user places the boat
	 * and axe in an incorrect location
	 */

	/*
	 * The following line of code will point to error messages in the map control
	 * file
	 */
	MyException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}