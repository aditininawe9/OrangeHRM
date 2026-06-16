package com.testingacademy.pages;

import com.testingacademy.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//input[contains(@class,'oxd-input')])[2]")
    WebElement usernameInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath="//button[contains(@class,'oxd-button--ghost')]")
    WebElement resetButton;

    @FindBy(xpath="//button[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath="//h6[text()='Add User']")
    WebElement addUserHeader;

    public void searchByUserName(String userName) {
        WebElement usernameField = WaitUtils.waitForVisibility(driver, usernameInput);
        usernameField.sendKeys(userName);
        searchButton.click();
    }

    public void resetUser() {
        resetButton.click();
    }

    public void clikAddButton() {
        addButton.click();
    }

    public boolean addUserDisplayed() {
        WebElement addUser =  WaitUtils.waitForVisibility(driver, addUserHeader);
        return addUser.isDisplayed();
    }
}
