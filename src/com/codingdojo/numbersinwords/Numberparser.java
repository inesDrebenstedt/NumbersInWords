package com.codingdojo.numbersinwords;

import java.util.TreeMap;

public class Numberparser {
	
	private static Character[] numbersAsChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static String zero = "zero";
	private static String one = "one";
	public static String two = "two";
	private static String three = "three";
	private static String four = "four";
	private static String five = "five";
	private static String six = "six";
	private static String seven = "seven";
	private static String eight = "eight";
	private static String nine = "nine";

	public TreeMap<Character, String> makeTreeMap() {

		TreeMap<Character, String> pairs = new TreeMap<Character, String>();

		pairs.put(numbersAsChars[0], zero);
		pairs.put(numbersAsChars[1], one);
		pairs.put(numbersAsChars[2], two);
		pairs.put(numbersAsChars[3], three);
		pairs.put(numbersAsChars[4], four);
		pairs.put(numbersAsChars[5], five);
		pairs.put(numbersAsChars[6], six);
		pairs.put(numbersAsChars[7], seven);
		pairs.put(numbersAsChars[8], eight);
		pairs.put(numbersAsChars[9], nine);

		return pairs;
	}

	// take Integer, determine how many digits
	public Integer countFigures(Integer inputNum) {
		Integer result = 0;

		String temp = String.valueOf(inputNum);
		result = temp.length();
		return result;
	}

	public String parseDigitToString(Integer inputNumber) {
		String result = String.valueOf(inputNumber);
		return result;
	}

	//for numbers up to 6 figures
	public String convertNumberToWord(Integer inputNumber) {

		String result = "";
		String numStr = parseDigitToString(inputNumber);
		String[] extensions = new String[countFigures(inputNumber)];
		String[] ext = { " ", "ty", "hundred", "thousand", "ty", "hundred" };

		for (int i = countFigures(inputNumber) - 1; i >= 0; i--) {
			extensions[countFigures(inputNumber) - 1 - i] = ext[i];
		}

		String result2 = "";
		
		//each digit of inputNumber is compared to element of numbersAsChars.
		//When they match, pull out corresponding word out of TreeMap and add matching extension according to digit position.
		for (int i = 0; i < countFigures(inputNumber); i++) {

			for (int k = 0; k < numbersAsChars.length; k++) {
				if (numStr.charAt(i) == numbersAsChars[k]) {
					result += makeTreeMap().get(numbersAsChars[k]) + extensions[i] + "   ";					
				}
			}
		}
		result2 = lingualCorrections(result.trim());
		System.out.println("Result: " + result2);

		return result2;
	}
	
	public String lingualCorrections(String incorrect) {
		
		while(incorrect.contains("onety   one")){
			incorrect = incorrect.replaceFirst("onety   one", "  eleven   ");
		}
		while(incorrect.contains("onety   two")){
			incorrect = incorrect.replaceFirst("onety   two", "  twelve   ");
		}
		while(incorrect.contains("onety   three")){
			incorrect = incorrect.replaceFirst("onety   three", "  thirteen   ");
		}
		while(incorrect.contains("onety   four")){
			incorrect = incorrect.replaceFirst("onety   four", "  fourteen   ");
		}
		while(incorrect.contains("onety   five")){
			incorrect = incorrect.replaceFirst("onety   five", "  fifteen   ");
		}
		while(incorrect.contains("onety   six")){
			incorrect = incorrect.replaceFirst("onety   six", "  sixteen   ");
		}
		while(incorrect.contains("onety   seven")){
			incorrect = incorrect.replaceFirst("onety   seven", "  seventeen   ");
		}
		while(incorrect.contains("onety   eight")){
			incorrect = incorrect.replaceFirst("onety   eight", "  eighteen   ");
		}
		while(incorrect.contains("onety   nine")){
			incorrect = incorrect.replaceFirst("onety   nine", "  nineteen   ");
		}
		
		String[] resultAsArray = incorrect.split("   ");
		String result = "";

		for (int i = 0; i < resultAsArray.length; i++) {

			if (resultAsArray[i].matches("zeroty")) {
				resultAsArray[i] = " ";
			}
			if (resultAsArray[i].contains("zerothousand")) {
				resultAsArray[i] = "thousand ";
			}
			if (resultAsArray[i].contains("zerothundred")) {
				resultAsArray[i] = " ";
			}
			if (resultAsArray[i].contains("zero")) {
				resultAsArray[i] = " ";
			}
			if (resultAsArray[i].contains("twoty")) {
				resultAsArray[i] = "twenty";
			}
			if (resultAsArray[i].contains("threety")) {
				resultAsArray[i] = "thirty";
			}
			if (resultAsArray[i].contains("fivety")) {
				resultAsArray[i] = "fifty";
			}
			if (resultAsArray[i].contains("eightty")) {
				resultAsArray[i] = "eighty";
			}

			result += resultAsArray[i].trim();
		}
			
		return result;
	}
}