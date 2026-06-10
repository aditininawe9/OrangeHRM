package com.testingacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(locator));
    }

    public static boolean WaitForUrl(WebDriver driver, String partialUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(partialUrl));
    }

    public static WebElement elementToBeClickable(WebDriver driver, WebElement locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
