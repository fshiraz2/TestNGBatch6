package com.class02;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;
//two test cases open chrom go to website, enter valid username and password 
//and do another time but leave password empty
public class HW extends CommonMethods {
	

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();//is in  base class but better to extend common methods bc extends base class
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	// 1st way
	// @Test(dependsOnMethods = "invalidLogin" )
	// 2nd way
	// @Test(dependsOnMethods = { "invalidLogin" })
	// depending on multiple methods
	// @Test(dependsOnMethods = { "invalidLogin", "method2", "method3" })

	@Test(priority = 2, dependsOnMethods = { "invalidLogin" })
	public void validLogin() {
		// WebElement username = driver.findElement(By.id("txtUsername"));

		// 1st way (unproffesional way)
		// username.sendKeys(ConfigsReader.getProperty("username"));//is selenium def method

		// 2nd way
		// sendText(username, ConfigsReader.getProperty("username"));//in common methods

		// 3rd way, using Page Object Model and PageFactoryz(loginpageelemnts)
		LoginPageElements login = new LoginPageElements();//comes from loginpageelemnts class
		sendText(login.username, ConfigsReader.getProperty("username"));

		sendText(login.password, ConfigsReader.getProperty("password"));

		// 1st way
		// WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		// wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
		// login.loginBtn.click();

		// 2nd way
		// waitForClickability(login.loginBtn);
		// login.loginBtn.click();

		// 3rd way
		click(login.loginBtn);

		DashboardPageElements dashboard = new DashboardPageElements();

		boolean displayed = dashboard.logo.isDisplayed();
		if (displayed) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo not is displayed");
		}

		// 1st way
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		wait(1);
	}

	// @Test means Test Case = Scenario = Test Method
	// Case 1: if this test method is commented, it will not run
	// Depending method will throw an exception
	// @Test(priority = 3, enabled = true)

	// Case 2: if this test method is disabled, it will not run
	// Depending method will throw an exception
	// @Test(priority = 3, enabled = false)

	@Test(priority = 3)
	public void invalidLogin() throws Exception {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);

		String expectedText = "Password cannot be empty";
		String actualText = login.errorMsg.getText();
		boolean errorDisplayed = login.errorMsg.isDisplayed();

		if (errorDisplayed) {
			System.out.println("Error msg is displayed");

			if (expectedText.equals(actualText)) {
				System.out.println("Error msg is correct");
			} else {
				System.out.println("Error msg is not correct");
			}

		} else {
			System.out.println("Error msg is not displayed");
		}

		wait(1);

		// When the test fails an Exception is thrown
		throw new Exception();
	}

}