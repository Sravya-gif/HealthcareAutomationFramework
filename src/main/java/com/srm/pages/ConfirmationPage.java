package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    By facility = By.id("facility");
    By date = By.id("visit_date");

    public String getFacility() {
        return waitForElement(facility).getText();
    }

    public String getDate() {
        return waitForElement(date).getText();
    }
    
    public boolean isConfirmationDisplayed() {
        try {
            return waitForElement(facility).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}