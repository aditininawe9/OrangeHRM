package com.testingacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.testingacademy.utils.WaitUtils.waitForVisibility;

public class PIMPage {
    private WebDriver driver;
    @FindBy(xpath="//button[contains(.,'Add')]")
    private WebElement addButton;

    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(xpath="//button[normalize-space()='Save']")
    private WebElement saveButton;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployee() {
        waitForVisibility(driver,addButton).click();
    }

    public void addDetails() {
        waitForVisibility(driver,firstName).sendKeys("Aditi");
        waitForVisibility(driver,lastName).sendKeys("Aditi");

//        firstName.sendKeys("Aditi");
//        lastName.sendKeys("Soni");
        saveButton.click();
    }
}
