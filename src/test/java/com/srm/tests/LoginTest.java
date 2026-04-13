package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "data")
    public void loginTest(String user, String pass) {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        lp.login(user, pass);

        if (user.equals("John Doe") && pass.equals("ThisIsNotAPassword")) {

            Assert.assertTrue(lp.isLoginSuccessful(),
                    "Valid login should succeed");

            System.out.println("Valid login passed");

        } else {

            Assert.assertTrue(lp.isLoginFailed(),
                    "Invalid login should fail");

            System.out.println("Invalid login handled correctly");
        }
    }

    @DataProvider
    public Object[][] data() {
        return ExcelUtils.getData();
    }
}