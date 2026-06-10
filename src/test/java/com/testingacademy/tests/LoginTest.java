package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.pages.AdminPage;
import com.testingacademy.pages.DashboardPage;
import com.testingacademy.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToAdminMenu();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("admin"));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));

        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchByUserName("Admin");
        adminPage.resetUser();
        adminPage.searchByUserName("Admin123");
        adminPage.resetUser();
        adminPage.clikAddButton();

        adminPage.addUserDisplayed();
        adminPage.selectUserRoleDropdown("Admin");
        adminPage.sendName("Paul");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
    }
}
