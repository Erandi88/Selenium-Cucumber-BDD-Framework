package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public void NavigateToTMPage(WebDriver driver)
    {
        //Nevigate Time & material Page
        WebElement admintrationTab = driver.findElement(By.xpath("//a[normalize-space()='Administration']"));
        admintrationTab.click();

        Wait.WaitToBeClickable(driver, "xpath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 10);

        WebElement timeAndMaterialOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        timeAndMaterialOption.click();
    }
}
