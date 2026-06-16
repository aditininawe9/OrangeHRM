package com.testingacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.testingacademy.utils.WaitUtils.elementToBeClickable;

public class DashboardPage {
    private WebDriver driver;
    @FindBy(xpath="//span[text()='Admin']")
    WebElement adminMenu;

    @FindBy(xpath="//span[text()='PIM']")
    WebElement pimMenu;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToAdminMenu() {
        elementToBeClickable(driver, adminMenu).click();
    }

    public void navigateToPIMMenu() {
        elementToBeClickable(driver, pimMenu).click();
    }

}
