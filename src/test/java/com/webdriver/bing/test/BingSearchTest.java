package com.webdriver.bing.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import com.webdriver.bing.pages.BingHomePage;
import com.webdriver.bing.util.DriverFactory;

public class BingSearchTest {
	
	private WebDriver driver;
	//String URL;
	
	@Before
	public void setUp() {
		String browser = System.getProperty("Browser");
		driver = new DriverFactory(driver).getDriver(browser);
		//driver.get("http://www.bing.com");
		driver.get(System.getProperty("URL"));
	}
	
	@Test
	public void BingTest() {
		new BingHomePage(driver).BingTest();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}
