package com.testingacademy.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeMethod
    public void beforeMethod() {
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.quit();
//    }
}
