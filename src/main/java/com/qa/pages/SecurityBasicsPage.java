package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class SecurityBasicsPage extends TestBase{

	@FindBy(xpath = "//form[@class='search']/input[@id='query']")
	WebElement searchBar;

	@FindBy(xpath = "//div[@class='search-results']/h1")
	WebElement searchResults;
	
	
	// Initializing the Page Objects:
	public SecurityBasicsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySearchResults(){
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String loginWindow = it.next();
		String securityBasicPageWindow = it.next();
		
		driver.switchTo().window(securityBasicPageWindow);
		
		System.out.println(driver.getTitle());
		searchBar.sendKeys(TestUtil.SEARCH_BAR_TEXT, Keys.ENTER);
		String searchResultsText = searchResults.getText();
		return searchResultsText;
	}
	
}
