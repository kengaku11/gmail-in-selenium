package com.appsenseca.pageobjet;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bryan on 6/13/2016.
 */
public class SignInPage {

    public void fillInUsername(WebDriver driver, String mail){
        WebUtil.clearAndSendKeys(driver,By.id("Email"),mail);

}
    public void clickNextButton(WebDriver driver){
        WebUtil.click(driver,By.id("next"));

    }
    public void fillPassword(WebDriver driver, String psw){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebUtil.clearAndSendKeys(driver,(By.id("Passwd")),psw);
    }
    public EmailHomepage clickSignInButton(WebDriver driver)  {
        WebUtil.click(driver,By.id("signIn"));
        //Thread.sleep(20000);
        WebUtil.waitForElementVisible(driver,By.partialLinkText("Inbox"));
        return PageFactory.initElements(driver,EmailHomepage.class);
    }

}
