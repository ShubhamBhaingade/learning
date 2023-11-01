package com.cg.accountThird.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentDateToStringConverter {
    public static String convertCurrentDateToString(String dateFormatPattern) {
        LocalDate currentDate = LocalDate.now(); // Get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);
        return currentDate.format(formatter);
    }

    public static void main(String[] args) {
        String dateFormatPattern = "yyyy-MM-dd"; // The format pattern for the date

        String currentDateAsString = convertCurrentDateToString(dateFormatPattern);

        System.out.println("Current date as a string: " + currentDateAsString);
    }
}
//In this code:
//
//The convertCurrentDateToString method gets the current date using LocalDate.now(), then formats it into a String using the specified date format pattern.
//
//In the main method, we specify the date format pattern and call the convertCurrentDateToString method to get the current date as a string.
//
//The DateTimeFormatter is used to specify the format pattern for formatting the current date as a string.
//
//Make sure to import the necessary classes at the beginning of your Java file:
//
//java
//Copy code
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//This code allows you to convert the current date (LocalDate.now()) to a String in a specific format.





