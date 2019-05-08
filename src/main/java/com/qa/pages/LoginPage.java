package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement featureLink;
	
	@FindBy(xpath="//a[contains(text(),'Security')]")
	WebElement SecurityLink;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		System.out.println("Title of login page: "+driver.getTitle());
		return driver.getTitle();
	}
	
	public SecurityPage clickFeatureSecurityLink(){
		Actions act = new Actions(driver);
		
		act.moveToElement(featureLink).build().perform();
		SecurityLink.click();
		    	
		return new SecurityPage();
	}
	
	
}
