package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login("John Doe", "ThisIsNotAPassword");

        lp.logout();

        Assert.assertTrue(lp.isLoggedOut(), "Logout failed");

        System.out.println("Logout test passed");
    }
}