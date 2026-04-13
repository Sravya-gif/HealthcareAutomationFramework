package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class AppointmentTest extends BaseTest {

    @Test
    public void bookAppointmentTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        Assert.assertTrue(lp.isLoginSuccessful(), "Login failed!");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.bookAppointment("Tokyo CURA Healthcare Center", "25/04/2026", "Test");

        ConfirmationPage cp = new ConfirmationPage(driver);

        Assert.assertEquals(cp.getFacility(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(cp.getDate(), "25/04/2026");
    }
}