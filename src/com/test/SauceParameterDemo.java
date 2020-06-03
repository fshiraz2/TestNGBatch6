package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.utils.CommonMethods;
public class SauceParameterDemo extends CommonMethods {
	@Parameters ({"username", "password"})
	@Test
	public void loginToSauceDemo(String username, String password) {
		sendText(demosauce.userName, username);
		sendText(demosauce.password, password);
		click(demosauce.LoginBTN);
		wait(2);
	}
}
