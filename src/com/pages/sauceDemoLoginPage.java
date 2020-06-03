package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.CommonMethods;
public class sauceDemoLoginPage extends CommonMethods {
	@FindBy (id="user-name")
	public static WebElement userName;
	
	
	@FindBy (id="password")
	public WebElement password;
	
	@FindBy (xpath="//input [@value='LOGIN']")
	public WebElement LoginBTN;
	
	@FindBy (xpath="//div [text()='Products']")
	public WebElement productLogo;
	
	@FindBy (xpath="//h3 [@data-test='error']")
	public WebElement errorMEssage;
	
	public sauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
}