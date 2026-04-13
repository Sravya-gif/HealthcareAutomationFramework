package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import com.srm.base.BasePage;

public class HistoryPage extends BasePage {

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    By menu = By.id("menu-toggle");
    By history = By.linkText("History");

    By historyCards = By.xpath("//div[@class='panel panel-info']");

    public void goToHistory() {

        waitForElement(menu).click();
        waitForElement(history).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(historyCards));
    }

    public int getHistoryCount() {
        List<WebElement> list = driver.findElements(historyCards);
        return list.size();
    }
}