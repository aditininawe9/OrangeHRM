package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.pages.AdminPage;
import com.testingacademy.pages.DashboardPage;
import com.testingacademy.pages.LoginPage;
import com.testingacademy.pages.PIMPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void setup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test
    public void testValidLogin() {
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
        Assert.assertTrue(adminPage.addUserDisplayed());
    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeData() {
        return new Object[][] {
                {"Aditi","Soni","KA1220120012345","2026-07-16","Indian","Female"},
        };
    }
    @Test(dataProvider = "employeeData")
    public void testNavigateToPIM(String firstName, String lastName, String licenseNumber, String eDate, String nationality, String gender) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToPIMMenu();

        PIMPage pimPage = new PIMPage(driver);
        pimPage.addEmployee();
        pimPage.addDetails(firstName, lastName);

        pimPage.addPersonalDetails(
                firstName,
                lastName,
                licenseNumber,
                eDate, nationality, gender);
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
    }
}