package com.appsenseca.util;

import com.appsenseca.pageobjet.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Bryan on 6/13/2016.
 */
public class WebUtil {
    final static int WAIT_TIME_OUT = 30;

    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");

        return PageFactory.initElements(driver,SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element =  driver.findElement(by);
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public static void clearAndSendKeys(WebDriver driver, By by, String sbj) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(sbj);
        //element.sendKeys(Keys.ENTER);
    }

}
