package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class ValidationTest extends BaseTest {

    @Test
    public void emptyLoginValidationTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("", "");

        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "Login should not work with empty fields");

        System.out.println("Login should not work with empty fields");
    }

    @Test
    public void emptyDateValidationTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);

        ap.bookAppointment("Tokyo CURA Healthcare Center", "", "Test");

        ConfirmationPage cp = new ConfirmationPage(driver);

        boolean isConfirmed = cp.isConfirmationDisplayed();

        Assert.assertFalse(isConfirmed,
                "Appointment should not be booked without date");

        System.out.println("Appointment should not be booked without date");
    }
}