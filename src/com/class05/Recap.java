package com.class05;

import org.testng.annotations.Test;

public class Recap {

	@Test
	public void arrayRecap() {
		Object[][] data = new Object[2][3];
		data[0][0] = 12;
		data[0][1] = 13;
		data[0][2] = 14;

		data[1][0] = 100;

		System.out.println(data[1][1]);
	}

}
