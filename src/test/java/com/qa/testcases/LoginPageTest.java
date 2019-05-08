package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.SecurityPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	SecurityPage securityPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeSuite
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Bitcoin & Cryptocurrency Exchange | Bitcoin Trading Platform | Kraken");
	}
	
	
	@Test(priority=3)
	public void loginTest(){
		securityPage = loginPage.clickFeatureSecurityLink();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
