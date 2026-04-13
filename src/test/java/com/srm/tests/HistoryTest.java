package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class HistoryTest extends BaseTest {

    @Test
    public void verifyAppointmentInHistory() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.bookAppointment("Seoul CURA Healthcare Center", "26/04/2026", "History Test");

        HistoryPage hp = new HistoryPage(driver);
        hp.goToHistory();

        int count = hp.getHistoryCount();

        System.out.println("History count = " + count);

        Assert.assertTrue(count > 0, "No appointments found in history!");
    }
}