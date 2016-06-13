package com.appsenseca.pageobjet;

import org.openqa.selenium.By;
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
}
