package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testingacademy.utils.WaitUtils.waitForVisibility;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By username = By.name("username");
    By password = By.name("password");
    By login = By.cssSelector("button[type='submit']");
    By errorMsg = By.xpath("//p[text()='Invalid credentials']");

    public void enterUsername(String user) {
        waitForVisibility(driver,username);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        waitForVisibility(driver,password);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        waitForVisibility(driver,errorMsg);
        return driver.findElement(errorMsg).getText();
    }
}
