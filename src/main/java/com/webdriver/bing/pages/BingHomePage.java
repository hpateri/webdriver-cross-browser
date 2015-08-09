package com.webdriver.bing.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingHomePage extends AbstractPage {
	
	private WebDriver driver;
	
	public BingHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void BingTest() {
		driver.findElement(By.cssSelector(".b_searchbox")).clear();
		driver.findElement(By.cssSelector(".b_searchbox")).sendKeys("Facebook");
		driver.findElement(By.cssSelector("#sb_form_go")).submit();
		String actualTitle = driver.findElement(By.cssSelector(".b_algo:nth-of-type(1) > h2 > a > strong")).getText();
		Assert.assertEquals("Facebook", actualTitle);
	}
	

}
