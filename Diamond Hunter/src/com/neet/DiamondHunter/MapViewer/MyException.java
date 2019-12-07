package com.neet.DiamondHunter.MapViewer;

public class MyException extends Exception{

	/*This code is used to return error messages whenever
	 * the user places the boat and axe in an incorrect location*/
    String message;

    
    /*The following line of code will point to error messages
     * in the map-controls file*/
    MyException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}