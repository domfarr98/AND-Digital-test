package com.and.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgorithmTests {

	@Test
	public void combine_strings_no_comma_test() {
		
		String[] strings = {"1","2","3","4"};
		
		assertEquals("1234", Solution.combineStrings(strings, false));
	}
	
	@Test
	public void combine_strings_comma_test() {
		
		String[] strings = {"1","2","3","4"};
		
		assertEquals("1,2,3,4", Solution.combineStrings(strings, true));
	}
	
	@Test
	public void swap_strings_front_test() {
		
		String[] strings = {"1","2","3","4"};
		
		String[] expectations = {"4","2","3","1"};
		
		assertArrayEquals(expectations, Solution.swapStrings(strings, "frontToBack"));
	}
	
	@Test
	public void swap_strings_back_test() {
		
		String[] strings = {"1","2","3","4"};
		
		String[] expectations = {"1","2","4","3"};
		
		assertArrayEquals(expectations, Solution.swapStrings(strings, "backToBack"));
	}
	
	@Test
	public void iterate_strings_forward_fest() {
		
		String[] strings = {"1","2","3","4"};
		
		String[] expectations = {"4","1","2","3"};
		
		assertArrayEquals(expectations, Solution.iterateStrings(strings, "forward"));
		
	}
	
	@Test
	public void iterate_strings_backward_test() {
		
		String[] strings = {"1","2","3","4"};
		
		String[] expectations = {"2","3","4","1"};
		
		assertArrayEquals(expectations, Solution.iterateStrings(strings, "backward"));
		
	}

}
