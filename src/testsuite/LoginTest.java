package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest { //Extended Class

    String baseUrl = "http://the-internet.herokuapp.com/login";  // Webpage Url

    @Before
    public void setUp() {  //Set Up for Open Browser
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Input UserNameField
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith");
        //Input PasswordField
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on LoginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify Actual Message
        String expectedMessage = "Secure Area";
        WebElement actualTestElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("Message display", expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Input Invalid UserField
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith1");
        //Input Valid PasswordField
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the Actual Message
       String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTestElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("Message displayed", expectedMessage, actualMessage);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Input Valid UserName Field
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith");
        //Input Invalid Password Field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword");
        // Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //Verify the Actual Message
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        //actual result
        WebElement actualTestElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("Message displayed", expectedMessage, actualMessage);

        driver.close(); //Browser close


    }
}