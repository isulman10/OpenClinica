package com.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;

public class Resultpage {
	
	
	
	WebDriver driver = DriverFactory.getdriver();
	
	
	
	public String get_title_after_search() {
		return driver.getTitle();
	}

}
