package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class SecurityPage extends TestBase {


	@FindBy(xpath = "//a[contains(text(), 'Security basics')]")
	WebElement securityBasicsLink;
	
	
	
	// Initializing the Page Objects:
	public SecurityPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifySecurityPageTitle(){
		System.out.println("SecurityPage tile is: "+driver.getTitle());
		return driver.getTitle();
	}
	
	
	public SecurityBasicsPage clickSecurityBasicLink(){
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", securityBasicsLink);
		return new SecurityBasicsPage();
	}

}
