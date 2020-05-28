package com.class01;

import org.testng.annotations.Test;

//TEST NG IS A TOOL JUST LIKE SELENIUM IS!
//we have 3 scenarios/test cases
	import org.testng.annotations.Test;

	public class TestNGDemo {

		@Test
		public void testOne() {
			System.out.println("Step 1");
			System.out.println("Step 2");
			System.out.println("Step 3");
		}

		@Test
		public void testTwo() {
			System.out.println("Test Case 2");
		}

		@Test
		public void testThree() {
			System.out.println("Test Case 3");
		}

	}

//when you run it, test three is executed first then two bc they are run in alphabetical order