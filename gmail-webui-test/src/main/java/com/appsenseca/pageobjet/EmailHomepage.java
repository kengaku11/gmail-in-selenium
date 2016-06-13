package com.appsenseca.pageobjet;

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
        WebElement profileButton =  driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
        profileButton.click();
        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        signOutButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));

        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return driver.findElements(By.id("signIn")).size()>0;
    }

    public void clickComposeButton(WebDriver driver) {
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();
    }

    public void enterEmailTo(WebDriver driver, String to) {
        WebElement toTextbox = driver.findElement(By.cssSelector("textarea[aria-label='To']"));
        toTextbox.sendKeys(to);
        toTextbox.sendKeys(Keys.ENTER);
    }

    public void enterSubject(WebDriver driver, String sbj) {
        WebElement subjectInput = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        //final String subject = sbj;
        subjectInput.clear();
        subjectInput.sendKeys(sbj);
    }

    public void enterEmailBody(WebDriver driver, String body) {
        WebElement bodyTextArea =  driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        //final String bodytext = "This emial is for automation testing";
        bodyTextArea.clear();
        bodyTextArea.sendKeys(body);
    }

    public void clickSendButton(WebDriver driver) {
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendButton.click();
    }

    public void goToSentMail(WebDriver driver, String title) throws InterruptedException {
        WebElement sentMailButton = driver.findElement(By.linkText("Sent Mail"));
        sentMailButton.click();
        Thread.sleep(10000);
        WebElement sentMailCheck =  driver.findElement(By.xpath("//tr[td//span = '"+title + "']"));
        sentMailCheck.click();
    }
}
