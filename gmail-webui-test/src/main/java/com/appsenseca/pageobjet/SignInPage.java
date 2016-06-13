package com.appsenseca.pageobjet;

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
    WebElement usernameTextbox = driver.findElement(By.id("Email"));
    usernameTextbox.clear();
    usernameTextbox.sendKeys(mail);

}
    public void clickNextButton(WebDriver driver){
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
    }
    public void fillPassword(WebDriver driver, String psw){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(psw);
    }
    public EmailHomepage clickSignInButton(WebDriver driver)  {
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();
        //Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        return PageFactory.initElements(driver,EmailHomepage.class);
    }

}
