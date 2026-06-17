package com.testingacademy.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath="//label[normalize-space()=\"Driver's License Number\"]/following::input[1]")
    private WebElement licenseNumber;

    @FindBy(xpath = "//label[contains(.,'Date of Birth')]/following::input[1]")
    private WebElement dateField;

    @FindBy(xpath = "//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement nationalityDropdown;

    @FindBy(xpath = "//label[contains(.,'Male')]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//label[contains(.,'Female')]")
    private WebElement femaleRadioButton;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployee() {
        waitForVisibility(driver,addButton).click();
    }

    public void addDetails(String fName, String lName) {
        waitForVisibility(driver,firstName).sendKeys(fName);
        waitForVisibility(driver,lastName).sendKeys(lName);

        saveButton.click();
    }

    public void selectNationality(String nationality) {

        nationalityDropdown.click();

        driver.findElement(
                By.xpath("//div[@role='listbox']//span[text()='" + nationality + "']")
        ).click();
    }

    public void selectGender(String gender) {

        if(gender.equalsIgnoreCase("Male")) {
            maleRadioButton.click();
        }
        else if(gender.equalsIgnoreCase("Female")) {
            femaleRadioButton.click();
        }
    }

    public void addPersonalDetails(String fName, String lName, String license,
                                   String expiryDate, String country, String gen) {
        addDetails(fName, lName);
        waitForVisibility(driver, licenseNumber).sendKeys(license);
        waitForVisibility(driver, dateField).sendKeys(expiryDate);

        selectNationality(country);
        selectGender(gen);
        saveButton.click();
    }
}
