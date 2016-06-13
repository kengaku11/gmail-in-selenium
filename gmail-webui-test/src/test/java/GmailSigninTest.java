import com.appsenseca.pageobjet.EmailHomepage;
import com.appsenseca.pageobjet.SignInPage;
import com.appsenseca.util.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bryan on 6/12/2016.
 */
public class GmailSigninTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void gmailLoginShouldBeSuccessful() throws InterruptedException {
        //Go to Email
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        signInPage.fillInUsername(driver, "taolavua12@gmail.com");
        signInPage.clickNextButton(driver);
        signInPage.fillPassword(driver,"thanhylau1");
        //Click signin
        //SignInPage.clickSignInButton(driver);
        EmailHomepage emailHomepage = signInPage.clickSignInButton(driver);
        //verify usr did sign in
        Assert.assertTrue("Inbox should exit", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        //sign out
        signInPage = emailHomepage.signOut(driver);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(20000);
        //verified usr did sign out
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        Assert.assertTrue("Signin button should exits", emailHomepage.isInboxExist(driver));
        //Assert.assertTrue("Signin butotn should exits", driver.findElements(By.id("signIn")).size()>0);
    }

    @Test
    public void gmailSendAndRecieveEmailTest() throws InterruptedException {
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        signInPage.fillInUsername(driver, "taolavua12@gmail.com");
        signInPage.clickNextButton(driver);
        signInPage.fillPassword(driver,"thanhylau1");
        //Click signin
        //SignInPage.clickSignInButton(driver);
        EmailHomepage emailHomepage = signInPage.clickSignInButton(driver);
        //verify usr did sign in
        Assert.assertTrue("Inbox should exit", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

        //Click on Compose to create new email
        emailHomepage.clickComposeButton(driver);
        emailHomepage.enterEmailTo(driver, "amely.vn@gmail.com");
        //Enter email subject
        String sbj = "Subject of Email is Subject no.1";
        emailHomepage.enterSubject(driver,sbj);
        //Enter email body
        String bodytext= "This email is sent automatic, please don't reply this email";
        emailHomepage.enterEmailBody(driver,bodytext);
        Thread.sleep(10000);
        //Click Send
        emailHomepage.clickSendButton(driver);
        Thread.sleep(5000);
        //Go to sent mail to check
        emailHomepage.goToSentMail(driver,sbj);
        Thread.sleep(5000);
        String verifyText = driver.findElement(By.xpath("//div[@class='ii gt adP adO']")).getText();
        if(verifyText.contains(bodytext)){
            System.out.println("Body Text is correct: " + bodytext);
        }else{
            System.out.println("Body text is INCORRECT");
        }


       //List<WebElement> bodyCheck =  driver.findElement(By.xpath(".//div[@class='ajR']"));
        //System.out.println(bodyCheck.size());
        //Thread.sleep(30000);
        //if(bodyCheck.size()>0){
        //    bodyCheck.get(bodyCheck.size()-1).click();
        //    Thread.sleep(30000);
        //}
        //WebElement profileButton =  driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
        //profileButton.click();

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
        signInPage = emailHomepage.signOut(driver);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(20000);

        //WebElement signOutButton = driver.findElement(By.id("gb_71"));
        //signOutButton.click();


    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
