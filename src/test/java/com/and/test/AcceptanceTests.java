package com.and.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class AcceptanceTests {

	@Test
	public void acceptance_one() {
		
		String result = Solution.solution("362");
		
		assertEquals(result, "632,623,362,326,263,236");
	}
	
	@Test
	public void acceptance_two() {
		
		String result = Solution.solution("A 3B2 C6D");
		
		assertEquals(result, "632,623,362,326,263,236");
	}
	
	@Test
	public void acceptance_three() {
		
		String result = Solution.solution("ABC");
		
		assertEquals(result, "Please enter a valid input with integers");
	}

}
