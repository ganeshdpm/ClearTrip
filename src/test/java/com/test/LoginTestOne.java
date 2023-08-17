package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.FlightBookingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestOne extends BaseClass {

	FlightBookingPage flightBookingPage;

	@BeforeMethod
	public void setup() {
		WebDriver driver = launchBrowser();
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		flightBookingPage = PageFactory.initElements(driver, FlightBookingPage.class);
	}

	@Test(priority = -2)
	public void fromTrip() throws InterruptedException {
		flightBookingPage.fromTrip("Bengaluru", "Hyderabad");

	}
	@Test(priority = -1)
	public void toTrip() throws InterruptedException {
		flightBookingPage.toTrip("Hyderabad", "Bengaluru");
		

	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Capture screenshot
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotFile, new File("screenshots/" + result.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 driver.quit();
	}
}
