package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods {//will also extend BaseClass

	@BeforeMethod// will execute before every method 
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod//will be after each method
	public void quitBrowser() {
		tearDown();
	}

	// @Test
	public void titleValidation() throws Exception {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();//we use driver bc in common methods
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		} else {
			System.out.println("titleValidation failed");
			throw new Exception();
		}
		Thread.sleep(2000);
	}

	// @Test
	public void logoValidation() throws Exception {
		String logoPath = "//div[@id='divLogo']/img";//we add /img to find image
		WebElement logo = driver.findElement(By.xpath(logoPath));
		boolean isDisplayed = logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("logoValidation passed");
		} else {
			System.out.println("logoValidation failed");
			throw new Exception();
		}
		Thread.sleep(2000);
	}

	@Test
	public void validLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
//		sendText(username, "Admin");    hardcoding
		sendText(username, ConfigsReader.getProperty("username"));//we can get the usernae from 
																//configs folder

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));//get pass form configs folder

		click(driver.findElement(By.id("btnLogin")));

		// HW
		// Validate that Welcome Admin is displayed
		// Check the reports in test-output folder
		Thread.sleep(2000);

	}
}