package com.qa.Factory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {


		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}

		getdriver().manage().window().maximize();
		getdriver().manage().deleteAllCookies();
		getdriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getdriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		

		return getdriver();
	}

	public static synchronized WebDriver getdriver() {
		return tldriver.get();
	}
}
