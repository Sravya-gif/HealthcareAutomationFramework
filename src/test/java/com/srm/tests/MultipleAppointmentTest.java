package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class MultipleAppointmentTest extends BaseTest {

    @Test
    public void multipleAppointmentsTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);

        ap.bookAppointment("Tokyo CURA Healthcare Center", "25/04/2026", "Test1");

        driver.findElement(org.openqa.selenium.By.linkText("Go to Homepage")).click();
        driver.findElement(org.openqa.selenium.By.id("btn-make-appointment")).click();

        ap.bookAppointment("Seoul CURA Healthcare Center", "26/04/2026", "Test2");

        HistoryPage hp = new HistoryPage(driver);
        hp.goToHistory();

        int count = hp.getHistoryCount();

        System.out.println("Total appointments = " + count);
        Assert.assertTrue(count >= 2, "Multiple appointments not found");
    }
}