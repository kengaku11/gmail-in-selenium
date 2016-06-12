package com.appsenseca.pageobjet;

import com.appsenseca.util.WebUtil;
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
public class EmailHomepage {

    public SignInPage signOut(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("span[class='gb_3a gbii']"));

        WebUtil.click(driver,By.id("gb_71"));

        WebUtil.waitForElementVisible(driver,By.id("signIn"));

        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return driver.findElements(By.id("signIn")).size()>0;
    }

    public void clickComposeButton(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("div[role='button'][gh='cm']"));

    }

    public void enterEmailTo(WebDriver driver, String to) {
        WebUtil.clearAndSendKeys(driver,By.cssSelector("textarea[aria-label='To']"), to);

    }

    public void enterSubject(WebDriver driver, String sbj) {
        WebUtil.clearAndSendKeys(driver,By.cssSelector("input[name='subjectbox']"),sbj);

    }

    public void enterEmailBody(WebDriver driver, String body) {
        WebUtil.clearAndSendKeys(driver,By.cssSelector("div[aria-label='Message Body']"),body);

    }

    public void clickSendButton(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("div[aria-label*='Send']"));

    }

    public void goToSentMail(WebDriver driver, String title) throws InterruptedException {
        WebUtil.click(driver,By.linkText("Sent Mail"));
        Thread.sleep(10000);
        WebUtil.click(driver,By.xpath("//tr[td//span = '"+title + "']"));

    }
}
