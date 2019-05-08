package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SecurityBasicsPage;
import com.qa.pages.SecurityPage;
import com.qa.util.TestUtil;

public class SecurityPageTest extends TestBase {
	LoginPage loginPage;
	SecurityPage securityPage;
	SecurityBasicsPage securityBasicsPage;
	TestUtil testUtil;

	public SecurityPageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeSuite
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		securityPage = loginPage.clickFeatureSecurityLink();
	}
	
	
	@Test(priority=1)
	public void verifySecurityPageTitleTest(){
		String securityPageTitle = securityPage.verifySecurityPageTitle();
		Assert.assertEquals(securityPageTitle, "Cryptocurrency Security Protocols | Kraken");
	}
	
	
	@Test(priority=2)
	public void verifyclickSecurityBasicPageTest(){
		securityBasicsPage = securityPage.clickSecurityBasicLink();
	}
		
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	

}
