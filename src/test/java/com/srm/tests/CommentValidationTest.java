package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CommentValidationTest extends BaseTest {

    @Test
    public void longCommentTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        String longText = "This is a very long comment for testing purpose "
                + "to check whether the application accepts long text without truncation.";

        AppointmentPage ap = new AppointmentPage(driver);
        ap.bookAppointment("Tokyo CURA Healthcare Center", "27/04/2026", longText);

        ConfirmationPage cp = new ConfirmationPage(driver);

        String comment = driver.findElement(org.openqa.selenium.By.id("comment")).getText();

        Assert.assertTrue(comment.contains("long comment"),
                "Comment truncated");

        System.out.println("Long comment validation passed");
    }
}