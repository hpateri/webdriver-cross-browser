package com.webdriver.bing.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	private WebDriver driver;
	
	public DriverFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver(String browser) {
	
		if("firefox".equals(browser))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if("chrome".equals(browser))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); //To maximize the browser
			options.addArguments("--test-type");  //To get rid off 'ignore certificate errors' message           options.addArguments("--kiosk");  //To enable full screen mode
			options.addArguments("chrome.switches","--disable-extensions");
			driver = new ChromeDriver(options);
		}
		else if("iexplore".equals(browser))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
			System.setProperty("webdriver.ie.driver", "src/test/resources/Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
		}
		
		return driver;
	}


}
