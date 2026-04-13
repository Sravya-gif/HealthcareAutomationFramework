package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import com.srm.base.BasePage;

public class AppointmentPage extends BasePage {

    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    By facility = By.id("combo_facility");
    By date = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By bookBtn = By.id("btn-book-appointment");

    public void bookAppointment(String fac, String d, String c) {

        Select select = new Select(waitForElement(facility));
        select.selectByVisibleText(fac);

        driver.findElement(date).sendKeys(d);
        driver.findElement(comment).sendKeys(c);
        driver.findElement(bookBtn).click();
    }
}