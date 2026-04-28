package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.pages.DashboardPage;
import com.testingacademy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void loginSetup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isDashboardPage();
        Assert.assertTrue(dashboardPage.isDashboardPage());
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
    }

    @Test
    public void testDashboard() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAttendenceBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains("/attendance/punchIn"));
    }
}
