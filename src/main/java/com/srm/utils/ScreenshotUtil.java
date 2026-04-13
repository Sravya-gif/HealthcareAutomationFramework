package com.srm.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import com.srm.driver.DriverFactory;

public class ScreenshotUtil {

    public static String capture(String testName) {

        WebDriver driver = DriverFactory.getDriver();

        String path = "screenshots/" + testName + "_" +
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}