package com.and.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
    	
    	ArrayList<Integer> preNumbers = new ArrayList<Integer>();
    	
    	String numberNet = "0123456789";
    	
    	// check for non-numbers
    	for (int i = 0; i<input.length(); i++) {
    		String currentChar = Character.toString(input.charAt(i));
    		if (numberNet.contains(currentChar)) {
    			preNumbers.add(Integer.parseInt(currentChar));
    		}
    	}
    	
    	// if no numbers, return error message
    	if (preNumbers.size() == 0) {
    		return "Please enter a valid input with integers";
    	}
    	
    	// if only one number, return it
    	if (preNumbers.size() == 1) {
    		return Integer.toString(preNumbers.get(0));
    	}
    	
    	// arrange the characters to be in ascending order
    	Collections.sort(preNumbers);
    	
    	String[] numbers = new String[preNumbers.size()];
    	
    	// transfer preNumbers to numbers
    	for (int i=0; i<numbers.length; i++) {
    		numbers[i] = Integer.toString(preNumbers.get(i));
    	}
    	
    	// get the number of possible combinations
    	int x = 2;
    	int numberOfSiblings = 1;
    	for (int i = 0; i<numbers.length-1; i++) {
    		numberOfSiblings = numberOfSiblings * x;
    		x++;
    	}
    	
    	String[] ANDSiblings = new String[numberOfSiblings];
    	
    	// create all AND-Sibling variants
    	for (int i=0; i<numberOfSiblings; i++) {
    		
    		if (i % 6 == 1 || i % 6 == 3 || i % 6 == 5) {
    			
        		numbers = swapStrings(numbers, "backToBack");
        		ANDSiblings[i] = combineStrings(numbers, false);
	    	
    		}
    		
    		else if (i % 6 == 0) {
    		
    			numbers = swapStrings(numbers, "frontToBack");
	    		ANDSiblings[i] = combineStrings(numbers, false);
	    	
    		}
    		
    		else if (i % 6 == 2) {
    			
    			numbers = iterateStrings(numbers, "forward");
	    		ANDSiblings[i] = combineStrings(numbers, false);
	    		
    		}
    		
    		else if (i % 6 == 4) {
    			
    			numbers = iterateStrings(numbers, "backward");
	    		ANDSiblings[i] = combineStrings(numbers, false);
    			
    		}
    		
    	}
    	
        return combineStrings(ANDSiblings, true);
    }
    
    // created the following methods to keep the solution above as repeat-free as possible.
    
    public static String combineStrings(String[] numbers, boolean withComma) {
    	
    	if(withComma) {
	    	String result = "";
	    	
	    	for (int i = 0; i<numbers.length; i++) {
	    		
	    		if (i == numbers.length-1) {
		    		result = result + numbers[i];
	    		}
	    		else {
	    			result = result + numbers[i] + ",";
	    		}
	    	}
	    	
	    	return result;
    	}
    	
    	else {
	    	String result = "";
	    	
	    	for (int i = 0; i<numbers.length; i++) {
	    		result = result + numbers[i];
	    	}
	    	
	    	return result;
    	}
    	
    }
    
    public static String[] swapStrings(String[] numbers, String places) {
    	
    	String[] result = numbers;
    	
    	String temp;
    	
    	switch(places) {
    	
    		case("frontToBack"):
    			
    			temp = result[0];
    			result[0] = result[numbers.length-1];
    			result[numbers.length-1] = temp;
    			
    			break;
    		
    		case("backToBack"):
    			
    			temp = result[numbers.length-2];
    			result[numbers.length-2] = result[numbers.length-1];
    			result[numbers.length-1] = temp;
    			
    			break;
    	
    	}
    	
    	return result;
    	
    }
    
    public static String[] iterateStrings(String[] numbers, String direction) {
    	
    	String[] result = new String[numbers.length];
    	
    	switch(direction) {
    	
    		case("forward"):
    			
    			result[0] = numbers[numbers.length-1];
    			
    			for(int i=0; i<numbers.length-1; i++) {
    				
    				result[i+1] = numbers[i];
    				
    			}
    			
    			return result;
    			
    		case("backward"):
    			
    			String temp = numbers[0];
    			
    			for(int i=1; i<numbers.length; i++) {
    				
    				result[i-1] = numbers[i];
    				
    			}
    			
    			result[result.length-1] = temp;
    			
    			return result;
    		
    		default:
    			return null;
    	
    	}
    	
    }

    public static void main(String args[]) {
        //System.out.println(solution("A 3B2 C6D"));
    	System.out.println(solution("A 3B2 C6D"));
    }

}
