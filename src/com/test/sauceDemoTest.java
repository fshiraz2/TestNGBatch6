package com.test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.CommonMethods;
public class sauceDemoTest extends CommonMethods {
	@Test(dataProvider="getData",groups="sprint")
	public void loginToSauceDemo(String username,String password) {
		sendText(demosauce.userName, username);
		sendText(demosauce.password, password);
		click(demosauce.LoginBTN);
		wait(2);
		if(username.equals("locked_out_user")) {
			Assert.assertTrue(demosauce.errorMEssage.isDisplayed());
		}else {
			Assert.assertTrue(demosauce.productLogo.isDisplayed());
		}
		
	}
	@DataProvider(name="getData")
	public Object[][]getData(){
		Object [][] data=new Object[4][2];
		data [0][0]= "standard_user";
		data[0][1]="secret_sauce";
		
		data[1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		
		data[2][0]="problem_user";
		data[2][1]="secret_sauce";
		
		data[3][0]="performance_glitch_user";
		data[3][1]="secret_sauce";
		
		return data;
		
	}
}