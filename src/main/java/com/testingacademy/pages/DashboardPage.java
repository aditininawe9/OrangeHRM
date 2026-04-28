package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.testingacademy.utils.WaitUtils.waitForVisibility;

public class DashboardPage {
    private WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By timeAtWorkWidget = By.xpath("//button[contains(@class,'orangehrm-attendance-card-action')]");

    public boolean isDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    public void clickAttendenceBtn() {
        waitForVisibility(driver, timeAtWorkWidget);
        driver.findElement(timeAtWorkWidget).click();
    }

}
