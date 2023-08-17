package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class FlightBookingPage extends BaseClass {

	public FlightBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Economy')]")
	private WebElement economyClass;

	@FindBy(xpath = "(//ul[@class='ls-reset flex flex-middle noselect'])[2] //li[3]")
	private WebElement child;
	
	@FindBy(xpath = "(//ul[@class='ls-reset flex flex-middle noselect'])[1] //li[3]")
	private WebElement adult;
	

	@FindBy(xpath = "//input[@placeholder='Where from?']")
	private WebElement whereFrom;
	@FindBy(xpath = "//input[@placeholder='Where to?']")
	private WebElement whereTo;

	@FindBy(xpath = "(//ul[@class='airportList'])[1] //li[1]")
	private WebElement selectCity;
	@FindBy(css = "div[class$='homeCalender']>button:nth-of-type(1)")
	private WebElement calendar;
	@FindBy(xpath = "(//img[@loading='eager'])[4]")
	private WebElement scrollDown;
	
	@FindBy(css = "div[aria-label='Wed Sep 13 2023']")
	private WebElement tripDate;
	@FindBy(css = "div[aria-label='Wed Sep 14 2023']")
	private WebElement returnTripDate;
	@FindBy(xpath = "(//button[text()='Book'])[4]")
	private WebElement bookBtn;
	
	
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	private WebElement search;

	public void fromTrip(String city, String city2) throws InterruptedException {
		economyClass.click();
		Thread.sleep(1000);
		child.click();
		whereFrom.sendKeys(city);
		Thread.sleep(1000);
		selectCity.click();
		whereTo.sendKeys(city2);
		Thread.sleep(1000);
		selectCity.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		calendar.click();
		Thread.sleep(10000);
		tripDate.click();
		search.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		bookBtn.click();
	}
	public void toTrip(String city, String city2) throws InterruptedException {
		economyClass.click();
		Thread.sleep(1000);
		adult.click();
		child.click();
		whereFrom.sendKeys(city);
		Thread.sleep(1000);
		selectCity.click();
		whereTo.sendKeys(city2);
		Thread.sleep(1000);
		selectCity.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		calendar.click();
		Thread.sleep(10000);
		returnTripDate.click();
		search.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		bookBtn.click();

	}
	
}
