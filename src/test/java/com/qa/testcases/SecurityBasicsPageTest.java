package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SecurityBasicsPage;
import com.qa.pages.SecurityPage;
import com.qa.util.TestUtil;

public class SecurityBasicsPageTest extends TestBase {
	LoginPage loginPage;
	TestUtil testUtil;
	SecurityPage securityPage;
	SecurityBasicsPage securityBasicsPage;

	public SecurityBasicsPageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		securityPage = new SecurityPage();
		
		securityPage = loginPage.clickFeatureSecurityLink();
		securityBasicsPage = securityPage.clickSecurityBasicLink();
	}
	
	
	@Test(priority=1)
	public void verifySearchResults(){
		String searchResultsText = securityBasicsPage.verifySearchResults();
		if(searchResultsText.contains(TestUtil.SEARCH_BAR_TEXT)) {
			System.out.println("Correct text is being searched on Security Basic Page");
		}
		else {
			System.out.println("Text is not correctly searched on Security Basic Page");
		}
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
