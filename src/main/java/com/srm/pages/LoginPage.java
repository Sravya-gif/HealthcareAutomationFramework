package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By makeAppointment = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginBtn = By.id("btn-login");
    By appointmentBtn = By.id("btn-book-appointment");
    By menu = By.id("menu-toggle");
    By logout = By.linkText("Logout");
    By homePageBtn = By.id("btn-make-appointment"); // homepage indicator

    public void logout() {

        waitForElement(menu).click();
        waitForElement(logout).click();
    }

    public void goToLogin() {
        waitForElement(makeAppointment).click();
    }

    public void login(String user, String pass) {
        waitForElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        try {
            return waitForElement(appointmentBtn).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginFailed() {
        return driver.getCurrentUrl().contains("login");
    }
    
    public boolean isLoggedOut() {
        try {
            return waitForElement(homePageBtn).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}