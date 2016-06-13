package com.appsenseca.util;

import com.appsenseca.pageobjet.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Bryan on 6/13/2016.
 */
public class WebUtil {

    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");

        return PageFactory.initElements(driver,SignInPage.class);
    }
}
