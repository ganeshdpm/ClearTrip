package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestOne extends BaseClass {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority=-2)
    public void testValidLoginUser_1() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @Test(priority=-1)
    public void testValidLoginUser_2() {
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @Test(priority=0)
    public void testValidLoginUser_3() {
        loginPage.login("problem_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @Test(priority=1)
    public void testValidLoginUser_4() {
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @Test(priority=2)
    public void testInvalidLogin() {
        loginPage.login("invalid@email.com", "invalidpassword");
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo/login"));
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
