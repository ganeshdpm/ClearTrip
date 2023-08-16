package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    
}
