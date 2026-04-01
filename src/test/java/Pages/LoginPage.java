package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    public void LoginActions(WebDriver driver) throws InterruptedException {
        // Launch TurnUp portal
        driver.navigate().to("http://horse.industryconnect.io/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Identify username textbox and enter valid username
        try
        {
            // Identify username textbox and enter valid username
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");
        }
        catch(Exception ex)
        {
            Assert.fail("Username textbox not located.");
        }
        // Identify password textbox and enter valid password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");

        // Identify login buton and click on it
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();
        Thread.sleep(2000);
    }
}
