package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Factory.DriverFactory;

public class HomePage {

	WebDriver driver = DriverFactory.getdriver();

	//Object Repository:
	
	private By searchbar = By.xpath("//input[@class='gLFyf gsfi']");
	private By resultlisted = By.xpath("//ul[@class='erkvQe']//div[@class='sbl1']//span");
	private By logo = By.xpath("//img[@class='lnXdpd']");
	private By searchbutton = By.xpath("//input[@class='gNO89b']");

	
	// Action 
	
	public String getpagetitle() {
		return driver.getTitle();
	}

	
	public boolean validatelogo() {
		return driver.findElement(logo).isDisplayed();
	}

	
	public Resultpage searchlink(String searchwith) {
		driver.findElement(searchbar).sendKeys(searchwith);
		List<WebElement> suggestList = driver.findElements(resultlisted);
		System.out.println("size of the suggested list is :: " + suggestList.size());

		for (WebElement e : suggestList) {
			if (e.getText().equals(searchwith)) {
				e.click();
				break;
			}
		}
		return new Resultpage();
	}

	
	public boolean validatesearchbutton() {
		return driver.findElement(searchbutton).isEnabled();
	}
	
	public void clickonsearchbutton() {
		driver.findElement(searchbar).clear();
		WebElement button= driver.findElement(searchbutton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		}
	
	
	
}
