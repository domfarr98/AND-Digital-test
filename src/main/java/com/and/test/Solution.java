package com.and.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
    	
    	ArrayList<String> numbers = new ArrayList<String>();
    	
    	String numberNet = "0123456789";
    	
    	// check for non-numbers
    	for (int i = 0; i<input.length(); i++) {
    		String currentNumber = Character.toString(input.charAt(i));
    		if (numberNet.contains(currentNumber)) {
    			numbers.add(currentNumber);
    		}
    	}
    	
    	String result = "";
    	
    	// add all numbers to one string
    	for (int i = 0; i<numbers.size(); i++) {
    		result = result + numbers.get(i);
    	}
    	
        return result;
    }

    public static void main(String args[]) {
        System.out.println(solution("326"));
    }

}
