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
        driver.get("http://gmail.com");
        //Fill in usr/pass
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("taolavua12@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        //Click signin
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("thanhylau1");


        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        //Thread.sleep(20000);
        //verify usr did sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exit", driver.findElements(By.partialLinkText("Inbox")).size() > 0);


        //Click on Compose to create new email
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();

        WebElement toTextbox = driver.findElement(By.cssSelector("textarea[aria-label='To']"));
        toTextbox.sendKeys("amely.vn@gmail.com");
        toTextbox.sendKeys(Keys.ENTER);


        //Enter email subject
        WebElement subjectInput = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        final String subject = "Email is send automatic";
        subjectInput.clear();
        subjectInput.sendKeys(subject);

        //Enter email body
        WebElement bodyTextArea =  driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        final String bodytext = "This emial is for automation testing";
        bodyTextArea.clear();
        bodyTextArea.sendKeys(bodytext);
        Thread.sleep(10000);

        //Click Send
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendButton.click();
        Thread.sleep(5000);

        //Go to sent mail to check
        WebElement sentMailButton = driver.findElement(By.linkText("Sent Mail"));
        sentMailButton.click();
        Thread.sleep(10000);
        WebElement sentMailCheck =  driver.findElement(By.xpath("//tr[td//span = 'Email is send automatic']"));
        sentMailCheck.click();

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
        WebElement profileButton =  driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
        profileButton.click();

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(20000);

        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        signOutButton.click();


    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
